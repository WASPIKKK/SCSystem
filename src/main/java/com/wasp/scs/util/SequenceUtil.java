package com.wasp.scs.util;

import com.wasp.scs.constant.AppConstant;
import com.wasp.scs.file.AppStorage;

import java.io.*;
import java.nio.file.Files;

public final class SequenceUtil {

    private SequenceUtil() {
    }

    private static boolean checkFile(File file) {
        AppStorage.initDir();
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.valueOf(AppConstant.INITIAL_VALUE));
            } catch (IOException exception) {
                LoggerUtil.loggErrors(exception);
                return false;
            }
        }
        return true;
    }

    public static int readAndUpdate(File file, File tempFileRename) {
        int count;
        if (checkFile(file)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileRename))) {
                String line = reader.readLine();
                int number = Integer.parseInt(line);
                count = number + AppConstant.STEP;
                writer.write(String.valueOf(count));
            } catch (IOException | NumberFormatException exception) {
                LoggerUtil.loggErrors(exception);
                return AppConstant.ERROR_VALUE;
            }
            if (!deleteAndReplaceFile(file, tempFileRename)) {
                return AppConstant.ERROR_VALUE;
            }
        } else {
            return AppConstant.ERROR_VALUE;
        }
        return count;
    }

    private static boolean deleteAndReplaceFile(File file, File tempFileRename) {
        try {
            Files.delete(file.toPath());
            if (!tempFileRename.renameTo(file)) {
                throw new IOException("file can't rename");
            }
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
            return false;
        }
        return true;
    }

}
