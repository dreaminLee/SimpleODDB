package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.object.Object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ObjectStorage implements Serializable {

    private HashMap<String, ArrayList<Object>> className2ObjectList = new HashMap<>();

    public void addObjectList(String className) {
        className2ObjectList.put(className, new ArrayList<>());
    }

    public void removeObjectList(String className) {
        className2ObjectList.remove(className);
    }

    public void insertObject(String className, Object object) {
        if (DB.getCatalog().getClassType(className) == Catalog.ClassType.SOURCECLASS) {
            className2ObjectList.get(className).add(object);
            if (DB.getCatalog().getClassHasSubclass(className)) {

            }
        }
    }

    public void deleteObject() {

    }

    public void updateObject() {

    }
}
