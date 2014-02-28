package org.cronos.store.entity;

import java.util.Date;

public class Record {
    private Receiver receiver;
    private Date timestamp;
    private Object rawValue;

    protected Record(Receiver receiver, Date timestamp, Object rawValue) {
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.rawValue= rawValue;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Object getRawValue(){
        return rawValue;
    }
}
