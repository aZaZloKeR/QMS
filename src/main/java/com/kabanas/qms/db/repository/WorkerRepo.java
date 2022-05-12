package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Customer;
import com.kabanas.qms.db.model.Worker;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface WorkerRepo extends CrudRepository<Worker,Integer> {
}
