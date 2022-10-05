package com.lti.inventory.controller;

import com.lti.inventory.model.Factory;
import com.lti.inventory.service.factoryservices.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FactoryController {

    @Autowired
    FactoryService service;

    @GetMapping(value={"/factories"})
    public List<Factory> getFactories(){
        return service.getAllFactories();
    }

    @PostMapping("/add-factory")
    public List<Factory> addFactory(@RequestBody  Factory f){
        return service.addFactory(f);
    }

    @PutMapping("/update-factory")
    public List<Factory> updateFactory(@RequestBody Factory f){
        return service.updateFactory(f.getFactoryId(), f);
    }

    @DeleteMapping("/delete-factory/{id}")
    public List<Factory> deleteFactory(@PathVariable int id){
        return service.removeFactory(id);
    }
}
