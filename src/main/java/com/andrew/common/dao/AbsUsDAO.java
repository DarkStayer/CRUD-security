package com.andrew.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbsUsDAO {
    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
}
