package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Interaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;
import java.util.Optional;

@PersistenceContext(unitName = "QMS")
public interface InteractionRepo extends CrudRepository<Interaction,Integer> {


    @Query(value = "SELECT max(origId) FROM Interaction")
    public Optional<Integer> findMaxOrigId();
}
