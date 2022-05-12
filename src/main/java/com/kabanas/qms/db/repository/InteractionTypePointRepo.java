package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.InteractionTypePoint;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface InteractionTypePointRepo extends CrudRepository<InteractionTypePoint,Integer> {
}
