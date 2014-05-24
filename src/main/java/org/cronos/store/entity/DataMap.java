package org.cronos.store.entity;

import java.util.ArrayList;
import java.util.List;

public class DataMap {
    private final DataSplit dataSplit;
    private final List<Record> records;

    public DataMap(DataSplit dataSplit) {
        this.dataSplit = dataSplit;
        this.records=new ArrayList<>();
    }

    public DataSplit getDataSplit() {
        return dataSplit;
    }

    public List<Record> getRecords() {
        return records;
    }
}
