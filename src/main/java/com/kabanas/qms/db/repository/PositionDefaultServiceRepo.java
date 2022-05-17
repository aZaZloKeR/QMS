package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.PositionDefaultService;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface PositionDefaultServiceRepo extends CrudRepository<PositionDefaultService,Integer> {
}
