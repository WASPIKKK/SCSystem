package com.wasp.scs.util;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.entity.Entity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static com.wasp.scs.util.ConstantUtil.*;

public class BrandCsvUtil implements CsvUtil {

    @Override
    public boolean haveTitle(String line) {
        return line.contains("ID") || line.contains("NAME");
    }

    @Override
    public List<String> readData(File file) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
    public boolean delete(String entity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP_FILE))) {
            List<String> list = readData(BRAND_FILE);
            for (String temp : list) {
                if (!temp.equalsIgnoreCase(entity)) {
                    writer.write(temp + NEW_LINE);
                }
            }
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
        try {
            Files.move(TEMP_FILE.toPath(), BRAND_FILE.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
            return false;
        }
    }

    @Override
    public boolean write(String entity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BRAND_FILE, true))) {
            if (readData(BRAND_FILE).isEmpty()) {
                writer.write(TITLE);
            }
            writer.write(entity + NEW_LINE);
            return true;
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
            return false;
        }
    }

    @Override
    public void update(List<String> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BRAND_FILE))) {
            writer.write(TITLE);
            for (String temp : list) {
                writer.write(temp + NEW_LINE);
            }
        } catch (IOException exception) {
            LoggerUtil.loggErrors(exception);
        }
    }

}
