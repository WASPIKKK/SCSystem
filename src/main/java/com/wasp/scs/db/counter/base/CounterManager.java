package com.wasp.scs.db.counter.base;

import com.wasp.scs.util.DirectoryUtil;
import com.wasp.scs.util.LoggerUtil;

import java.io.*;

public abstract class CounterManager {

    protected static final String FILE_NAME = "count.csv";

    private static final int INITIAL_VALUE = 0;
    private static final int STEP = 1;
    private int currentId = 0;

    public abstract boolean generateNextId();

    public abstract void restorePreviousId();

    public int getCurrentId() {
        return currentId;
    }

    protected boolean writeToFile(File file, boolean isRollback) {
        if (initFile(file)) {
            String line = readFile(file);
            if (line != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    if (isRollback) {
                        writer.write(parseAndDecrement(line));
                    } else {
                        writer.write(parseAndIncrement(line));
                    }
                    return true;
                } catch (IOException | NumberFormatException exception) {
                    LoggerUtil.loggException(exception);
                }
            }
        }
        return false;
    }

    protected String readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.readLine();
        } catch (IOException ioException) {
            LoggerUtil.loggException(ioException);
            return null;
        }
    }

    private boolean initFile(File file) {
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.valueOf(INITIAL_VALUE));
            } catch (IOException exception) {
                LoggerUtil.loggException(exception);
                return false;
            }
        }
        return true;
    }

    protected File prepareDirAndFile(String dirPath) {
        return DirectoryUtil.getFile(dirPath, FILE_NAME);
    }

    private void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    private String parseAndIncrement(String id) {
        int parsedId = Integer.parseInt(id);
        int nextId = parsedId + STEP;
        setCurrentId(nextId);
        return String.valueOf(nextId);
    }

    private String parseAndDecrement(String id) {
        int parsedId = Integer.parseInt(id);
        if (parsedId == INITIAL_VALUE) {
            return String.valueOf(parsedId);
        }
        int nextId = parsedId - STEP;
        setCurrentId(nextId);
        return String.valueOf(nextId);
    }


}
