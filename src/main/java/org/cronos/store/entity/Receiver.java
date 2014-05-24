package org.cronos.store.entity;

import java.util.HashMap;
import java.util.Map;

public class Receiver implements ICronosComponent {
    private final Group group;
    private final String name;

    public Receiver(Group group,String name){
        this.group=group;
        this.name=name;
    }

    public Group getGroup() {
        return group;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getReference() {
        return this.group.getReference() + "." +this.name;
    }

    @Override
    public Map<String, String> getProperties() {
        Map<String,String> result=new HashMap<>();
        result.put("name",this.name);
        result.put("reference",this.getReference());
        return result;
    }


}
