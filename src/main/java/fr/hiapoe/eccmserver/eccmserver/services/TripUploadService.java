package fr.hiapoe.eccmserver.eccmserver.services;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import fr.hiapoe.eccmserver.eccmserver.dto.CarLogUploadDTO;
import fr.hiapoe.eccmserver.eccmserver.entities.CarLog;
import fr.hiapoe.eccmserver.eccmserver.utils.TripImportSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TripUploadService {

    private final CarLogService carLogService;
    private final S3Service s3Service;
    private final CSVParser csvParser;
    public static final char SEPARATION_CHARACTER = '\t';

    public static String[] HEADER_LIST = {
        "DEVICE_TIME",
        "CAR ID",
        "TRIP ID",
        "ENGINE LOAD (percent)",
        "COOLANT TEMPERATURE",
        "SHORT FUEL TRIM 1 (percent)",
        "LONG FUEL TRIM 1 (percent)",
        "SHORT FUEL TRIM 2 (percent)",
        "LONG FUEL TRIM 2 (percent)",
        "FUEL PRESSURE (kilopascal)",
        "INTAKE_PRESSURE (kilopascal)",
        "RPM",
        "SPEED (kilometers per hour)",
        "TIMING ADVANCE (degree)",
        "INTAKE TEMPERATURE (degree celsius)",
        "Air Flow Rate (grams per second)",
        "THROTTLE POSITION (percent)",
        "AIR STATUS (status)",
        "O2 SENSORS (sensors)",
        "O2 BANK1 SENSOR1 (volt)",
        "O2 BANK1 SENSOR2 (volt)",
        "O2 BANK1 SENSOR3 (volt)",
        "O2 BANK1 SENSOR4 (volt)",
        "O2 BANK2 SENSOR1 (volt)",
        "O2 BANK2 SENSOR2 (volt)",
        "O2 BANK2 SENSOR3 (volt)",
        "O2 BANK2 SENSOR4 (volt)",
        "OBD COMPLIANCE",
        "O2 SENSORS PRESENT ALTERNATE",
        "AUX INPUT STATUS (boolean)",
        "ENGINE RUN TIME (second)",
        "DISTANCE TRAVELED WITH MIL on (kilometer)",
        "FUEL RAIL PRESSURE RELATIVE TO VACUUM (kilopascal)",
        "FUEL RAIL PRESSURE DIRECT INJECTION (kilopascal)",
        "O2 SENSOR1 WR LAMBDA VOLTAGE (volt)",
        "O2 SENSOR2 WR LAMBDA VOLTAGE (volt)",
        "O2 SENSOR3 WR LAMBDA VOLTAGE (volt)",
        "O2 SENSOR4 WR LAMBDA VOLTAGE (volt)",
        "O2 SENSOR5 WR LAMBDA VOLTAGE (volt)",
        "O2 SENSOR6 WR LAMBDA VOLTAGE (volt)",
        "O2 SENSOR7 WR LAMBDA VOLTAGE (volt)",
        "O2 SENSOR8 WR LAMBDA VOLTAGE (volt)",
        "COMMANDED EGR (percent)",
        "EGR ERROR (percent)",
        "EVAPORATIVE PURGE (percent)",
        "FUEL LEVEL (percent)",
        "WARMUPS SINCE DTC CLEAR (count)",
        "DISTANCE SINCE DTC CLEAR (kilometer)",
        "EVAPORATIVE VAPOR PRESSURE (pascal)",
        "BAROMETRIC PRESSURE (kilopascal)",
        "O2 SENSOR1 WR CURRENT (milliampere)",
        "O2 SENSOR2 WR CURRENT (milliampere)",
        "O2 SENSOR3 WR CURRENT (milliampere)",
        "O2 SENSOR4 WR CURRENT (milliampere)",
        "O2 SENSOR5 WR CURRENT (milliampere)",
        "O2 SENSOR6 WR CURRENT (milliampere)",
        "O2 SENSOR7 WR CURRENT (milliampere)",
        "O2 SENSOR8 WR CURRENT (milliampere)",
        "CATALYST TEMPERATURE BANK1 SENSOR1 (celsius)",
        "CATALYST TEMPERATURE BANK2 SENSOR1 (celsius)",
        "CATALYST TEMPERATURE BANK1 SENSOR2 (celsius)",
        "CATALYST TEMPERATURE BANK2 SENSOR2 (celsius)",
        "CONTROL MODULE VOLTAGE (volt)",
        "ABSOLUTE LOAD (percent)",
        "COMMANDED EQUIVALENCE RATIO (ratio)",
        "RELATIVE THROTTLE POSITION (percent)",
        "AMBIANT AIR TEMPERATURE (degree celsius)",
        "ABSOLUTE THROTTLE POSITION B (percent)",
        "ABSOLUTE THROTTLE POSITION C (percent)",
        "ACCELERATOR PEDAL POSITION D (percent)",
        "ACCELERATOR PEDAL POSITION E (percent)",
        "ACCELERATOR PEDAL POSITION F (percent)",
        "THROTTLE ACTUATOR (percent)",
        "RUN TIME MIL (minute)",
        "TIME SINCE DTC CLEARED (minute)",
        "MAX MASS AIR FLOW (grams per second)",
        "FUEL TYPE",
        "ETHANOL PERCENT (percent)",
        "ABSOLUTE EVAPORATIVE VAPOR PRESSURE (kilopascal)",
        "ALT EVAPORATIVE VAPOR PRESSURE (pascal)",
        "SHORT O2 TRIM BANK1 (percent)",
        "LONG O2 TRIM BANK1 (percent)",
        "SHORT O2 TRIM BANK2 (percent)",
        "LONG O2 TRIM BANK2 (percent)",
        "ABSOLUTE FUEL RAIL PRESSURE (kilopascal)",
        "RELATIVE ACCELELERATOR PEDAL POSITION (percent)",
        "HYBRID BATTERY REMAINING (percent)",
        "OIL TEMPERATURE (degree celsius)",
        "FUEL INJECTION TIMING (degree)",
        "GPS LATITUDE (degree)",
        "GPS LONGITUDE (degree)",
        "GPS ALTITUDE (meter)",
        "GPS SPEED (meter per second)",
        "GPS TRACK (degree)"
    };

    @Autowired
    public TripUploadService(CarLogService carLogService, S3Service s3Service) {
        this.carLogService = carLogService;
        this.s3Service = s3Service;
        this.csvParser = new CSVParserBuilder().withSeparator(SEPARATION_CHARACTER).build();
    }

    public TripImportSummary processCarLogUpload(CarLogUploadDTO carLogUploadDTO) {
        String tripId = null;
        long totalCarLogCount = 0;
        long importedCarLogCount = 0;
        try {
            byte[] bytes = this.s3Service.getObject(carLogUploadDTO.getObjectLocation());
            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(new ByteArrayInputStream(bytes)))
                    .withCSVParser(this.csvParser)
                    .build();
            List<String[]> rows = csvReader.readAll();
            totalCarLogCount = rows.size() - 1;
            Map<String, Integer> headerIndexMap = this.createHeaderIndexMap(rows.get(0));
            for (int i = 1; i < rows.size(); i++) {
                try {
                    CarLog carLog = this.createCarLogFromRow(rows.get(i), headerIndexMap);
                    this.carLogService.save(carLog);
                    if (Objects.isNull(tripId)) {
                        tripId = carLog.getTripId();
                    }
                    importedCarLogCount++;
                }
                catch (NonTransientDataAccessException | TransientDataAccessException | RecoverableDataAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return new TripImportSummary(tripId, totalCarLogCount, importedCarLogCount);
    }

    private Map<String, Integer> createHeaderIndexMap(String[] headerRow) {
        Map<String, Integer> headerIndexMap = new HashMap<>();
        List<String> list = List.of(headerRow);
        for (String header : HEADER_LIST) {
            int index = list.indexOf(header);
            if (index > -1) {
                headerIndexMap.put(header, index);
            }
        }
        return headerIndexMap;
    }

    private CarLog createCarLogFromRow(String[] row, Map<String, Integer> headerIndexMap) {
        CarLog carLog = new CarLog();
        headerIndexMap.forEach((header, index) -> {
            switch (header) {
                case "DEVICE_TIME" -> carLog.setDeviceTime(this.parseValueToLocalDateTime(row[index]));
                case "CAR ID" -> carLog.setCarId(this.parseValueToString(row[index]));
                case "TRIP ID" -> carLog.setTripId(this.parseValueToString(row[index]));
                case "ENGINE LOAD (percent)" -> carLog.setEngineLoad(this.parseValueToDouble(row[index]));
                case "COOLANT TEMPERATURE" -> carLog.setCoolantTemp(this.parseValueToDouble(row[index]));
                case "SHORT FUEL TRIM 1 (percent)" -> carLog.setShortFuelTrim1(this.parseValueToDouble(row[index]));
                case "LONG FUEL TRIM 1 (percent)" -> carLog.setLongFuelTrim1(this.parseValueToDouble(row[index]));
                case "SHORT FUEL TRIM 2 (percent)" -> carLog.setShortFuelTrim2(this.parseValueToDouble(row[index]));
                case "LONG FUEL TRIM 2 (percent)" -> carLog.setLongFuelTrim2(this.parseValueToDouble(row[index]));
                case "FUEL PRESSURE (kilopascal)" -> carLog.setFuelPressure(this.parseValueToDouble(row[index]));
                case "INTAKE_PRESSURE (kilopascal)" -> carLog.setIntakePressure(this.parseValueToDouble(row[index]));
                case "RPM" -> carLog.setRpm(this.parseValueToDouble(row[index]));
                case "SPEED (kilometers per hour)" -> carLog.setSpeed(this.parseValueToDouble(row[index]));
                case "TIMING ADVANCE (degree)" -> carLog.setTimingAdvance(this.parseValueToDouble(row[index]));
                case "INTAKE TEMPERATURE (degree celsius)" -> carLog.setIntakeTemp(this.parseValueToDouble(row[index]));
                case "Air Flow Rate (grams per second)" -> carLog.setAirFlowRate(this.parseValueToDouble(row[index]));
                case "THROTTLE POSITION (percent)" -> carLog.setThrottlePos(this.parseValueToDouble(row[index]));
                case "AIR STATUS (status)" -> carLog.setAirStatus(this.parseValueToString(row[index]));
                case "O2 SENSORS (sensors)" -> carLog.setO2Sensors(this.parseValueToString(row[index]));
                case "O2 BANK1 SENSOR1 (volt)" -> carLog.setO2B1S1(this.parseValueToDouble(row[index]));
                case "O2 BANK1 SENSOR2 (volt)" -> carLog.setO2B1S2(this.parseValueToDouble(row[index]));
                case "O2 BANK1 SENSOR3 (volt)" -> carLog.setO2B1S3(this.parseValueToDouble(row[index]));
                case "O2 BANK1 SENSOR4 (volt)" -> carLog.setO2B1S4(this.parseValueToDouble(row[index]));
                case "O2 BANK2 SENSOR1 (volt)" -> carLog.setO2B2S1(this.parseValueToDouble(row[index]));
                case "O2 BANK2 SENSOR2 (volt)" -> carLog.setO2B2S2(this.parseValueToDouble(row[index]));
                case "O2 BANK2 SENSOR3 (volt)" -> carLog.setO2B2S3(this.parseValueToDouble(row[index]));
                case "O2 BANK2 SENSOR4 (volt)" -> carLog.setO2B2S4(this.parseValueToDouble(row[index]));
                case "OBD COMPLIANCE" -> carLog.setObdCompliance(this.parseValueToString(row[index]));
                case "O2 SENSORS PRESENT ALTERNATE" -> carLog.setO2SensorsAlt(this.parseValueToString(row[index]));
                case "AUX INPUT STATUS (boolean)" -> carLog.setAuxInputStatus(this.parseValueToString(row[index]));
                case "ENGINE RUN TIME (second)" -> carLog.setRunTime(this.parseValueToDouble(row[index]));
                case "DISTANCE TRAVELED WITH MIL on (kilometer)" -> carLog.setDistanceWMIL(this.parseValueToDouble(row[index]));
                case "FUEL RAIL PRESSURE RELATIVE TO VACUUM (kilopascal)" -> carLog.setFuelRailPressureVAC(this.parseValueToDouble(row[index]));
                case "FUEL RAIL PRESSURE DIRECT INJECTION (kilopascal)" -> carLog.setFuelRailPressureDirect(this.parseValueToDouble(row[index]));
                case "O2 SENSOR1 WR LAMBDA VOLTAGE (volt)" -> carLog.setO2S1WRVoltage(this.parseValueToDouble(row[index]));
                case "O2 SENSOR2 WR LAMBDA VOLTAGE (volt)" -> carLog.setO2S2WRVoltage(this.parseValueToDouble(row[index]));
                case "O2 SENSOR3 WR LAMBDA VOLTAGE (volt)" -> carLog.setO2S3WRVoltage(this.parseValueToDouble(row[index]));
                case "O2 SENSOR4 WR LAMBDA VOLTAGE (volt)" -> carLog.setO2S4WRVoltage(this.parseValueToDouble(row[index]));
                case "O2 SENSOR5 WR LAMBDA VOLTAGE (volt)" -> carLog.setO2S5WRVoltage(this.parseValueToDouble(row[index]));
                case "O2 SENSOR6 WR LAMBDA VOLTAGE (volt)" -> carLog.setO2S6WRVoltage(this.parseValueToDouble(row[index]));
                case "O2 SENSOR7 WR LAMBDA VOLTAGE (volt)" -> carLog.setO2S7WRVoltage(this.parseValueToDouble(row[index]));
                case "O2 SENSOR8 WR LAMBDA VOLTAGE (volt)" -> carLog.setO2S8WRVoltage(this.parseValueToDouble(row[index]));
                case "COMMANDED EGR (percent)" -> carLog.setCommandedEGR(this.parseValueToDouble(row[index]));
                case "EGR ERROR (percent)" -> carLog.setEGRError(this.parseValueToDouble(row[index]));
                case "EVAPORATIVE PURGE (percent)" -> carLog.setEvaporativePurge(this.parseValueToDouble(row[index]));
                case "FUEL LEVEL (percent)" -> carLog.setFuelLevel(this.parseValueToDouble(row[index]));
                case "WARMUPS SINCE DTC CLEAR (count)" -> carLog.setWarmupsSinceDTCClear(this.parseValueToDouble(row[index]));
                case "DISTANCE SINCE DTC CLEAR (kilometer)" -> carLog.setDistanceSinceDTCClear(this.parseValueToDouble(row[index]));
                case "EVAPORATIVE VAPOR PRESSURE (pascal)" -> carLog.setEvapVaporPressure(this.parseValueToDouble(row[index]));
                case "BAROMETRIC PRESSURE (kilopascal)" -> carLog.setBarometricPressure(this.parseValueToDouble(row[index]));
                case "O2 SENSOR1 WR CURRENT (milliampere)" -> carLog.setO2S1WRCurrent(this.parseValueToDouble(row[index]));
                case "O2 SENSOR2 WR CURRENT (milliampere)" -> carLog.setO2S2WRCurrent(this.parseValueToDouble(row[index]));
                case "O2 SENSOR3 WR CURRENT (milliampere)" -> carLog.setO2S3WRCurrent(this.parseValueToDouble(row[index]));
                case "O2 SENSOR4 WR CURRENT (milliampere)" -> carLog.setO2S4WRCurrent(this.parseValueToDouble(row[index]));
                case "O2 SENSOR5 WR CURRENT (milliampere)" -> carLog.setO2S5WRCurrent(this.parseValueToDouble(row[index]));
                case "O2 SENSOR6 WR CURRENT (milliampere)" -> carLog.setO2S6WRCurrent(this.parseValueToDouble(row[index]));
                case "O2 SENSOR7 WR CURRENT (milliampere)" -> carLog.setO2S7WRCurrent(this.parseValueToDouble(row[index]));
                case "O2 SENSOR8 WR CURRENT (milliampere)" -> carLog.setO2S8WRCurrent(this.parseValueToDouble(row[index]));
                case "CATALYST TEMPERATURE BANK1 SENSOR1 (celsius)" -> carLog.setCatalystTempB1S1(this.parseValueToDouble(row[index]));
                case "CATALYST TEMPERATURE BANK2 SENSOR1 (celsius)" -> carLog.setCatalystTempB2S1(this.parseValueToDouble(row[index]));
                case "CATALYST TEMPERATURE BANK1 SENSOR2 (celsius)" -> carLog.setCatalystTempB1S2(this.parseValueToDouble(row[index]));
                case "CATALYST TEMPERATURE BANK2 SENSOR2 (celsius)" -> carLog.setCatalystTempB2S2(this.parseValueToDouble(row[index]));
                case "CONTROL MODULE VOLTAGE (volt)" -> carLog.setControlModuleVoltage(this.parseValueToDouble(row[index]));
                case "ABSOLUTE LOAD (percent)" -> carLog.setAbsoluteLoad(this.parseValueToDouble(row[index]));
                case "COMMANDED EQUIVALENCE RATIO (ratio)" -> carLog.setCommandedEquivRatio(this.parseValueToDouble(row[index]));
                case "RELATIVE THROTTLE POSITION (percent)" -> carLog.setRelativeThrottlePOS(this.parseValueToDouble(row[index]));
                case "AMBIANT AIR TEMPERATURE (degree celsius)" -> carLog.setAmbiantAirTemp(this.parseValueToDouble(row[index]));
                case "ABSOLUTE THROTTLE POSITION B (percent)" -> carLog.setThrottlePOSB(this.parseValueToDouble(row[index]));
                case "ABSOLUTE THROTTLE POSITION C (percent)" -> carLog.setThrottlePOSC(this.parseValueToDouble(row[index]));
                case "ACCELERATOR PEDAL POSITION D (percent)" -> carLog.setThrottlePOSD(this.parseValueToDouble(row[index]));
                case "ACCELERATOR PEDAL POSITION E (percent)" -> carLog.setThrottlePOSE(this.parseValueToDouble(row[index]));
                case "ACCELERATOR PEDAL POSITION F (percent)" -> carLog.setThrottlePOSF(this.parseValueToDouble(row[index]));
                case "THROTTLE ACTUATOR (percent)" -> carLog.setThrottleActuator(this.parseValueToDouble(row[index]));
                case "RUN TIME MIL (minute)" -> carLog.setRunTimeMIL(this.parseValueToDouble(row[index]));
                case "TIME SINCE DTC CLEARED (minute)" -> carLog.setTimeSinceDTCCleared(this.parseValueToDouble(row[index]));
                case "MAX MASS AIR FLOW (grams per second)" -> carLog.setMaxMAF(this.parseValueToDouble(row[index]));
                case "FUEL TYPE" -> carLog.setFuelType(this.parseValueToString(row[index]));
                case "ETHANOL PERCENT (percent)" -> carLog.setEthanolPercent(this.parseValueToDouble(row[index]));
                case "ABSOLUTE EVAPORATIVE VAPOR PRESSURE (kilopascal)" -> carLog.setAbsEvapVaporPressure(this.parseValueToDouble(row[index]));
                case "ALT EVAPORATIVE VAPOR PRESSURE (pascal)" -> carLog.setAltEvapVaporPressure(this.parseValueToDouble(row[index]));
                case "SHORT O2 TRIM BANK1 (percent)" -> carLog.setShortO2TrimB1(this.parseValueToDouble(row[index]));
                case "LONG O2 TRIM BANK1 (percent)" -> carLog.setLongO2TrimB1(this.parseValueToDouble(row[index]));
                case "SHORT O2 TRIM BANK2 (percent)" -> carLog.setShortO2TrimB2(this.parseValueToDouble(row[index]));
                case "LONG O2 TRIM BANK2 (percent)" -> carLog.setLongO2TrimB2(this.parseValueToDouble(row[index]));
                case "ABSOLUTE FUEL RAIL PRESSURE (kilopascal)" -> carLog.setFuelRailPressureABS(this.parseValueToDouble(row[index]));
                case "RELATIVE ACCELELERATOR PEDAL POSITION (percent)" -> carLog.setRelativeAccelPOS(this.parseValueToDouble(row[index]));
                case "HYBRID BATTERY REMAINING (percent)" -> carLog.setHybridBatteryRemaining(this.parseValueToDouble(row[index]));
                case "OIL TEMPERATURE (degree celsius)" -> carLog.setOilTemp(this.parseValueToDouble(row[index]));
                case "FUEL INJECTION TIMING (degree)" -> carLog.setFuelInjectTiming(this.parseValueToDouble(row[index]));
                case "GPS LATITUDE (degree)" -> carLog.setGpsLatitude(this.parseValueToDouble(row[index]));
                case "GPS LONGITUDE (degree)" -> carLog.setGpsLongitude(this.parseValueToDouble(row[index]));
                case "GPS ALTITUDE (meter)" -> carLog.setGpsAltitude(this.parseValueToDouble(row[index]));
                case "GPS SPEED (meter per second)" -> carLog.setGpsSpeed(this.parseValueToDouble(row[index]));
                case "GPS TRACK (degree)" -> carLog.setGpsTrack(this.parseValueToDouble(row[index]));
            }
        });
        return carLog;
    }

    private String parseValueToString(String value) {
        if (Objects.equals(value, "None") || Objects.equals(value, "n/a") || Objects.equals(value, "NaN")) {
            return null;
        }
        return value;
    }

    private Double parseValueToDouble(String value) {
        if (Objects.isNull(this.parseValueToString(value))) {
            return null;
        }
        return Double.parseDouble(value.split(" ")[0]);
    }

    private LocalDateTime parseValueToLocalDateTime(String value) {
        if (Objects.isNull(this.parseValueToString(value))) {
            return null;
        }
        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSSSS"));
    }
}
