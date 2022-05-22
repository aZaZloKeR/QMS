package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.model.Interaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Optional;

@PersistenceContext(unitName = "QMS")
public interface InteractionRepo extends CrudRepository<Interaction,Integer> {

    Iterable<Interaction> findByStatus(String status);

    @Query(value = "SELECT max(origId) FROM Interaction")
    Optional<Integer> findMaxOrigId();

    @Query(value = "SELECT min(requestTime) FROM Interaction where status = 'wait' and worker is null ")
    Optional<Interaction> findLongestWaitingTime();

    Iterable<Interaction> findByStatusOrderByRequestTime(String status);
}
