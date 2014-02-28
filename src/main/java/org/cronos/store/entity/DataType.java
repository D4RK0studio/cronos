package org.cronos.store.entity;

public enum DataType {
    STRING,
    NUMBER,
    DECIMAL,
    UNKNOWN;

    public static DataType getDataType(String dataTypeStr){
        DataType result= DataType.UNKNOWN;
        switch (dataTypeStr.toLowerCase()){
            case "string":
                result=DataType.STRING;
                break;
            case "number":
                result= DataType.NUMBER;
                break;
            case "decimal":
                result=DataType.DECIMAL;
                break;
        }
        return result;
    }

}
