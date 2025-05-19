package com.wasp.scs.util;

import java.io.*;

public final class DirectoryUtil {

    private DirectoryUtil() {
    }

    public static File getFile(String dirPath , String nameFile) {
        if (prepareDir(dirPath)) {
            return new File(dirPath, nameFile);
        }
        return null;
    }

    private static boolean prepareDir(String dirPath) {
        File file = new File(dirPath );
        return file.exists() || file.mkdirs();
    }
}
