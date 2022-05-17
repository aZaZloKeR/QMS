package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.TempPointWorker;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface TempPointWorkerRepo extends CrudRepository<TempPointWorker,Integer> {
}
