package com.prashant.filesystem.entity.detail;
import com.prashant.filesystem.EntityReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileEntity implements EntityReference {
    protected EntityName entityName;
    protected Map<EntityName,EntityReference> entityChildMap;

    public FileEntity(String name)
    {
        entityName = new EntityName(name);
        entityChildMap= new HashMap<EntityName,EntityReference>();
    }

    @Override
    public String getName() {
        return entityName.getName();
    }

    @Override
    public List<EntityReference> getChildEntities() {
        List<EntityReference> entities = new LinkedList<>(entityChildMap.values());
        return entities;
    }

    @Override
    public EntityReference getEntityByName(String name) {
        EntityName entityName = new EntityName(name);
        return entityChildMap.get(entityName);
    }

    @Override
    public void addEntity(EntityReference child) {
        entityChildMap.put(new EntityName(child.getName()),child);
    }

    @Override
    public void remove(String name) {
        entityChildMap.remove(new EntityName(name));
    }
}
