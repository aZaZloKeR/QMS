package com.kabanas.qms.controller;

import com.kabanas.qms.db.model.*;
import com.kabanas.qms.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

@Controller
public class TestController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private InteractionRepo interactionRepo;
    @Autowired
    private InteractionPointRepo interactionPointRepo;
    @Autowired
    private InteractionTypePointRepo interactionTypePointRepo;
    @Autowired
    private TypeServiceRepo typeServiceRepo;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private PositionDefaultServiceRepo positionDefaultServiceRepo;
    @Autowired
    private ServiceRepo serviceRepo;
    @Autowired
    private WorkerRepo workerRepo;
    @Autowired
    private TempPointWorkerRepo tempPointWorkerRepo;

    @GetMapping(value = "/testSelect")
    public @ResponseBody String testSelect(){
        return  tempPointWorkerRepo.findThisInteractionPoint(3).get().getInteractionPoint().getType().getName();
    }
    @GetMapping(value = "/test")
    public @ResponseBody Iterable<Interaction> test(){
        return interactionRepo.findByStatusOrderByRequestTime("wait");
    }

    @GetMapping(value = "/test/test")
    public @ResponseBody void testTest(){
        Interaction interaction = new Interaction();
        if (interactionRepo.findMaxOrigId().isPresent()) {
            interaction.setOrigId(interactionRepo.findMaxOrigId().get() + 1);// нужно каждый раз проверять пользователя на ориг id СЕЙЧАС ПРОСТО ПОСТАВИТЬ НАДО БУДЕТ IDENTITY для него
        }
        else {
            interaction.setOrigId(1);
        }
        interaction.setRequestTime(new Date());
        interaction.setStatus("wait"); // поставить статус wait  =  занести человека в очередь
        interaction.setService(serviceRepo.findById(1).get());
        interactionRepo.save(interaction);
    }
}
