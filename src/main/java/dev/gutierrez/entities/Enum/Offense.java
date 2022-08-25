package dev.gutierrez.entities.Enum;

public enum Offense {
    CRIME, LITTERING,STEALING, OTHER;

    public static Offense fromString(String offense) {
        return valueOf(offense.toUpperCase());
    }
}
