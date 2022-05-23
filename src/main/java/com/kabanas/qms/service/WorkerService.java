package com.kabanas.qms.service;

import com.kabanas.qms.db.model.Customer;
import com.kabanas.qms.db.model.Interaction;
import com.kabanas.qms.db.repository.CustomerRepo;
import com.kabanas.qms.db.repository.InteractionRepo;
import com.kabanas.qms.db.repository.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WorkerService {

    @Autowired
    WorkerRepo workerRepo;
    @Autowired
    InteractionRepo interactionRepo;
    @Autowired
    CustomerRepo customerRepo;

    public void verifyClient(Customer newCustomer, Integer workerId){
        if (interactionRepo.findTopByWorkerIdAndStatus("waiting for identity confirmation",workerId).isPresent()) {
            Interaction interaction = interactionRepo.findTopByWorkerIdAndStatus("waiting for identity confirmation",workerId).get();
            customerRepo.save(newCustomer);
            interaction.setCustomer(newCustomer);
            interaction.setStatus("served");
            interactionRepo.save(interaction);

        }
    }
    public void completeService(Integer workerId){
        if (interactionRepo.findTopByWorkerIdAndStatus("served",workerId).isPresent()){
            Interaction interaction = interactionRepo.findTopByWorkerIdAndStatus("served",workerId).get();
            interaction.setStatus("complete");
            interaction.setEndTime(new Date());
            interactionRepo.save(interaction);
        }
    }
    public void leaveWorkplace(int id){

    }
}
