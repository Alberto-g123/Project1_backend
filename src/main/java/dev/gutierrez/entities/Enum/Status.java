package dev.gutierrez.entities.Enum;

public enum Status {
    UNREVIEWED,REVIEWED,HIGH_PRIORITY, LOW_PRIORITY, IGNORED, ADDRESSED;

    public static Status fromString(String status) {
        return valueOf(status.toUpperCase());
    }

}
