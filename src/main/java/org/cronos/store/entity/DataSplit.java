package org.cronos.store.entity;

import java.util.Date;

public class DataSplit {
    private int orderId;
    private int totalSplits;
    private Date minorDate;
    private Date majorDate;
    private Group group;
    private String partition;

    public DataSplit(int orderId, int totalSplits, Date minorDate, Date majorDate, Group group, String partition) {
        this.orderId = orderId;
        this.totalSplits = totalSplits;
        this.minorDate = minorDate;
        this.majorDate = majorDate;
        this.group = group;
        this.partition = partition;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTotalSplits() {
        return totalSplits;
    }

    public Date getMinorDate() {
        return minorDate;
    }

    public Date getMajorDate() {
        return majorDate;
    }

    public Group getGroup() {
        return group;
    }

    public String getPartition() {
        return partition;
    }
}
