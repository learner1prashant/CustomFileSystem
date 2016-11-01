package com.prashant.filesystem;

import java.util.List;
import java.util.Map;

public interface EntityReference
{
    String getName();
    List<EntityReference> getChildEntities();
    EntityReference getEntityByName(String name);
    void addEntity(EntityReference child);
    void remove(String entity);

}
