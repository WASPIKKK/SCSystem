package com.wasp.scs.mapper;

import com.wasp.scs.entity.Entity;
import com.wasp.scs.file.csv.CsvManager;

import java.util.List;

public interface EntityMapper<T extends Entity, U extends CsvManager> {

    List<T> fileToListEntity(U csvManager);

    T stringToEntity(String entity);

}
