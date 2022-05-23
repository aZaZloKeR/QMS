package com.kabanas.qms.controller;

import com.kabanas.qms.db.model.*;
import com.kabanas.qms.db.repository.*;
import com.kabanas.qms.db.representation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DtoController {
    @Autowired
    WorkerRepo workerRepo;
    @Autowired
    PositionRepo positionRepo;
    @Autowired
    InteractionPointRepo interactionPointRepo;
    @Autowired
    InteractionTypePointRepo interactionTypePointRepo;
    @Autowired
    TempPointWorkerRepo tempPointWorkerRepo;
    @Autowired
    ServiceRepo serviceRepo;
    @Autowired
    TypeServiceRepo typeServiceRepo;
    @Autowired
    ServiceWorkerRepo serviceWorkerRepo;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    PositionDefaultServiceRepo positionDefaultServiceRepo;

    @PostMapping(value = "/worker")
    public void addWorker(@RequestBody WorkerRepr workerRepr){
        if (positionRepo.findById(workerRepr.getPositionId()).isPresent()){
            Position position = positionRepo.findById(workerRepr.getPositionId()).get();

            Users user = new Users();
            user.setLogin(workerRepr.getLogin());
            user.setPassword(workerRepr.getPassword());
            user.setRole(workerRepr.getRole());
            usersRepo.save(user);

            Worker worker = new Worker();
            worker.setFirstName(workerRepr.getFirstName());
            worker.setSecondName(workerRepr.getSecondName());
            worker.setPhone(workerRepr.getPhone());
            worker.setStatus("not work");
            worker.setPosition(position);
            worker.setUser(user);
            workerRepo.save(worker);
        }
    }
    @PutMapping(value = "/worker")
    public void updateWorker(@RequestBody WorkerRepr workerRepr){
        if (workerRepo.findById(workerRepr.getId()).isPresent()){
            Worker worker = workerRepo.findById(workerRepr.getId()).get();
            if (positionRepo.findById(workerRepr.getPositionId()).isPresent()){
                Position position = positionRepo.findById(workerRepr.getPositionId()).get();
                worker.setPosition(position);
            }
            if (usersRepo.findByWorker(worker).isPresent()){
                Users user = usersRepo.findByWorker(worker).get();
                if (workerRepr.getLogin() != null) user.setLogin(workerRepr.getLogin());
                if (workerRepr.getPassword() != null) user.setPassword(workerRepr.getPassword());
                if (workerRepr.getRole() != null) user.setRole(workerRepr.getRole());
                usersRepo.save(user);
                worker.setUser(user);
            }
            if (workerRepr.getFirstName() != null) worker.setFirstName(workerRepr.getFirstName());
            if (workerRepr.getSecondName() != null) worker.setSecondName(workerRepr.getSecondName());
            if (workerRepr.getPhone() != null) worker.setPhone(workerRepr.getPhone());

            workerRepo.save(worker);
        }
    }

    @PostMapping(value = "/interactionPoint")
    public void addInteractionPoint(@RequestBody InteractionPointRepr interactionPointRepr){
        if(interactionTypePointRepo.findById(interactionPointRepr.getTypeId()).isPresent()){
            InteractionTypePoint interactionTypePoint = interactionTypePointRepo.findById(interactionPointRepr.getTypeId()).get();

            InteractionPoint interactionPoint = new InteractionPoint();
            interactionPoint.setName(interactionPointRepr.getName());
            interactionPoint.setActive(interactionPointRepr.getActive());
            interactionPoint.setType(interactionTypePoint);
        }
    }
    @PutMapping(value = "/interactionPoint")
    public void updateInteractionPoint(@RequestBody InteractionPointRepr interactionPointRepr){
        if (interactionPointRepo.findById(interactionPointRepr.getId()).isPresent()) {
            InteractionPoint interactionPoint = interactionPointRepo.findById(interactionPointRepr.getId()).get();

            if (interactionTypePointRepo.findById(interactionPointRepr.getTypeId()).isPresent()) {
                InteractionTypePoint interactionTypePoint = interactionTypePointRepo.findById(interactionPointRepr.getTypeId()).get();
                interactionPoint.setType(interactionTypePoint);
            }
            if (interactionPointRepr.getName() != null) interactionPoint.setName(interactionPointRepr.getName());
            if (interactionPointRepr.getActive() != null) interactionPoint.setActive(interactionPointRepr.getActive());
        }
    }

    @PostMapping(value = "/tempPointWorker")
    public void addTempPointWorker(@RequestBody TempPointWorkerRepr tempPointWorkerRepr){
        if (interactionPointRepo.findById(tempPointWorkerRepr.getPointId()).isPresent()){
            if (workerRepo.findById(tempPointWorkerRepr.getWorkerId()).isPresent()){
                Worker worker = workerRepo.findById(tempPointWorkerRepr.getWorkerId()).get();
                InteractionPoint interactionPoint = interactionPointRepo.findById(tempPointWorkerRepr.getPointId()).get();

                TempPointWorker tempPointWorker = new TempPointWorker();
                tempPointWorker.setStartTime(new Date());
                tempPointWorker.setWorker(worker);
                tempPointWorker.setInteractionPoint(interactionPoint);
                tempPointWorkerRepo.save(tempPointWorker);
            }
        }
    }

    @PutMapping(value = "/tempPointWorker")
    public void updateTempPointWorker(@RequestBody TempPointWorkerRepr tempPointWorkerRepr){

    }

    @PostMapping(value = "/typeService")
    public void addTypeService(@RequestBody TypeServiceRepr typeServiceRepr){
        if (interactionTypePointRepo.findById(typeServiceRepr.getTypeId()).isPresent()){
            if (serviceRepo.findById(typeServiceRepr.getServiceId()).isPresent()){
                InteractionTypePoint typePoint = interactionTypePointRepo.findById(typeServiceRepr.getTypeId()).get();
                Service service = serviceRepo.findById(typeServiceRepr.getServiceId()).get();

                TypeService typeService = new TypeService();
                typeService.setService(service);
                typeService.setType(typePoint);
                typeServiceRepo.save(typeService);
            }
        }
    }
    @PutMapping(value = "/typeService")
    public void updateTypeService(@RequestBody TypeServiceRepr typeServiceRepr){

    }

    @PostMapping(value = "/serviceWorker")
    public void addServiceWorker(@RequestBody ServiceWorkerRepr serviceWorkerRepr){
        if (serviceRepo.findById(serviceWorkerRepr.getServiceId()).isPresent()){
            if (workerRepo.findById(serviceWorkerRepr.getWorkerId()).isPresent()){
                Service service = serviceRepo.findById(serviceWorkerRepr.getServiceId()).get();
                Worker worker = workerRepo.findById(serviceWorkerRepr.getWorkerId()).get();

                ServiceWorker serviceWorker = new ServiceWorker();
                serviceWorker.setService(service);
                serviceWorker.setWorker(worker);
                serviceWorkerRepo.save(serviceWorker);
            }
        }
    }

    @PutMapping(value = "/serviceWorker")
    public void updateServiceWorker(@RequestBody ServiceWorkerRepr serviceWorkerRepr){

    }
    @PostMapping(value = "/positionDefaultService")
    public void addPositionDefaultService(@RequestBody PositionDefaultServiceRepr positionDefaultServiceRepr){
        if (positionRepo.findById(positionDefaultServiceRepr.getPositionId()).isPresent()){
            if (serviceRepo.findById(positionDefaultServiceRepr.getServiceId()).isPresent()){
                Position position = positionRepo.findById(positionDefaultServiceRepr.getPositionId()).get();
                Service service = serviceRepo.findById(positionDefaultServiceRepr.getServiceId()).get();

                PositionDefaultService positionDefaultService = new PositionDefaultService();
                positionDefaultService.setPosition(position);
                positionDefaultService.setService(service);
                positionDefaultServiceRepo.save(positionDefaultService);
            }
        }
    }
    @PutMapping(value = "/positionDefaultService")
    public void updatePositionDefaultService(@RequestBody PositionDefaultServiceRepr positionDefaultServiceRepr){

    }
}
