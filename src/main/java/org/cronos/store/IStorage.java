package org.cronos.store;


import org.apache.commons.configuration.Configuration;
import org.cronos.store.entity.*;

import java.util.Date;
import java.util.List;

public interface IStorage {

    public void init(Configuration configuration);

    public OperationResult createApplication(Application application);
    public OperationResult createGroup(Group group);
    public OperationResult createReceiver(Receiver receiver);

    public OperationResult add(Record record);

    public DataMap getDataMap (DataSplit dataSplit);
    public List<DataSplit> getDataSplits(Group group, Date minor, Date major);

    public Application getApplication(String application);
    public Group getGroup(String application, String group);
    public Receiver getReceiver(String application, String group, String receiver);

}
