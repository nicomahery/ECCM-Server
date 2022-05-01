package fr.hiapoe.eccmserver.eccmserver.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "car_log")
public class CarLog {
    @Id
    @Column(name = "device_time")
    private LocalDateTime deviceTime;
    @Column(name = "car_id")
    private String carId;
    @Column(name = "trip_id")
    private String tripId;
    @Column(name = "gps_latitude")
    private Double gpsLatitude;
    @Column(name = "gps_longitude")
    private Double gpsLongitude;
    @Column(name = "gps_altitude")
    private Double gpsAltitude;
    @Column(name = "gps_speed")
    private Double gpsSpeed;
    @Column(name = "gps_track")
    private Double gpsTrack;
    @Column(name = "engine_load")
    private Double engineLoad;
    @Column(name = "coolant_temp")
    private Double coolantTemp;
    @Column(name = "short_fuel_trim_1")
    private Double shortFuelTrim1;
    @Column(name = "long_fuel_trim_1")
    private Double longFuelTrim1;
    @Column(name = "short_fuel_trim2")
    private Double shortFuelTrim2;
    @Column(name = "long_fuel_trim_2")
    private Double longFuelTrim2;
    @Column(name = "fuel_pressure")
    private Double fuelPressure;
    @Column(name = "intake_pressure")
    private Double intakePressure;
    @Column(name = "rpm")
    private Double rpm;
    @Column(name = "speed")
    private Double speed;
    @Column(name = "timing_advance")
    private Double timingAdvance;
    @Column(name = "intake_temp")
    private Double intakeTemp;
    @Column(name = "maf")
    private Double maf;
    @Column(name = "throttle_pos")
    private Double throttlePos;
    @Column(name = "air_status")
    private String airStatus;
    @Column(name = "o2_sensors")
    private String O2Sensors;
    @Column(name = "o2_b1_s1")
    private Double O2B1S1;
    @Column(name = "o2_b1_s2")
    private Double O2B1S2;
    @Column(name = "o2_b1_s3")
    private Double O2B1S3;
    @Column(name = "o2_b1_s4")
    private Double O2B1S4;
    @Column(name = "o2_b2_s1")
    private Double O2B2S1;
    @Column(name = "o2_b2_s2")
    private Double O2B2S2;
    @Column(name = "o2_b2_s3")
    private Double O2B2S3;
    @Column(name = "o2_b2_s4")
    private Double O2B2S4;
    @Column(name = "obd_compliance")
    private String obdCompliance;
    @Column(name = "o2_sensors_alt")
    private String O2SensorsAlt;
    @Column(name = "aux_input_status")
    private String auxInputStatus;
    @Column(name = "run_time")
    private Double runTime;
    @Column(name = "distance_without_mil")
    private Double distanceWMIL;
    @Column(name = "fuel_rail_pressure_vac")
    private Double fuelRailPressureVAC;
    @Column(name = "fuel_rail_pressure_direct")
    private Double fuelRailPressureDirect;
    @Column(name = "o2_s1_wr_voltage")
    private Double O2S1WRVoltage;
    @Column(name = "o2_s2_wr_voltage")
    private Double O2S2WRVoltage;
    @Column(name = "o2_s3_wr_voltage")
    private Double O2S3WRVoltage;
    @Column(name = "o2_s4_wr_voltage")
    private Double O2S4WRVoltage;
    @Column(name = "o2_s5_wr_voltage")
    private Double O2S5WRVoltage;
    @Column(name = "o2_s6_wr_voltage")
    private Double O2S6WRVoltage;
    @Column(name = "o2_s7_wr_voltage")
    private Double O2S7WRVoltage;
    @Column(name = "o2_s8_wr_voltage")
    private Double O2S8WRVoltage;
    @Column(name = "commanded_egr")
    private Double commandedEGR;
    @Column(name = "egr_error")
    private Double EGRError;
    @Column(name = "evaporative_purge")
    private Double evaporativePurge;
    @Column(name = "fuel_level")
    private Double fuelLevel;
    @Column(name = "warmups_since_dtc_clear")
    private Double warmupsSinceDTCClear;
    @Column(name = "distance_since_dtc_clear")
    private Double distanceSinceDTCClear;
    @Column(name = "evap_vapor_pressure")
    private Double evapVaporPressure;
    @Column(name = "barometric_pressure")
    private Double barometricPressure;
    @Column(name = "o2_s1_wr_current")
    private Double O2S1WRCurrent;
    @Column(name = "o2_s2_wr_current")
    private Double O2S2WRCurrent;
    @Column(name = "o2_s3_wr_current")
    private Double O2S3WRCurrent;
    @Column(name = "o2_s4_wr_current")
    private Double O2S4WRCurrent;
    @Column(name = "o2_s5_wr_current")
    private Double O2S5WRCurrent;
    @Column(name = "o2_s6_wr_current")
    private Double O2S6WRCurrent;
    @Column(name = "o2_s7_wr_current")
    private Double O2S7WRCurrent;
    @Column(name = "o2_s8_wr_current")
    private Double O2S8WRCurrent;
    @Column(name = "catalyst_temp_b1_s1")
    private Double catalystTempB1S1;
    @Column(name = "catalyst_temp_b2_s1")
    private Double catalystTempB2S1;
    @Column(name = "catalyst_temp_b1_s2")
    private Double catalystTempB1S2;
    @Column(name = "catalyst_temp_b2_s2")
    private Double catalystTempB2S2;
    @Column(name = "control_module_voltage")
    private Double controlModuleVoltage;
    @Column(name = "absolute_load")
    private Double absoluteLoad;
    @Column(name = "commanded_equiv_ratio")
    private Double commandedEquivRatio;
    @Column(name = "relative_throttle_pos")
    private Double relativeThrottlePOS;
    @Column(name = "ambiant_air_temp")
    private Double ambiantAirTemp;
    @Column(name = "throttle_pos_b")
    private Double throttlePOSB;
    @Column(name = "throttle_pos_c")
    private Double throttlePOSC;
    @Column(name = "throttle_pos_d")
    private Double throttlePOSD;
    @Column(name = "throttle_pos_e")
    private Double throttlePOSE;
    @Column(name = "throttle_pos_f")
    private Double throttlePOSF;
    @Column(name = "throttle_actuator")
    private Double throttleActuator;
    @Column(name = "run_time_mil")
    private Double runTimeMIL;
    @Column(name = "time_since_dtc_cleared")
    private Double timeSinceDTCCleared;
    @Column(name = "max_maf")
    private Double maxMAF;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "ethanol_percent")
    private Double ethanolPercent;
    @Column(name = "abs_evap_vapor_pressure")
    private Double absEvapVaporPressure;
    @Column(name = "alt_evap_vapor_pressure")
    private Double altEvapVaporPressure;
    @Column(name = "short_o2_trim_b1")
    private Double shortO2TrimB1;
    @Column(name = "long_o2_trim_b1")
    private Double longO2TrimB1;
    @Column(name = "short_o2_trim_b2")
    private Double shortO2TrimB2;
    @Column(name = "long_o2_trim_b2")
    private Double longO2TrimB2;
    @Column(name = "fuel_rail_pressure_abs")
    private Double fuelRailPressureABS;
    @Column(name = "relative_accel_pos")
    private Double relativeAccelPOS;
    @Column(name = "hybrid_battery_remaining")
    private Double hybridBatteryRemaining;
    @Column(name = "oil_temp")
    private Double oilTemp;
    @Column(name = "fuel_inject_timing")
    private Double fuelInjectTiming;
    @Column(name = "fuel_rate")
    private Double fuelRate;
    @Column(name = "air_flow_rate")
    private Double airFlowRate;

    public CarLog() {
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public Double getAirFlowRate() {
        return airFlowRate;
    }

    public void setAirFlowRate(Double airFlowRate) {
        this.airFlowRate = airFlowRate;
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

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public Double getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(Double gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public Double getGpsSpeed() {
        return gpsSpeed;
    }

    public void setGpsSpeed(Double gpsSpeed) {
        this.gpsSpeed = gpsSpeed;
    }

    public Double getGpsTrack() {
        return gpsTrack;
    }

    public void setGpsTrack(Double gpsTrack) {
        this.gpsTrack = gpsTrack;
    }

    public Double getEngineLoad() {
        return engineLoad;
    }

    public void setEngineLoad(Double engineLoad) {
        this.engineLoad = engineLoad;
    }

    public Double getCoolantTemp() {
        return coolantTemp;
    }

    public void setCoolantTemp(Double coolantTemp) {
        this.coolantTemp = coolantTemp;
    }

    public Double getShortFuelTrim1() {
        return shortFuelTrim1;
    }

    public void setShortFuelTrim1(Double shortFuelTrim1) {
        this.shortFuelTrim1 = shortFuelTrim1;
    }

    public Double getLongFuelTrim1() {
        return longFuelTrim1;
    }

    public void setLongFuelTrim1(Double longFuelTrim1) {
        this.longFuelTrim1 = longFuelTrim1;
    }

    public Double getShortFuelTrim2() {
        return shortFuelTrim2;
    }

    public void setShortFuelTrim2(Double shortFuelTrim2) {
        this.shortFuelTrim2 = shortFuelTrim2;
    }

    public Double getLongFuelTrim2() {
        return longFuelTrim2;
    }

    public void setLongFuelTrim2(Double longFuelTrim2) {
        this.longFuelTrim2 = longFuelTrim2;
    }

    public Double getFuelPressure() {
        return fuelPressure;
    }

    public void setFuelPressure(Double fuelPressure) {
        this.fuelPressure = fuelPressure;
    }

    public Double getIntakePressure() {
        return intakePressure;
    }

    public void setIntakePressure(Double intakePressure) {
        this.intakePressure = intakePressure;
    }

    public Double getRpm() {
        return rpm;
    }

    public void setRpm(Double rpm) {
        this.rpm = rpm;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(Double timingAdvance) {
        this.timingAdvance = timingAdvance;
    }

    public Double getIntakeTemp() {
        return intakeTemp;
    }

    public void setIntakeTemp(Double intakeTemp) {
        this.intakeTemp = intakeTemp;
    }

    public Double getMaf() {
        return maf;
    }

    public void setMaf(Double maf) {
        this.maf = maf;
    }

    public Double getThrottlePos() {
        return throttlePos;
    }

    public void setThrottlePos(Double throttlePos) {
        this.throttlePos = throttlePos;
    }

    public String getAirStatus() {
        return airStatus;
    }

    public void setAirStatus(String airStatus) {
        this.airStatus = airStatus;
    }

    public String getO2Sensors() {
        return O2Sensors;
    }

    public void setO2Sensors(String o2Sensors) {
        O2Sensors = o2Sensors;
    }

    public Double getO2B1S1() {
        return O2B1S1;
    }

    public void setO2B1S1(Double o2B1S1) {
        O2B1S1 = o2B1S1;
    }

    public Double getO2B1S2() {
        return O2B1S2;
    }

    public void setO2B1S2(Double o2B1S2) {
        O2B1S2 = o2B1S2;
    }

    public Double getO2B1S3() {
        return O2B1S3;
    }

    public void setO2B1S3(Double o2B1S3) {
        O2B1S3 = o2B1S3;
    }

    public Double getO2B1S4() {
        return O2B1S4;
    }

    public void setO2B1S4(Double o2B1S4) {
        O2B1S4 = o2B1S4;
    }

    public Double getO2B2S1() {
        return O2B2S1;
    }

    public void setO2B2S1(Double o2B2S1) {
        O2B2S1 = o2B2S1;
    }

    public Double getO2B2S2() {
        return O2B2S2;
    }

    public void setO2B2S2(Double o2B2S2) {
        O2B2S2 = o2B2S2;
    }

    public Double getO2B2S3() {
        return O2B2S3;
    }

    public void setO2B2S3(Double o2B2S3) {
        O2B2S3 = o2B2S3;
    }

    public Double getO2B2S4() {
        return O2B2S4;
    }

    public void setO2B2S4(Double o2B2S4) {
        O2B2S4 = o2B2S4;
    }

    public String getObdCompliance() {
        return obdCompliance;
    }

    public void setObdCompliance(String obdCompliance) {
        this.obdCompliance = obdCompliance;
    }

    public String getO2SensorsAlt() {
        return O2SensorsAlt;
    }

    public void setO2SensorsAlt(String o2SensorsAlt) {
        O2SensorsAlt = o2SensorsAlt;
    }

    public String getAuxInputStatus() {
        return auxInputStatus;
    }

    public void setAuxInputStatus(String auxInputStatus) {
        this.auxInputStatus = auxInputStatus;
    }

    public Double getRunTime() {
        return runTime;
    }

    public void setRunTime(Double runTime) {
        this.runTime = runTime;
    }

    public Double getDistanceWMIL() {
        return distanceWMIL;
    }

    public void setDistanceWMIL(Double distanceWMIL) {
        this.distanceWMIL = distanceWMIL;
    }

    public Double getFuelRailPressureVAC() {
        return fuelRailPressureVAC;
    }

    public void setFuelRailPressureVAC(Double fuelRailPressureVAC) {
        this.fuelRailPressureVAC = fuelRailPressureVAC;
    }

    public Double getFuelRailPressureDirect() {
        return fuelRailPressureDirect;
    }

    public void setFuelRailPressureDirect(Double fuelRailPressureDirect) {
        this.fuelRailPressureDirect = fuelRailPressureDirect;
    }

    public Double getO2S1WRVoltage() {
        return O2S1WRVoltage;
    }

    public void setO2S1WRVoltage(Double o2S1WRVoltage) {
        O2S1WRVoltage = o2S1WRVoltage;
    }

    public Double getO2S2WRVoltage() {
        return O2S2WRVoltage;
    }

    public void setO2S2WRVoltage(Double o2S2WRVoltage) {
        O2S2WRVoltage = o2S2WRVoltage;
    }

    public Double getO2S3WRVoltage() {
        return O2S3WRVoltage;
    }

    public void setO2S3WRVoltage(Double o2S3WRVoltage) {
        O2S3WRVoltage = o2S3WRVoltage;
    }

    public Double getO2S4WRVoltage() {
        return O2S4WRVoltage;
    }

    public void setO2S4WRVoltage(Double o2S4WRVoltage) {
        O2S4WRVoltage = o2S4WRVoltage;
    }

    public Double getO2S5WRVoltage() {
        return O2S5WRVoltage;
    }

    public void setO2S5WRVoltage(Double o2S5WRVoltage) {
        O2S5WRVoltage = o2S5WRVoltage;
    }

    public Double getO2S6WRVoltage() {
        return O2S6WRVoltage;
    }

    public void setO2S6WRVoltage(Double o2S6WRVoltage) {
        O2S6WRVoltage = o2S6WRVoltage;
    }

    public Double getO2S7WRVoltage() {
        return O2S7WRVoltage;
    }

    public void setO2S7WRVoltage(Double o2S7WRVoltage) {
        O2S7WRVoltage = o2S7WRVoltage;
    }

    public Double getO2S8WRVoltage() {
        return O2S8WRVoltage;
    }

    public void setO2S8WRVoltage(Double o2S8WRVoltage) {
        O2S8WRVoltage = o2S8WRVoltage;
    }

    public Double getCommandedEGR() {
        return commandedEGR;
    }

    public void setCommandedEGR(Double commandedEGR) {
        this.commandedEGR = commandedEGR;
    }

    public Double getEGRError() {
        return EGRError;
    }

    public void setEGRError(Double EGRError) {
        this.EGRError = EGRError;
    }

    public Double getEvaporativePurge() {
        return evaporativePurge;
    }

    public void setEvaporativePurge(Double evaporativePurge) {
        this.evaporativePurge = evaporativePurge;
    }

    public Double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Double getWarmupsSinceDTCClear() {
        return warmupsSinceDTCClear;
    }

    public void setWarmupsSinceDTCClear(Double warmupsSinceDTCClear) {
        this.warmupsSinceDTCClear = warmupsSinceDTCClear;
    }

    public Double getDistanceSinceDTCClear() {
        return distanceSinceDTCClear;
    }

    public void setDistanceSinceDTCClear(Double distanceSinceDTCClear) {
        this.distanceSinceDTCClear = distanceSinceDTCClear;
    }

    public Double getEvapVaporPressure() {
        return evapVaporPressure;
    }

    public void setEvapVaporPressure(Double evapVaporPressure) {
        this.evapVaporPressure = evapVaporPressure;
    }

    public Double getBarometricPressure() {
        return barometricPressure;
    }

    public void setBarometricPressure(Double barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    public Double getO2S1WRCurrent() {
        return O2S1WRCurrent;
    }

    public void setO2S1WRCurrent(Double o2S1WRCurrent) {
        O2S1WRCurrent = o2S1WRCurrent;
    }

    public Double getO2S2WRCurrent() {
        return O2S2WRCurrent;
    }

    public void setO2S2WRCurrent(Double o2S2WRCurrent) {
        O2S2WRCurrent = o2S2WRCurrent;
    }

    public Double getO2S3WRCurrent() {
        return O2S3WRCurrent;
    }

    public void setO2S3WRCurrent(Double o2S3WRCurrent) {
        O2S3WRCurrent = o2S3WRCurrent;
    }

    public Double getO2S4WRCurrent() {
        return O2S4WRCurrent;
    }

    public void setO2S4WRCurrent(Double o2S4WRCurrent) {
        O2S4WRCurrent = o2S4WRCurrent;
    }

    public Double getO2S5WRCurrent() {
        return O2S5WRCurrent;
    }

    public void setO2S5WRCurrent(Double o2S5WRCurrent) {
        O2S5WRCurrent = o2S5WRCurrent;
    }

    public Double getO2S6WRCurrent() {
        return O2S6WRCurrent;
    }

    public void setO2S6WRCurrent(Double o2S6WRCurrent) {
        O2S6WRCurrent = o2S6WRCurrent;
    }

    public Double getO2S7WRCurrent() {
        return O2S7WRCurrent;
    }

    public void setO2S7WRCurrent(Double o2S7WRCurrent) {
        O2S7WRCurrent = o2S7WRCurrent;
    }

    public Double getO2S8WRCurrent() {
        return O2S8WRCurrent;
    }

    public void setO2S8WRCurrent(Double o2S8WRCurrent) {
        O2S8WRCurrent = o2S8WRCurrent;
    }

    public Double getCatalystTempB1S1() {
        return catalystTempB1S1;
    }

    public void setCatalystTempB1S1(Double catalystTempB1S1) {
        this.catalystTempB1S1 = catalystTempB1S1;
    }

    public Double getCatalystTempB2S1() {
        return catalystTempB2S1;
    }

    public void setCatalystTempB2S1(Double catalystTempB2S1) {
        this.catalystTempB2S1 = catalystTempB2S1;
    }

    public Double getCatalystTempB1S2() {
        return catalystTempB1S2;
    }

    public void setCatalystTempB1S2(Double catalystTempB1S2) {
        this.catalystTempB1S2 = catalystTempB1S2;
    }

    public Double getCatalystTempB2S2() {
        return catalystTempB2S2;
    }

    public void setCatalystTempB2S2(Double catalystTempB2S2) {
        this.catalystTempB2S2 = catalystTempB2S2;
    }

    public Double getControlModuleVoltage() {
        return controlModuleVoltage;
    }

    public void setControlModuleVoltage(Double controlModuleVoltage) {
        this.controlModuleVoltage = controlModuleVoltage;
    }

    public Double getAbsoluteLoad() {
        return absoluteLoad;
    }

    public void setAbsoluteLoad(Double absoluteLoad) {
        this.absoluteLoad = absoluteLoad;
    }

    public Double getCommandedEquivRatio() {
        return commandedEquivRatio;
    }

    public void setCommandedEquivRatio(Double commandedEquivRatio) {
        this.commandedEquivRatio = commandedEquivRatio;
    }

    public Double getRelativeThrottlePOS() {
        return relativeThrottlePOS;
    }

    public void setRelativeThrottlePOS(Double relativeThrottlePOS) {
        this.relativeThrottlePOS = relativeThrottlePOS;
    }

    public Double getAmbiantAirTemp() {
        return ambiantAirTemp;
    }

    public void setAmbiantAirTemp(Double ambiantAirTemp) {
        this.ambiantAirTemp = ambiantAirTemp;
    }

    public Double getThrottlePOSB() {
        return throttlePOSB;
    }

    public void setThrottlePOSB(Double throttlePOSB) {
        this.throttlePOSB = throttlePOSB;
    }

    public Double getThrottlePOSC() {
        return throttlePOSC;
    }

    public void setThrottlePOSC(Double throttlePOSC) {
        this.throttlePOSC = throttlePOSC;
    }

    public Double getThrottlePOSD() {
        return throttlePOSD;
    }

    public void setThrottlePOSD(Double throttlePOSD) {
        this.throttlePOSD = throttlePOSD;
    }

    public Double getThrottlePOSE() {
        return throttlePOSE;
    }

    public void setThrottlePOSE(Double throttlePOSE) {
        this.throttlePOSE = throttlePOSE;
    }

    public Double getThrottlePOSF() {
        return throttlePOSF;
    }

    public void setThrottlePOSF(Double throttlePOSF) {
        this.throttlePOSF = throttlePOSF;
    }

    public Double getThrottleActuator() {
        return throttleActuator;
    }

    public void setThrottleActuator(Double throttleActuator) {
        this.throttleActuator = throttleActuator;
    }

    public Double getRunTimeMIL() {
        return runTimeMIL;
    }

    public void setRunTimeMIL(Double runTimeMIL) {
        this.runTimeMIL = runTimeMIL;
    }

    public Double getTimeSinceDTCCleared() {
        return timeSinceDTCCleared;
    }

    public void setTimeSinceDTCCleared(Double timeSinceDTCCleared) {
        this.timeSinceDTCCleared = timeSinceDTCCleared;
    }

    public Double getMaxMAF() {
        return maxMAF;
    }

    public void setMaxMAF(Double maxMAF) {
        this.maxMAF = maxMAF;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Double getEthanolPercent() {
        return ethanolPercent;
    }

    public void setEthanolPercent(Double ethanolPercent) {
        this.ethanolPercent = ethanolPercent;
    }

    public Double getAbsEvapVaporPressure() {
        return absEvapVaporPressure;
    }

    public void setAbsEvapVaporPressure(Double absEvapVaporPressure) {
        this.absEvapVaporPressure = absEvapVaporPressure;
    }

    public Double getAltEvapVaporPressure() {
        return altEvapVaporPressure;
    }

    public void setAltEvapVaporPressure(Double altEvapVaporPressure) {
        this.altEvapVaporPressure = altEvapVaporPressure;
    }

    public Double getShortO2TrimB1() {
        return shortO2TrimB1;
    }

    public void setShortO2TrimB1(Double shortO2TrimB1) {
        this.shortO2TrimB1 = shortO2TrimB1;
    }

    public Double getLongO2TrimB1() {
        return longO2TrimB1;
    }

    public void setLongO2TrimB1(Double longO2TrimB1) {
        this.longO2TrimB1 = longO2TrimB1;
    }

    public Double getShortO2TrimB2() {
        return shortO2TrimB2;
    }

    public void setShortO2TrimB2(Double shortO2TrimB2) {
        this.shortO2TrimB2 = shortO2TrimB2;
    }

    public Double getLongO2TrimB2() {
        return longO2TrimB2;
    }

    public void setLongO2TrimB2(Double longO2TrimB2) {
        this.longO2TrimB2 = longO2TrimB2;
    }

    public Double getFuelRailPressureABS() {
        return fuelRailPressureABS;
    }

    public void setFuelRailPressureABS(Double fuelRailPressureABS) {
        this.fuelRailPressureABS = fuelRailPressureABS;
    }

    public Double getRelativeAccelPOS() {
        return relativeAccelPOS;
    }

    public void setRelativeAccelPOS(Double relativeAccelPOS) {
        this.relativeAccelPOS = relativeAccelPOS;
    }

    public Double getHybridBatteryRemaining() {
        return hybridBatteryRemaining;
    }

    public void setHybridBatteryRemaining(Double hybridBatteryRemaining) {
        this.hybridBatteryRemaining = hybridBatteryRemaining;
    }

    public Double getOilTemp() {
        return oilTemp;
    }

    public void setOilTemp(Double oilTemp) {
        this.oilTemp = oilTemp;
    }

    public Double getFuelInjectTiming() {
        return fuelInjectTiming;
    }

    public void setFuelInjectTiming(Double fuelInjectTiming) {
        this.fuelInjectTiming = fuelInjectTiming;
    }

    public Double getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(Double fuelRate) {
        this.fuelRate = fuelRate;
    }
}
