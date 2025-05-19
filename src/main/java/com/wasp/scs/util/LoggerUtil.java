package com.wasp.scs.util;

import com.wasp.scs.constant.StorageConstant;
import com.wasp.scs.exception.LoggerException;

import java.io.*;
import java.time.LocalDate;

public final class LoggerUtil {

    private static final String FILE_NAME = "log.csv";
    private static final String DIR_PATH = String.format("%s/%s/%s", StorageConstant.GENERAL_DIR, StorageConstant.CATALOG_DIR, StorageConstant.LOG_DIR);

    private LoggerUtil() {
    }

    public static void loggException(Exception exception) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(initCsvFile(), true))) {
            writer.write(String.format("%s|%s%s", LocalDate.now(), exception, "\n"));
        } catch (IOException ioException) {
            throw new LoggerException("Can't writing to a file");
        }
    }

    private static File initCsvFile() {
        return DirectoryUtil.getFile(DIR_PATH, FILE_NAME);
    }

}
