package org.cronos.store.cassandra;

import org.cronos.store.entity.PartitionType;

import java.util.Calendar;


public class CassandraPartition {
    public String getPartitionTime(Calendar date,PartitionType partitionType){
        String result="{";
        switch (partitionType){
            case MINUTE:
                result += String.format("%02d",date.get(Calendar.MINUTE));
            case HOUR:
                result += String.format("%02d",date.get(Calendar.HOUR_OF_DAY));
            case DAY:
                result += String.format("%02d",date.get(Calendar.DAY_OF_MONTH));
            case MONTH:
                result += String.format("%02d",date.get(Calendar.MONTH));
            case YEAR:
                result += String.format("%04d",date.get(Calendar.YEAR));
            case UNKNOWN:
                result += "}";
        }
        return result;
    }

}
