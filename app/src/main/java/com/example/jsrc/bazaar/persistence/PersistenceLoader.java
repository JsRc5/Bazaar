package com.example.jsrc.bazaar.persistence;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersistenceLoader<T>
{
    private final ObjectMarshaller<T> _unmarshaller;

    public PersistenceLoader(final ObjectMarshaller<T> unmarshaller)
    {
        _unmarshaller = unmarshaller;
    }

    public List<T> loadObjects(final File objectDir, final FileFilter objectsFileFilter) {
        final File[] objectsFiles = objectDir.listFiles(objectsFileFilter);

//        if(objectsFiles == null)
//            return ImmutableList.Of(); //unable to import com.google.common

        final List<T> objects = new ArrayList<T>(objectsFiles.length);

        for (int i = 0; i < objectsFiles.length; i++) {
            try {
                final T object = _unmarshaller.load(objectsFiles[i]);
                objects.add(object);
            } catch (final Exception e) {
                System.out.print("Failed to load file: " + objectsFiles[i] + " " + e);
            }

        }
        return objects;
    }

    public List<T> loadObjects(final File objectsDir, final FileFilter objectsFileFilter, final Comparator<T> comparator)
    {
        final List<T> objects = loadObjects(objectsDir, objectsFileFilter);
        Collections.sort(objects, comparator);
        return objects;
    }
}
