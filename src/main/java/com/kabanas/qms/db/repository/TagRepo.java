package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Tag;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;

@PersistenceContext(unitName = "QMS")
public interface TagRepo extends CrudRepository<Tag, Integer> {

}
