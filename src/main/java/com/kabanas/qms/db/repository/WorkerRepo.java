package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Customer;
import com.kabanas.qms.db.model.Worker;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;


@PersistenceContext(unitName = "QMS")
public interface WorkerRepo extends CrudRepository<Worker,Integer> {
    ArrayList<Worker> findByFree(String free);
}
