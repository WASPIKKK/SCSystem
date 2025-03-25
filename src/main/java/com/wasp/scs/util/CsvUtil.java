package com.wasp.scs.util;

import java.io.File;
import java.util.List;

public interface CsvUtil {

    boolean write(String entity);

    boolean delete(String entity);

    void update(List<String> list);

    List<String> readData(File file);

    boolean haveTitle(String title);


}


