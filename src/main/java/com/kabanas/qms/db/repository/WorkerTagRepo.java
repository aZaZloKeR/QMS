package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Customer;
import com.kabanas.qms.db.model.WorkerTag;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface WorkerTagRepo extends CrudRepository<WorkerTag,Integer> {
}
