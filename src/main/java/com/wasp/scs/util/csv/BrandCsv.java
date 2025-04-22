package com.wasp.scs.util.csv;

import com.wasp.scs.constant.AppConstant;
import com.wasp.scs.file.FileStorage;
import com.wasp.scs.util.LoggerUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class BrandCsv implements CsvUtil {

    @Override
    public boolean haveTitle(String line) {
        return line.contains("ID") || line.contains("NAME");
    }

    @Override
    public List<String> readFromFile() {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FileStorage.BRAND_FILE))) {
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

    @Override
    public void deleteFromFile(String entity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileStorage.TEMP_FILE))) {
            List<String> list = readFromFile();
            for (String temp : list) {
                if (!temp.equalsIgnoreCase(entity)) {
                    writer.write(String.format("%s%s", temp, AppConstant.NEW_LINE));
                }
            }
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
        try {
            Files.move(FileStorage.TEMP_FILE.toPath(), FileStorage.BRAND_FILE.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
    }

    @Override
    public void writeToFile(String entity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileStorage.BRAND_FILE, true))) {
            if (readFromFile().isEmpty()) {
                writer.write(AppConstant.TITLE);
            }
            writer.write(String.format("%s%s", entity, AppConstant.NEW_LINE));
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
    }

    public void rewriteInFile(String entity) {
        List<String> listEntity = readFromFile();
        String entityId = entity.substring(0, entity.indexOf(";"));
        StringBuilder stringBuilderEntity = new StringBuilder();
        stringBuilderEntity.append(AppConstant.TITLE);
        for (String tempEntity : listEntity) {
            if (tempEntity.startsWith(entityId)) {
                stringBuilderEntity.append(entity);
            } else {
                stringBuilderEntity.append(tempEntity);
            }
            stringBuilderEntity.append(AppConstant.NEW_LINE);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileStorage.BRAND_FILE))) {
            writer.write(stringBuilderEntity.toString());
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
    }

    public String findInFile(long id) {
        List<String> stringList = readFromFile();
        for (String entity : stringList) {
            if (entity.startsWith(String.valueOf(id))) {
                return entity;
            }
        }
        return null;
    }

}
