package com.wasp.scs.mapper.base;

import com.wasp.scs.entity.Entity;
import com.wasp.scs.db.csv.base.EntityCsvManager;

import java.util.List;

public abstract class EntityMapper<T extends Entity, U extends EntityCsvManager> {

    public abstract List<T> mapToList(U csvManager);

    public abstract T mapToEntity(String entity);

}
