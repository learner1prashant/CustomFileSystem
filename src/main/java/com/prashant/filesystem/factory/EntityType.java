package com.prashant.filesystem.factory;

import com.prashant.filesystem.EntityReference;
import com.prashant.filesystem.entity.Directory;
import com.prashant.filesystem.entity.Drive;
import com.prashant.filesystem.entity.file.File;

public enum EntityType {
    FILE{
        @Override
        public EntityReference getFileEntity(String name) {
            return new File(name);
        }
    },
    DIRECTORY{
        @Override
        public EntityReference getFileEntity(String name) {
            return new Directory(name);
        }
    },
    DRIVE{
        @Override
        public EntityReference getFileEntity(String name) {
            return new Drive(name);
        }
    };

    public abstract EntityReference getFileEntity(String name);

    public EntityType getEntityByName(String name){
        return this;
    }

}
