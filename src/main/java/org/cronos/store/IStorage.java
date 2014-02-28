package org.cronos.store;


import org.cronos.store.entity.*;

import java.util.Date;
import java.util.List;

public interface IStorage {

    public void init(IConfigStorage configStorage);

    public OperationResult createApplication(Application application);
    public OperationResult createGroup(String application, String group);
    public OperationResult createReceiver(String application, String group, String receiver);

    public OperationResult add(Record record);

    public DataMap getDataMap (DataSplit dataSplit);
    public List<DataSplit> getDataSplits(Group group, Date minor, Date major);

    public Application getApplication(String application);
    public Group getGroup(String application, String group);
    public Receiver getReceiver(String application, String group, String receiver);

}
