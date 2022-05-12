package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface CustomerRepo extends CrudRepository<Customer,Integer> {
}
