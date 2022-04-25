package fr.hiapoe.eccmserver.eccmserver.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "car_log")
public class CarLog {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "car_id")
    private String carId;
    @Column(name = "device_time")
    private LocalDateTime deviceTime;
    @Column(name = "gps_latitude")
    private double gpsLatitude;
    @Column(name = "gps_longitude")
    private double gpsLongitude;
    @Column(name = "gps_altitude")
    private double gpsAltitude;
    @Column(name = "gps_speed")
    private double gpsSpeed;
    @Column(name = "gps_track")
    private double gpsTrack;
    @Column(name = "engine_load")
    private double engineLoad;
    @Column(name = "coolant_temp")
    private double coolantTemp;
    @Column(name = "short_fuel_trim_1")
    private double shortFuelTrim1;
    @Column(name = "long_fuel_trim_1")
    private double longFuelTrim1;
    @Column(name = "short_fuel_trim2")
    private double shortFuelTrim2;
    @Column(name = "long_fuel_trim_2")
    private double longFuelTrim2;
    @Column(name = "fuel_pressure")
    private double fuelPressure;
    @Column(name = "intake_pressure")
    private double intakePressure;
    @Column(name = "rpm")
    private double rpm;
    @Column(name = "speed")
    private double speed;
    @Column(name = "timing_advance")
    private double timingAdvance;
    @Column(name = "intake_temp")
    private double intakeTemp;
    @Column(name = "maf")
    private double maf;
    @Column(name = "throttle_pos")
    private double throttlePos;
    @Column(name = "air_status")
    private String airStatus;
    @Column(name = "o2_sensors")
    private double O2Sensors;
    @Column(name = "o2_b1_s1")
    private double O2B1S1;
    @Column(name = "o2_b1_s2")
    private double O2B1S2;
    @Column(name = "o2_b1_s3")
    private double O2B1S3;
    @Column(name = "o2_b1_s4")
    private double O2B1S4;
    @Column(name = "o2_b2_s1")
    private double O2B2S1;
    @Column(name = "o2_b2_s2")
    private double O2B2S2;
    @Column(name = "o2_b2_s3")
    private double O2B2S3;
    @Column(name = "o2_b2_s4")
    private double O2B2S4;
    @Column(name = "obd_compliance")
    private String obdCompliance;
    @Column(name = "o2_sensors_alt")
    private double O2SensorsAlt;
    @Column(name = "aux_input_status")
    private String auxInputStatus;
    @Column(name = "run_time")
    private double runTime;
    @Column(name = "distance_without_mil")
    private double distanceWMIL;
    @Column(name = "fuel_rail_pressure_vac")
    private double fuelRailPressureVAC;
    @Column(name = "get_fuel_rail_pressure_direct")
    private double getFuelRailPressureDirect;
    @Column(name = "o2_s1_wr_voltage")
    private double O2S1WRVoltage;
    @Column(name = "o2_s2_wr_voltage")
    private double O2S2WRVoltage;
    @Column(name = "o2_s3_wr_voltage")
    private double O2S3WRVoltage;
    @Column(name = "o2_s4_wr_voltage")
    private double O2S4WRVoltage;
    @Column(name = "o2_s5_wr_voltage")
    private double O2S5WRVoltage;
    @Column(name = "o2_s6_wr_voltage")
    private double O2S6WRVoltage;
    @Column(name = "o2_s7_wr_voltage")
    private double O2S7WRVoltage;
    @Column(name = "o2_s8_wr_voltage")
    private double O2S8WRVoltage;
    @Column(name = "commanded_egr")
    private double commandedEGR;
    @Column(name = "egr_error")
    private double EGRError;
    @Column(name = "evaporative_purge")
    private double evaporativePurge;
    @Column(name = "fuel_level")
    private double fuelLevel;
    @Column(name = "warmups_since_dtc_clear")
    private double warmupsSinceDTCClear;
    @Column(name = "distance_since_dtc_clear")
    private double distanceSinceDTCClear;
    @Column(name = "evap_vapor_pressure")
    private double evapVaporPressure;
    @Column(name = "barometric_pressure")
    private double barometricPressure;
    @Column(name = "o2_s1_wr_current")
    private double O2S1WRCurrent;
    @Column(name = "o2_s2_wr_current")
    private double O2S2WRCurrent;
    @Column(name = "o2_s3_wr_current")
    private double O2S3WRCurrent;
    @Column(name = "o2_s4_wr_current")
    private double O2S4WRCurrent;
    @Column(name = "o2_s5_wr_current")
    private double O2S5WRCurrent;
    @Column(name = "o2_s6_wr_current")
    private double O2S6WRCurrent;
    @Column(name = "o2_s7_wr_current")
    private double O2S7WRCurrent;
    @Column(name = "o2_s8_wr_current")
    private double O2S8WRCurrent;
    @Column(name = "catalyst_temp_b1_s1")
    private double catalystTempB1S1;
    @Column(name = "catalyst_temp_b2_s1")
    private double catalystTempB2S1;
    @Column(name = "catalyst_temp_b1_s2")
    private double catalystTempB1S2;
    @Column(name = "catalyst_temp_b2_s2")
    private double catalystTempB2S2;
    @Column(name = "control_module_voltage")
    private double controlModuleVoltage;
    @Column(name = "absolute_load")
    private double absoluteLoad;
    @Column(name = "commanded_equiv_ratio")
    private double commandedEquivRatio;
    @Column(name = "relative_throttle_pos")
    private double relativeThrottlePOS;
    @Column(name = "ambiant_air_temp")
    private double ambiantAirTemp;
    @Column(name = "throttle_pos_b")
    private double throttlePOSB;
    @Column(name = "throttle_pos_c")
    private double throttlePOSC;
    @Column(name = "throttle_pos_d")
    private double throttlePOSD;
    @Column(name = "throttle_pos_e")
    private double throttlePOSE;
    @Column(name = "throttle_pos_f")
    private double throttlePOSF;
    @Column(name = "throttle_actuator")
    private double throttleActuator;
    @Column(name = "run_time_mil")
    private double runTimeMIL;
    @Column(name = "time_since_dtc_cleared")
    private double timeSinceDTCCleared;
    @Column(name = "max_maf")
    private double maxMAF;
    @Column(name = "fuel_type")
    private double fuelType;
    @Column(name = "ethanol_percent")
    private double ethanolPercent;
    @Column(name = "get_evap_vapor_pressure_abs")
    private double getEvapVaporPressureABS;
    @Column(name = "get_evap_vapor_pressure_alt")
    private double getEvapVaporPressureAlt;
    @Column(name = "short_o2_trim_b1")
    private double shortO2TrimB1;
    @Column(name = "long_o2_trim_b1")
    private double longO2TrimB1;
    @Column(name = "short_o2_trim_b2")
    private double shortO2TrimB2;
    @Column(name = "long_o2_trim_b2")
    private double longO2TrimB2;
    @Column(name = "fuel_rail_pressure_abs")
    private double fuelRailPressureABS;
    @Column(name = "relative_accel_pos")
    private double relativeAccelPOS;
    @Column(name = "hybrid_battery_remaining")
    private double hybridBatteryRemaining;
    @Column(name = "oil_temp")
    private double oilTemp;
    @Column(name = "fuel_inject_timing")
    private double fuelInjectTiming;
    @Column(name = "fuel_rate")
    private double fuelRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public LocalDateTime getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(LocalDateTime deviceTime) {
        this.deviceTime = deviceTime;
    }

    public double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public double getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(double gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public double getGpsSpeed() {
        return gpsSpeed;
    }

    public void setGpsSpeed(double gpsSpeed) {
        this.gpsSpeed = gpsSpeed;
    }

    public double getGpsTrack() {
        return gpsTrack;
    }

    public void setGpsTrack(double gpsTrack) {
        this.gpsTrack = gpsTrack;
    }

    public double getEngineLoad() {
        return engineLoad;
    }

    public void setEngineLoad(double engineLoad) {
        this.engineLoad = engineLoad;
    }

    public double getCoolantTemp() {
        return coolantTemp;
    }

    public void setCoolantTemp(double coolantTemp) {
        this.coolantTemp = coolantTemp;
    }

    public double getShortFuelTrim1() {
        return shortFuelTrim1;
    }

    public void setShortFuelTrim1(double shortFuelTrim1) {
        this.shortFuelTrim1 = shortFuelTrim1;
    }

    public double getLongFuelTrim1() {
        return longFuelTrim1;
    }

    public void setLongFuelTrim1(double longFuelTrim1) {
        this.longFuelTrim1 = longFuelTrim1;
    }

    public double getShortFuelTrim2() {
        return shortFuelTrim2;
    }

    public void setShortFuelTrim2(double shortFuelTrim2) {
        this.shortFuelTrim2 = shortFuelTrim2;
    }

    public double getLongFuelTrim2() {
        return longFuelTrim2;
    }

    public void setLongFuelTrim2(double longFuelTrim2) {
        this.longFuelTrim2 = longFuelTrim2;
    }

    public double getFuelPressure() {
        return fuelPressure;
    }

    public void setFuelPressure(double fuelPressure) {
        this.fuelPressure = fuelPressure;
    }

    public double getIntakePressure() {
        return intakePressure;
    }

    public void setIntakePressure(double intakePressure) {
        this.intakePressure = intakePressure;
    }

    public double getRpm() {
        return rpm;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(double timingAdvance) {
        this.timingAdvance = timingAdvance;
    }

    public double getIntakeTemp() {
        return intakeTemp;
    }

    public void setIntakeTemp(double intakeTemp) {
        this.intakeTemp = intakeTemp;
    }

    public double getMaf() {
        return maf;
    }

    public void setMaf(double maf) {
        this.maf = maf;
    }

    public double getThrottlePos() {
        return throttlePos;
    }

    public void setThrottlePos(double throttlePos) {
        this.throttlePos = throttlePos;
    }

    public String getAirStatus() {
        return airStatus;
    }

    public void setAirStatus(String airStatus) {
        this.airStatus = airStatus;
    }

    public double getO2Sensors() {
        return O2Sensors;
    }

    public void setO2Sensors(double o2Sensors) {
        O2Sensors = o2Sensors;
    }

    public double getO2B1S1() {
        return O2B1S1;
    }

    public void setO2B1S1(double o2B1S1) {
        O2B1S1 = o2B1S1;
    }

    public double getO2B1S2() {
        return O2B1S2;
    }

    public void setO2B1S2(double o2B1S2) {
        O2B1S2 = o2B1S2;
    }

    public double getO2B1S3() {
        return O2B1S3;
    }

    public void setO2B1S3(double o2B1S3) {
        O2B1S3 = o2B1S3;
    }

    public double getO2B1S4() {
        return O2B1S4;
    }

    public void setO2B1S4(double o2B1S4) {
        O2B1S4 = o2B1S4;
    }

    public double getO2B2S1() {
        return O2B2S1;
    }

    public void setO2B2S1(double o2B2S1) {
        O2B2S1 = o2B2S1;
    }

    public double getO2B2S2() {
        return O2B2S2;
    }

    public void setO2B2S2(double o2B2S2) {
        O2B2S2 = o2B2S2;
    }

    public double getO2B2S3() {
        return O2B2S3;
    }

    public void setO2B2S3(double o2B2S3) {
        O2B2S3 = o2B2S3;
    }

    public double getO2B2S4() {
        return O2B2S4;
    }

    public void setO2B2S4(double o2B2S4) {
        O2B2S4 = o2B2S4;
    }

    public String getObdCompliance() {
        return obdCompliance;
    }

    public void setObdCompliance(String obdCompliance) {
        this.obdCompliance = obdCompliance;
    }

    public double getO2SensorsAlt() {
        return O2SensorsAlt;
    }

    public void setO2SensorsAlt(double o2SensorsAlt) {
        O2SensorsAlt = o2SensorsAlt;
    }

    public String getAuxInputStatus() {
        return auxInputStatus;
    }

    public void setAuxInputStatus(String auxInputStatus) {
        this.auxInputStatus = auxInputStatus;
    }

    public double getRunTime() {
        return runTime;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    public double getDistanceWMIL() {
        return distanceWMIL;
    }

    public void setDistanceWMIL(double distanceWMIL) {
        this.distanceWMIL = distanceWMIL;
    }

    public double getFuelRailPressureVAC() {
        return fuelRailPressureVAC;
    }

    public void setFuelRailPressureVAC(double fuelRailPressureVAC) {
        this.fuelRailPressureVAC = fuelRailPressureVAC;
    }

    public double getGetFuelRailPressureDirect() {
        return getFuelRailPressureDirect;
    }

    public void setGetFuelRailPressureDirect(double getFuelRailPressureDirect) {
        this.getFuelRailPressureDirect = getFuelRailPressureDirect;
    }

    public double getO2S1WRVoltage() {
        return O2S1WRVoltage;
    }

    public void setO2S1WRVoltage(double o2S1WRVoltage) {
        O2S1WRVoltage = o2S1WRVoltage;
    }

    public double getO2S2WRVoltage() {
        return O2S2WRVoltage;
    }

    public void setO2S2WRVoltage(double o2S2WRVoltage) {
        O2S2WRVoltage = o2S2WRVoltage;
    }

    public double getO2S3WRVoltage() {
        return O2S3WRVoltage;
    }

    public void setO2S3WRVoltage(double o2S3WRVoltage) {
        O2S3WRVoltage = o2S3WRVoltage;
    }

    public double getO2S4WRVoltage() {
        return O2S4WRVoltage;
    }

    public void setO2S4WRVoltage(double o2S4WRVoltage) {
        O2S4WRVoltage = o2S4WRVoltage;
    }

    public double getO2S5WRVoltage() {
        return O2S5WRVoltage;
    }

    public void setO2S5WRVoltage(double o2S5WRVoltage) {
        O2S5WRVoltage = o2S5WRVoltage;
    }

    public double getO2S6WRVoltage() {
        return O2S6WRVoltage;
    }

    public void setO2S6WRVoltage(double o2S6WRVoltage) {
        O2S6WRVoltage = o2S6WRVoltage;
    }

    public double getO2S7WRVoltage() {
        return O2S7WRVoltage;
    }

    public void setO2S7WRVoltage(double o2S7WRVoltage) {
        O2S7WRVoltage = o2S7WRVoltage;
    }

    public double getO2S8WRVoltage() {
        return O2S8WRVoltage;
    }

    public void setO2S8WRVoltage(double o2S8WRVoltage) {
        O2S8WRVoltage = o2S8WRVoltage;
    }

    public double getCommandedEGR() {
        return commandedEGR;
    }

    public void setCommandedEGR(double commandedEGR) {
        this.commandedEGR = commandedEGR;
    }

    public double getEGRError() {
        return EGRError;
    }

    public void setEGRError(double EGRError) {
        this.EGRError = EGRError;
    }

    public double getEvaporativePurge() {
        return evaporativePurge;
    }

    public void setEvaporativePurge(double evaporativePurge) {
        this.evaporativePurge = evaporativePurge;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getWarmupsSinceDTCClear() {
        return warmupsSinceDTCClear;
    }

    public void setWarmupsSinceDTCClear(double warmupsSinceDTCClear) {
        this.warmupsSinceDTCClear = warmupsSinceDTCClear;
    }

    public double getDistanceSinceDTCClear() {
        return distanceSinceDTCClear;
    }

    public void setDistanceSinceDTCClear(double distanceSinceDTCClear) {
        this.distanceSinceDTCClear = distanceSinceDTCClear;
    }

    public double getEvapVaporPressure() {
        return evapVaporPressure;
    }

    public void setEvapVaporPressure(double evapVaporPressure) {
        this.evapVaporPressure = evapVaporPressure;
    }

    public double getBarometricPressure() {
        return barometricPressure;
    }

    public void setBarometricPressure(double barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    public double getO2S1WRCurrent() {
        return O2S1WRCurrent;
    }

    public void setO2S1WRCurrent(double o2S1WRCurrent) {
        O2S1WRCurrent = o2S1WRCurrent;
    }

    public double getO2S2WRCurrent() {
        return O2S2WRCurrent;
    }

    public void setO2S2WRCurrent(double o2S2WRCurrent) {
        O2S2WRCurrent = o2S2WRCurrent;
    }

    public double getO2S3WRCurrent() {
        return O2S3WRCurrent;
    }

    public void setO2S3WRCurrent(double o2S3WRCurrent) {
        O2S3WRCurrent = o2S3WRCurrent;
    }

    public double getO2S4WRCurrent() {
        return O2S4WRCurrent;
    }

    public void setO2S4WRCurrent(double o2S4WRCurrent) {
        O2S4WRCurrent = o2S4WRCurrent;
    }

    public double getO2S5WRCurrent() {
        return O2S5WRCurrent;
    }

    public void setO2S5WRCurrent(double o2S5WRCurrent) {
        O2S5WRCurrent = o2S5WRCurrent;
    }

    public double getO2S6WRCurrent() {
        return O2S6WRCurrent;
    }

    public void setO2S6WRCurrent(double o2S6WRCurrent) {
        O2S6WRCurrent = o2S6WRCurrent;
    }

    public double getO2S7WRCurrent() {
        return O2S7WRCurrent;
    }

    public void setO2S7WRCurrent(double o2S7WRCurrent) {
        O2S7WRCurrent = o2S7WRCurrent;
    }

    public double getO2S8WRCurrent() {
        return O2S8WRCurrent;
    }

    public void setO2S8WRCurrent(double o2S8WRCurrent) {
        O2S8WRCurrent = o2S8WRCurrent;
    }

    public double getCatalystTempB1S1() {
        return catalystTempB1S1;
    }

    public void setCatalystTempB1S1(double catalystTempB1S1) {
        this.catalystTempB1S1 = catalystTempB1S1;
    }

    public double getCatalystTempB2S1() {
        return catalystTempB2S1;
    }

    public void setCatalystTempB2S1(double catalystTempB2S1) {
        this.catalystTempB2S1 = catalystTempB2S1;
    }

    public double getCatalystTempB1S2() {
        return catalystTempB1S2;
    }

    public void setCatalystTempB1S2(double catalystTempB1S2) {
        this.catalystTempB1S2 = catalystTempB1S2;
    }

    public double getCatalystTempB2S2() {
        return catalystTempB2S2;
    }

    public void setCatalystTempB2S2(double catalystTempB2S2) {
        this.catalystTempB2S2 = catalystTempB2S2;
    }

    public double getControlModuleVoltage() {
        return controlModuleVoltage;
    }

    public void setControlModuleVoltage(double controlModuleVoltage) {
        this.controlModuleVoltage = controlModuleVoltage;
    }

    public double getAbsoluteLoad() {
        return absoluteLoad;
    }

    public void setAbsoluteLoad(double absoluteLoad) {
        this.absoluteLoad = absoluteLoad;
    }

    public double getCommandedEquivRatio() {
        return commandedEquivRatio;
    }

    public void setCommandedEquivRatio(double commandedEquivRatio) {
        this.commandedEquivRatio = commandedEquivRatio;
    }

    public double getRelativeThrottlePOS() {
        return relativeThrottlePOS;
    }

    public void setRelativeThrottlePOS(double relativeThrottlePOS) {
        this.relativeThrottlePOS = relativeThrottlePOS;
    }

    public double getAmbiantAirTemp() {
        return ambiantAirTemp;
    }

    public void setAmbiantAirTemp(double ambiantAirTemp) {
        this.ambiantAirTemp = ambiantAirTemp;
    }

    public double getThrottlePOSB() {
        return throttlePOSB;
    }

    public void setThrottlePOSB(double throttlePOSB) {
        this.throttlePOSB = throttlePOSB;
    }

    public double getThrottlePOSC() {
        return throttlePOSC;
    }

    public void setThrottlePOSC(double throttlePOSC) {
        this.throttlePOSC = throttlePOSC;
    }

    public double getThrottlePOSD() {
        return throttlePOSD;
    }

    public void setThrottlePOSD(double throttlePOSD) {
        this.throttlePOSD = throttlePOSD;
    }

    public double getThrottlePOSE() {
        return throttlePOSE;
    }

    public void setThrottlePOSE(double throttlePOSE) {
        this.throttlePOSE = throttlePOSE;
    }

    public double getThrottlePOSF() {
        return throttlePOSF;
    }

    public void setThrottlePOSF(double throttlePOSF) {
        this.throttlePOSF = throttlePOSF;
    }

    public double getThrottleActuator() {
        return throttleActuator;
    }

    public void setThrottleActuator(double throttleActuator) {
        this.throttleActuator = throttleActuator;
    }

    public double getRunTimeMIL() {
        return runTimeMIL;
    }

    public void setRunTimeMIL(double runTimeMIL) {
        this.runTimeMIL = runTimeMIL;
    }

    public double getTimeSinceDTCCleared() {
        return timeSinceDTCCleared;
    }

    public void setTimeSinceDTCCleared(double timeSinceDTCCleared) {
        this.timeSinceDTCCleared = timeSinceDTCCleared;
    }

    public double getMaxMAF() {
        return maxMAF;
    }

    public void setMaxMAF(double maxMAF) {
        this.maxMAF = maxMAF;
    }

    public double getFuelType() {
        return fuelType;
    }

    public void setFuelType(double fuelType) {
        this.fuelType = fuelType;
    }

    public double getEthanolPercent() {
        return ethanolPercent;
    }

    public void setEthanolPercent(double ethanolPercent) {
        this.ethanolPercent = ethanolPercent;
    }

    public double getGetEvapVaporPressureABS() {
        return getEvapVaporPressureABS;
    }

    public void setGetEvapVaporPressureABS(double getEvapVaporPressureABS) {
        this.getEvapVaporPressureABS = getEvapVaporPressureABS;
    }

    public double getGetEvapVaporPressureAlt() {
        return getEvapVaporPressureAlt;
    }

    public void setGetEvapVaporPressureAlt(double getEvapVaporPressureAlt) {
        this.getEvapVaporPressureAlt = getEvapVaporPressureAlt;
    }

    public double getShortO2TrimB1() {
        return shortO2TrimB1;
    }

    public void setShortO2TrimB1(double shortO2TrimB1) {
        this.shortO2TrimB1 = shortO2TrimB1;
    }

    public double getLongO2TrimB1() {
        return longO2TrimB1;
    }

    public void setLongO2TrimB1(double longO2TrimB1) {
        this.longO2TrimB1 = longO2TrimB1;
    }

    public double getShortO2TrimB2() {
        return shortO2TrimB2;
    }

    public void setShortO2TrimB2(double shortO2TrimB2) {
        this.shortO2TrimB2 = shortO2TrimB2;
    }

    public double getLongO2TrimB2() {
        return longO2TrimB2;
    }

    public void setLongO2TrimB2(double longO2TrimB2) {
        this.longO2TrimB2 = longO2TrimB2;
    }

    public double getFuelRailPressureABS() {
        return fuelRailPressureABS;
    }

    public void setFuelRailPressureABS(double fuelRailPressureABS) {
        this.fuelRailPressureABS = fuelRailPressureABS;
    }

    public double getRelativeAccelPOS() {
        return relativeAccelPOS;
    }

    public void setRelativeAccelPOS(double relativeAccelPOS) {
        this.relativeAccelPOS = relativeAccelPOS;
    }

    public double getHybridBatteryRemaining() {
        return hybridBatteryRemaining;
    }

    public void setHybridBatteryRemaining(double hybridBatteryRemaining) {
        this.hybridBatteryRemaining = hybridBatteryRemaining;
    }

    public double getOilTemp() {
        return oilTemp;
    }

    public void setOilTemp(double oilTemp) {
        this.oilTemp = oilTemp;
    }

    public double getFuelInjectTiming() {
        return fuelInjectTiming;
    }

    public void setFuelInjectTiming(double fuelInjectTiming) {
        this.fuelInjectTiming = fuelInjectTiming;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(double fuelRate) {
        this.fuelRate = fuelRate;
    }
}
