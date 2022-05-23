package com.kabanas.qms.db.repository;

import com.kabanas.qms.db.key.TempPointWorkerKey;
import com.kabanas.qms.db.model.InteractionPoint;
import com.kabanas.qms.db.model.TempPointWorker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.PersistenceContext;
import java.util.Optional;

@PersistenceContext(unitName = "QMS")
public interface TempPointWorkerRepo extends CrudRepository<TempPointWorker,Integer> {
    @Query(value = "SELECT tpw from TempPointWorker tpw where tpw.worker.id = ?1 and tpw.endTime is null")
     Optional<TempPointWorker> findThisInteractionPoint(Integer workerId);

    Optional<TempPointWorker> findByTempPointWorkerKey(TempPointWorkerKey tempPointWorkerKey);
}
