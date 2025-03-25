package com.wasp.scs.util;

import java.io.*;
import java.nio.file.Files;

public final class SequenceUtil {

    private SequenceUtil() {
    }

    public static int counter(File file) {
        int counter;
        int badReturn = -1;
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("0");
            } catch (IOException exception) {
                LoggerUtil.loggErrors(exception);
                return badReturn;
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(ConstantUtil.TEMP_FILE))) {
            String line = reader.readLine();
            int number = Integer.parseInt(line);
            counter = ++number;
            writer.write(String.valueOf(counter));
        } catch (IOException | NumberFormatException exception) {
            LoggerUtil.loggErrors(exception);
            return badReturn;
        }

        try {
            Files.delete(file.toPath());
            if (!ConstantUtil.TEMP_FILE.renameTo(file)) {
                throw new IOException("file can't rename");
            }
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
            return badReturn;
        }

        return counter;
    }
}
