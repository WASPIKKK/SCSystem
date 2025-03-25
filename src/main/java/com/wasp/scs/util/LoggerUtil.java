package com.wasp.scs.util;

import com.wasp.scs.exception.LogException;

import java.io.*;
import java.time.LocalDate;

public class LoggerUtil {

    private static final File logs = new File("src/main/resource/error/logs.txt");

    private LoggerUtil() {
    }

    public static void loggErrors(Exception exception) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logs, true))) {
            writer.write(LocalDate.now() + "|" + exception + ConstantUtil.NEW_LINE);
        } catch (IOException ioException) {
            throw new LogException("Ошибка при записи в файл");
        }
    }

}
