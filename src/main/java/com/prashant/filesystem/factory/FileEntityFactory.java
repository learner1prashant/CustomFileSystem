package com.prashant.filesystem.factory;
import com.prashant.filesystem.EntityReference;

public class FileEntityFactory {
    //factory pattern to achieve dependency inversion
    public EntityReference createEntity(EntityType entityType, String name)
    {   // open close principle
         for (EntityType type : EntityType.values()) {
              if (type.equals(entityType))
                  return type.getFileEntity(name);
         }
         return null;
    }

}
