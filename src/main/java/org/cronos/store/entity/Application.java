package org.cronos.store.entity;


public class Application {
    private String name;
    private DataType dataType;
    private PartitionType partTimeType;

    public Application(String name, DataType dataType, PartitionType partTimeType){
        this.name=name;
        this.dataType=dataType;
        this.partTimeType=partTimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public PartitionType getPartTimeType() {
        return partTimeType;
    }

    public void setPartTimeType(PartitionType partTimeType) {
        this.partTimeType = partTimeType;
    }

}
