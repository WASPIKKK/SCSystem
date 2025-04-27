package com.wasp.scs.util;

import com.wasp.scs.exception.LogException;
import com.wasp.scs.file.AppStorage;

import java.io.*;
import java.time.LocalDate;

public final class LoggerUtil {

    static {
        AppStorage.initDir();
    }

    private LoggerUtil() {
    }

    public static void loggErrors(Exception exception) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(AppStorage.LOG_FILE, true))) {
            writer.write(String.format("%s|%s%s", LocalDate.now(), exception, AppStorage.NEW_LINE));
        } catch (IOException ioException) {
            throw new LogException("Can't writing to a file");
        }
    }

}
