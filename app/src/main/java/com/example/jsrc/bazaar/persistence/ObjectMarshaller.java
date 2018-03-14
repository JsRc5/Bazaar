package com.example.jsrc.bazaar.persistence;

import java.io.File;

public interface ObjectMarshaller <T>
{
    void save (File ouputFile, T target) throws Exception;  //ASAP uses objectMarsherlerException which extends Exception
    T load(File inputFile) throws Exception;
}
