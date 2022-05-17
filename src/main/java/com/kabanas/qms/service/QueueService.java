package com.kabanas.qms.service;

import com.kabanas.qms.db.model.Interaction;
import com.kabanas.qms.db.model.ServiceWorker;
import com.kabanas.qms.db.model.Worker;
import com.kabanas.qms.db.repository.InteractionRepo;
import com.kabanas.qms.db.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class QueueService {

    @Autowired
    InteractionRepo interactionRepo;

    @Autowired
    ServiceRepo serviceRepo;

/*    public String checkQueue(){ // получю воркеров,которые могут оказать данную услугу, затем добавляю посетителя в буфер
        // и при освобождении воркера даю ему нового посетителя.
        Iterable<Interaction> interactionListWhereStatusWait = interactionRepo.findByStatus("wait");
        for (Interaction interaction: interactionListWhereStatusWait) {
            Worker Workers = interaction.getWorker();

        }


        ///////////////////////////////////
        Iterable<Interaction> interactionListWhereStatusInProcess = interactionRepo.findByStatus("inProcess");
        for(Interaction interaction: interactionListWhereStatusInProcess) {
            Worker workers = interaction.getWorker(); // тут получаю воркеров,которые заняты
        }
    }

    public void createInteraction(int serviceId){
        Interaction interaction = new Interaction();
        if (interactionRepo.findMaxOrigId().isPresent()) {
            interaction.setOrigId(interactionRepo.findMaxOrigId().get() + 1);// нужно каждый раз проверять пользователя на ориг id СЕЙЧАС ПРОСТО ПОСТАВИТЬ НАДО БУДЕТ IDENTITY для него
        }
        else {
            interaction.setOrigId(1);
        }
        interaction.setRequestTime(new Date());
        interaction.setStatus("wait"); // поставить статус wait  =  занести человека в очередь
        interaction.setService(serviceRepo.findById(serviceId).get());
        interactionRepo.save(interaction);
        checkQueue();
    }*/
}
