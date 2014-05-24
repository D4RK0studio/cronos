package org.cronos.store.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import org.apache.commons.configuration.Configuration;
import org.cronos.store.IStorage;
import org.cronos.store.OperationResult;
import org.cronos.store.entity.*;

import java.util.Date;
import java.util.List;

public class CassandraStorage implements IStorage {
    public static final String CONFIG_CASS_PORT = "casandra.port";
    public static final String CONFIG_CASS_HOSTS = "cassandra.hosts";
    public static final String CONFIG_CASS_KEYSPACE = "cassandra.keyspace";


    private static final String SYSTEM_TABLE = "CRONOS_SYSTEM";

    private Session session;

    private static String parseDataTypeToCassandra(DataType type) {
        String result = "TEXT";
        switch (type) {
            case STRING:
                result = "TEXT";
                break;
            case NUMBER:
                result = "BIGINT";
                break;
            case DECIMAL:
                result = "DECIMAL";
                break;
        }
        return result;
    }

    private OperationResult createSystemRegister(ICronosComponent component){
        OperationResult result;
        try{

            String querySystem= QueryBuilder.insertInto(SYSTEM_TABLE).ifNotExists()
                    .value(CqlQueries.COMPONENT_SYSTEM_TABLE, component.getReference())
                    .value(CqlQueries.PROPERTIES_SYSTEM_TABLE,component.getProperties())
                    .getQueryString();

            session.execute(querySystem);
            result=new OperationResult("CreateApplication: " + component.getReference(),100,"OK");
        }catch (Exception ex){
            result=new OperationResult("CreateApplication: " + component.getReference(),-1,ex.getMessage());
        }
        return result;
    }

    @Override
    public void init(Configuration configuration) {
        int port = configuration.getInt(CONFIG_CASS_PORT, 9042);
        String hostsStr = configuration.getString(CONFIG_CASS_HOSTS, "localhost");
        String[] hosts = hostsStr.split(",");

        String keyspace = configuration.getString(CONFIG_CASS_KEYSPACE, "cronos-db-sample");
        Cluster cluster = Cluster.builder().addContactPoints(hosts).withPort(port).build();

        this.session = cluster.connect(keyspace);
        this.session.execute(CqlQueries.getCreateSystemTable(SYSTEM_TABLE));
    }


    @Override
    public OperationResult createApplication(Application application) {
        OperationResult result=this.createSystemRegister(application);
        if(result.isOK()){
            try{
                session.execute(CqlQueries.getCreateApplicationTable(application.getName(), application.getDataType()));
            }catch (Exception ex){
                result=new OperationResult("CreateApplication->CreateTable: " +
                        application.getReference(),-1,ex.getMessage());
            }
        }
        return result;
    }

    @Override
    public OperationResult createGroup(Group group) {
        return this.createSystemRegister(group);
    }

    @Override
    public OperationResult createReceiver(Receiver receiver) {
        return this.createSystemRegister(receiver);
    }

    @Override
    public OperationResult add(Record record) {


        Application recordApplication=record.getReceiver()
                .getGroup().getApplication();
        String cql= QueryBuilder.insertInto(recordApplication.getName()).getQueryString() ;
        return null;
    }

    @Override
    public DataMap getDataMap(DataSplit dataSplit) {
        return null;
    }

    @Override
    public List<DataSplit> getDataSplits(Group group, Date minor, Date major) {
        return null;
    }

    @Override
    public Application getApplication(String application) {
        return null;
    }

    @Override
    public Group getGroup(String application, String group) {
        return null;
    }

    @Override
    public Receiver getReceiver(String application, String group, String receiver) {
        return null;
    }
}
