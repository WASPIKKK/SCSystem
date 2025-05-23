package com.wasp.scs.service.validator;

import com.wasp.scs.entity.Entity;

public interface ValidatorService<T extends Entity> {

    default boolean isValid(T entity) {
        return entity != null && entity.getName() != null && !entity.getName().isEmpty();
    }
}
