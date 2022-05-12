package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.InteractionPoint;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface InteractionPointRepo extends CrudRepository<InteractionPoint,Integer> {
}
