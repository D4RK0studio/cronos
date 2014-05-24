package org.cronos.store.entity;


import java.util.HashMap;
import java.util.Map;

public class Application implements ICronosComponent {
    private final String name;
    private final DataType dataType;
    private final PartitionType partitionType;

    public Application(String name, DataType dataType, PartitionType partitionType){
        this.name=name;
        this.dataType=dataType;
        this.partitionType=partitionType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public PartitionType getPartitionType() {
        return partitionType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getReference() {
        return name;
    }

    @Override
    public Map<String, String> getProperties() {
        Map<String,String> result=new HashMap<>();
        result.put("name",this.name);
        result.put("reference",this.getReference());
        result.put("dataType",DataType.getString(this.dataType));
        result.put("partitionType",PartitionType.getString(this.partitionType));
        return result;
    }


}
