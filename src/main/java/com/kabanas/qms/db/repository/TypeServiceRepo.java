package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.TypeService;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface TypeServiceRepo extends CrudRepository<TypeService,Integer> {
}
