package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Customer;
import com.kabanas.qms.db.model.TagService;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface TagServiceRepo extends CrudRepository<TagService,Integer> {
}
