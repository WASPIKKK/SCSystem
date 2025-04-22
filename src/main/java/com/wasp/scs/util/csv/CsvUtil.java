package com.wasp.scs.util.csv;

import java.util.List;

public interface CsvUtil {

    void writeToFile(String entity);

    void deleteFromFile(String entity);

    List<String> readFromFile();

    boolean haveTitle(String title);

    String findInFile(long id);

    void rewriteInFile(String entity);


}


