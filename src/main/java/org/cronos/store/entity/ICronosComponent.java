package org.cronos.store.entity;

import java.util.Map;

public interface ICronosComponent {
    public String getName();
    public String getReference();
    public Map<String,String> getProperties();

}
