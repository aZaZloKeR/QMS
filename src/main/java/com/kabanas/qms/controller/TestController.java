package com.kabanas.qms.controller;

import com.kabanas.qms.db.model.*;
import com.kabanas.qms.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private PositionDefaultTagRepo positionDefaultTagRepo;
    @Autowired
    private ServiceRepo serviceRepo;
    @Autowired
    private TagRepo tagRepo;
    @Autowired
    private WorkerRepo workerRepo;
    @Autowired
    private WorkerTagRepo workerTagRepo;

    @GetMapping(value = "/test")
    public @ResponseBody Iterable<Interaction> test(){
        return interactionRepo.findAll();
    }
    @GetMapping(value = "/test/test")
    public @ResponseBody Iterable<InteractionPoint> testTest(){
        return interactionPointRepo.findAll();
    }
}
