package com.prashant.filesystem;

import com.prashant.filesystem.exception.InValidEntityNameException;
import com.prashant.filesystem.exception.InValidFilePathException;
import com.prashant.filesystem.factory.EntityType;
import com.prashant.filesystem.factory.FileEntityFactory;
import com.prashant.filesystem.repository.FileRepository;

import java.util.List;

public class FileSystem
{
    //Composition to follow Single responsiblity principle
    FileRepository repository;
    FileEntityFactory factory;

    public FileSystem() {
        factory = new FileEntityFactory();
        repository = new FileRepository();
    }

    public FileRepository getRepository() {
        return repository;
    }

    public EntityReference createFileEntity(String path, String name,EntityType entityType){
        EntityReference parent = null;
        EntityReference reference = null;
        try {
            parent = repository.getParentEntity(path);
            reference = createEntity(parent, name,entityType);
        } catch (InValidEntityNameException|InValidFilePathException e) {
            e.printStackTrace();
        }

        return reference;
    }

    public List<EntityReference> getEntitiesByPathName(String path)
    {
        try {
            return  repository.getEntityByPath(path).getChildEntities();
        } catch (InValidEntityNameException|InValidFilePathException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeEntity(String path,String entityName)
    {
        EntityReference reference = null;
        try {
            reference = repository.getEntityByPath(path);
        } catch (InValidEntityNameException|InValidFilePathException e) {
            e.printStackTrace();
        }
        reference.remove(entityName);
    }


    public EntityReference updateFileEntity(String pathName, String entityName) {
        return null;
    }



    private EntityReference createEntity(EntityReference parent,String name,EntityType type) throws InValidEntityNameException, InValidFilePathException {
       EntityReference reference= factory.createEntity(type,name);
        parent.addEntity(reference);
        return reference;
    }


    public EntityReference getFileEntities() {
        return repository.getRoot();
    }
}
