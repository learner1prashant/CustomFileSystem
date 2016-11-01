package com.prashant.filesystem.entity.detail;

/**
 * Created by PPandey on 8/17/2016.
 */
public class EntityName {

    String name;

    public EntityName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityName that = (EntityName) o;

        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "EntityName{" +
                "name='" + name + '\'' +
                '}';
    }
}
