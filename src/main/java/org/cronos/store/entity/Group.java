package org.cronos.store.entity;


import java.util.HashMap;
import java.util.Map;

public class Group implements ICronosComponent {
    private final Application application;
    private final String name;

    public Group(Application application, String name){
        this.application=application;
        this.name=name;
    }

    public Application getApplication() {
        return application;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getReference() {
        return this.application.getReference() + "." + this.name;
    }

    @Override
    public Map<String, String> getProperties() {
        Map<String,String> result=new HashMap<>();
        result.put("name",this.name);
        result.put("reference",this.getReference());
        return result;
    }

}
