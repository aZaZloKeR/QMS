package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.ServiceWorker;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface ServiceWorkerRepo extends CrudRepository<ServiceWorker,Integer> {
}
