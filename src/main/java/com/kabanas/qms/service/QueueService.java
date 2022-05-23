package com.kabanas.qms.service;

import com.kabanas.qms.db.model.Interaction;
import com.kabanas.qms.db.model.ServiceWorker;
import com.kabanas.qms.db.model.Worker;
import com.kabanas.qms.db.repository.InteractionRepo;
import com.kabanas.qms.db.repository.ServiceRepo;
import com.kabanas.qms.db.repository.TempPointWorkerRepo;
import com.kabanas.qms.db.repository.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Service
public class QueueService {
    @Autowired
    InteractionRepo interactionRepo;
    @Autowired
    ServiceRepo serviceRepo;
    @Autowired
    WorkerRepo workerRepo;
    @Autowired
    TempPointWorkerRepo tempPointWorkerRepo;

    //EWE HE Проверял!!!!!!!!!!!!!!
    public void /*возможно не войд*/ checkQueue(){
        /*
        получаем свободных работников
        для работника полуем ждущих клиентов
        получаю услуги работника
        сравниваю клиента и услуги пока не найду совпадение
         */
        ArrayList<Worker> freeWorkers = workerRepo.findByFree("true");
        for (Worker freeWorker: freeWorkers) {
            Iterable<Interaction> interactionListWhereStatusWait = interactionRepo.findByStatusOrderByRequestTime("wait");
            for (Interaction interaction:interactionListWhereStatusWait) {
                Collection<ServiceWorker> serviceWorkers = freeWorker.getServiceWorkers();
                for (ServiceWorker serviceWorker:serviceWorkers) {
                    if(Objects.equals(serviceWorker.getService().getName(), interaction.getService().getName())){
                        freeWorker.setStatus("busy");
                        interaction.setWorker(freeWorker);
                        interaction.setStartTime(new Date());
                        interaction.setPoint(tempPointWorkerRepo.findThisInteractionPoint(freeWorker.getId()).get().getInteractionPoint());
                        interaction.setStatus("waiting for identity confirmation"); // на этом моменте статус находится на верефикации личности
                        // и только потом, когда работник отправит данные о клиенте, статус изменится на served
                    }
                }
            }
        }
    }

    public void createInteraction(int serviceId){
        Interaction interaction = new Interaction();
        if (interactionRepo.findMaxOrigId().isPresent()) {
            interaction.setOrigId(interactionRepo.findMaxOrigId().get() + 1);// нужно каждый раз проверять пользователя на ориг id//(всем похуй)
        }
        else {
            interaction.setOrigId(1);
        }
        interaction.setRequestTime(new Date());
        interaction.setStatus("wait"); // поставить статус wait  =  занести человека в очередь
        interaction.setService(serviceRepo.findById(serviceId).get());
        interactionRepo.save(interaction);
        checkQueue();
    }
}
