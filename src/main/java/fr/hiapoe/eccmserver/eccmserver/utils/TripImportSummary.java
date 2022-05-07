package fr.hiapoe.eccmserver.eccmserver.utils;

public class TripImportSummary {
    private final String tripId;
    private final long totalCarLogCount;
    private final long importedCarLogCount;

    public TripImportSummary(String tripId, long totalCarLogCount, long importedCarLogCount) {
        this.tripId = tripId;
        this.totalCarLogCount = totalCarLogCount;
        this.importedCarLogCount = importedCarLogCount;
    }

    @Override
    public String toString() {
        return "TripImportSummary{" +
                "tripId='" + tripId + '\'' +
                ", totalCarLogCount=" + totalCarLogCount +
                ", importedCarLogCount=" + importedCarLogCount +
                '}';
    }

    public String getTripId() {
        return tripId;
    }

    public long getTotalCarLogCount() {
        return totalCarLogCount;
    }

    public long getImportedCarLogCount() {
        return importedCarLogCount;
    }
}
