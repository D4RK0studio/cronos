package org.cronos.store.entity;


import com.fasterxml.uuid.Generators;

import java.util.Calendar;
import java.util.UUID;

public class Record {
    private final Receiver receiver;
    private final UUID timeuuid;
    private final Calendar timestamp;
    private final Object rawValue;

    protected Record(Receiver receiver,UUID timeuuid , Calendar timestamp, Object rawValue) {
        this.receiver = receiver;
        this.timeuuid=timeuuid;
        this.timestamp=timestamp;
        this.rawValue= rawValue;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public UUID getTimeuuid(){
        return timeuuid;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public Object getRawValue(){
        return rawValue;
    }

    public static Record createRecord(Receiver receiver, Object rawValue){
        UUID uuid = Generators.timeBasedGenerator().generate();
        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(uuid.timestamp());
        return new Record(receiver,uuid,calendar,rawValue);
    }
}
