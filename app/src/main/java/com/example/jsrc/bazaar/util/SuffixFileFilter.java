package com.example.jsrc.bazaar.util;

import java.io.File;
import java.io.FileFilter;

public interface SuffixFileFilter extends FileFilter
{
    boolean accept(File pathname);
}
