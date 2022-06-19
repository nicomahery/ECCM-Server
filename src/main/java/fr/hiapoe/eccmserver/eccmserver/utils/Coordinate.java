package fr.hiapoe.eccmserver.eccmserver.utils;

public class Coordinate {
    public final Double latitude;
    public final Double longitude;

    public Coordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
