package com.wasp.scs.file.csv;

import com.wasp.scs.file.AppStorage;
import com.wasp.scs.util.LoggerUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class CsvManager {

    static {
        AppStorage.initDir();
    }

    protected List<String> readFromFile(File entityFile) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(entityFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!haveTitle(line)) {
                    stringList.add(line);
                }
            }
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
        return stringList;
    }

    protected void writeToFile(String entity, File entityFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(entityFile, true))) {
            if (readFromFile(entityFile).isEmpty()) {
                writer.write(AppStorage.TITLE);
            }
            writer.write(String.format("%s%s", entity, AppStorage.NEW_LINE));
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
    }


    protected void rewriteInFile(String entity, File entityFile) {
        List<String> listEntity = readFromFile(entityFile);
        String entityId = entity.substring(0, entity.indexOf(";"));
        StringBuilder stringBuilderEntity = new StringBuilder();
        stringBuilderEntity.append(AppStorage.TITLE);
        for (String tempEntity : listEntity) {
            if (tempEntity.startsWith(entityId)) {
                stringBuilderEntity.append(entity);
            } else {
                stringBuilderEntity.append(tempEntity);
            }
            stringBuilderEntity.append(AppStorage.NEW_LINE);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(entityFile))) {
            writer.write(stringBuilderEntity.toString());
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
    }

    protected String findInFile(long id, File entityFile) {
        List<String> stringList = readFromFile(entityFile);
        for (String entity : stringList) {
            if (entity.startsWith(String.valueOf(id))) {
                return entity;
            }
        }
        return null;
    }

    protected void deleteFromFile(String entity, File entityFile) {
        List<String> list = readFromFile(entityFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(entityFile))) {
            boolean titleWritten = false;
            for (String temp : list) {
                if (!temp.equalsIgnoreCase(entity)) {
                    if (!titleWritten) {
                        writer.write(AppStorage.TITLE);
                        titleWritten = true;
                    }
                    writer.write(String.format("%s%s", temp, AppStorage.NEW_LINE));
                }
            }
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
    }

    protected boolean haveTitle(String line) {
        return line.contains("ID") || line.contains("NAME");
    }

}
