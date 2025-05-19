package com.wasp.scs.db.csv.base;

import com.wasp.scs.util.DirectoryUtil;
import com.wasp.scs.util.LoggerUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class EntityCsvManager {

    protected static final String NEW_LINE = "\n";
    protected static final String SEPARATOR = ";";

    protected String getTitle(){
        return String.format("ID%sNAME%s", SEPARATOR, NEW_LINE);
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
            LoggerUtil.loggException(exception);
        }
        return stringList;
    }

    protected boolean writeToFile(String entity, File entityFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(entityFile, true))) {
            if (entityFile.exists() && entityFile.length() == 0) {
                writer.write(getTitle());
            }
            writer.write(String.format("%s%s", entity, NEW_LINE));
        } catch (IOException exception) {
            LoggerUtil.loggException(exception);
            return false;
        }
        return true;
    }

    protected boolean rewriteToFile(String entity, File entityFile) {
        List<String> listEntity = readFromFile(entityFile);
        String entityId = entity.substring(0, entity.indexOf(SEPARATOR));
        StringBuilder stringBuilderEntity = new StringBuilder();
        stringBuilderEntity.append(getTitle());

        for (String tempEntity : listEntity) {
            if (tempEntity.startsWith(entityId)) {
                stringBuilderEntity.append(entity);
            } else {
                stringBuilderEntity.append(tempEntity);
            }
            stringBuilderEntity.append(NEW_LINE);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(entityFile))) {
            writer.write(stringBuilderEntity.toString());
        } catch (IOException exception) {
            LoggerUtil.loggException(exception);
            return false;
        }
        return true;
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

    protected boolean deleteFromFile(String entity, File entityFile) {
        List<String> list = readFromFile(entityFile);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(entityFile))) {
            boolean titleWritten = false;

            for (String temp : list) {
                if (!temp.equals(entity)) {
                    if (!titleWritten) {
                        writer.write(getTitle());
                        titleWritten = true;
                    }
                    writer.write(String.format("%s%s", temp, NEW_LINE));
                }
            }
        } catch (IOException exception) {
            LoggerUtil.loggException(exception);
            return false;
        }
        return true;
    }

    protected File prepareDirAndFile(String dirPath, String fileName) {
        return DirectoryUtil.getFile(dirPath, fileName);
    }

    private boolean haveTitle(String line) {
        return line.contains("ID") || line.contains("NAME");
    }


}
