package com.wasp.scs.util;

import com.wasp.scs.constant.AppConstant;
import com.wasp.scs.exception.LogException;
import com.wasp.scs.file.FileStorage;

import java.io.*;
import java.time.LocalDate;

public class LoggerUtil {

    private LoggerUtil() {
    }

    public static void loggErrors(Exception exception) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileStorage.LOGS, true))) {
            writer.write(String.format("%s|%s%s",LocalDate.now(), exception, AppConstant.NEW_LINE));
        } catch (IOException ioException) {
            throw new LogException("Error when writing to a file");
        }
    }

}
