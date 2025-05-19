package com.wasp.scs.service.validator;

import com.wasp.scs.entity.Entity;

public interface ValidatorService<T extends Entity> {

    boolean isValid(T entity);
}
