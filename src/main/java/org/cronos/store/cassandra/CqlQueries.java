package org.cronos.store.cassandra;

import org.cronos.store.entity.DataType;

class CqlQueries {
    private static final String APPLICATION_NAME_TOKEN = "[%APPLICATION_NAME%]";
    private static final String DATA_TYPE_TOKEN = "[%DATA_TYPE%]";
    private static final String SYSTEM_TABLE_TOKEN = "[%SYSTEM_TABLE%]";

    static final String COMPONENT_SYSTEM_TABLE ="COMPONENT";
    static final String PROPERTIES_SYSTEM_TABLE ="PROPS";

    static final String GROUP_APPLICATION_TABLE="GROUP";
    static final String PARTITION_APPLICATION_TABLE="PARTITION";
    static final String TIME_APPLICATION_TABLE="TIME";
    static final String RECEIVER_APPLICATION_TABLE="RECEIVER";
    static final String VALUE_APPLICATION_TABLE="VALUE";



    private static final String CREATE_SYSTEM_TABLE = "CREATE TABLE IF NOT EXISTS [%SYSTEM_TABLE%] (" +
            COMPONENT_SYSTEM_TABLE +" TEXT PRIMARY KEY , " +
            PROPERTIES_SYSTEM_TABLE + " MAP <TEXT, TEXT >)";
    private static final String CREATE_APPLICATION_TABLE = "CREATE TABLE IF NOT EXISTS [%APPLICATION_NAME%] (" +
            GROUP_APPLICATION_TABLE+" TEXT, " +
            PARTITION_APPLICATION_TABLE+" TEXT, " +
            TIME_APPLICATION_TABLE+" TIMEUUID, " +
            RECEIVER_APPLICATION_TABLE+" TEXT, " +
            VALUE_APPLICATION_TABLE+" [%DATA_TYPE%], " +
            "PRIMARY KEY (("+GROUP_APPLICATION_TABLE+", "+PARTITION_APPLICATION_TABLE+"), "+
            TIME_APPLICATION_TABLE+" ))";

    static String getCreateSystemTable(String systemTable) {
        return CREATE_SYSTEM_TABLE.replace(SYSTEM_TABLE_TOKEN, systemTable);
    }

    static String getCreateApplicationTable(String applicationName, DataType dataType) {
        String result = CREATE_APPLICATION_TABLE;
        result = result.replace(APPLICATION_NAME_TOKEN, applicationName)
                .replace(DATA_TYPE_TOKEN, DataType.getString(dataType));
        return result;
    }

}
