package org.cronos.store.entity;

public enum PartitionType {
    MINUTE,
    HOUR,
    DAY,
    MONTH,
    YEAR,
    UNKNOWN;
    public static PartitionType getPartitionType(String partitionTypeStr){
        PartitionType result= PartitionType.UNKNOWN;
        switch (partitionTypeStr.toLowerCase()){
            case "minute":
                result= PartitionType.MINUTE;
                break;
            case "hour":
                result= PartitionType.HOUR;
                break;
            case "day":
                result= PartitionType.DAY;
                break;
            case "month":
                result= PartitionType.MONTH;
                break;
            case "year":
                result= PartitionType.YEAR;
                break;
        }
        return result;
    }
}
