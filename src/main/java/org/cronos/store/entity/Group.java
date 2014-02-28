package org.cronos.store.entity;


public class Group {
    private Application application;
    private String name;

    public Group(Application application, String name){
        this.application=application;
        this.name=name;
    }

    public Application getApplication() {
        return application;
    }

    public String getName() {
        return name;
    }

}
