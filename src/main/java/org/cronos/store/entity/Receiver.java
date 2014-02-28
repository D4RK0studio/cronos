package org.cronos.store.entity;

public class Receiver {
    private Group group;
    private String name;

    public Receiver(Group group,String name){
        this.group=group;
        this.name=name;
    }

    public Group getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }
}
