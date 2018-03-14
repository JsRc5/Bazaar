package com.example.jsrc.bazaar.util;

import java.io.File;
import java.io.IOException;

public interface CRCFileUtilAccesor
{
    void createCRCFile(File file);
    void validateFile(File inputFile) throws IOException;
    File getCRCFile(File file);
}
