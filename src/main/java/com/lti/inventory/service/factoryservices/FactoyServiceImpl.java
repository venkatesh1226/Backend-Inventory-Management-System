package com.lti.inventory.service.factoryservices;

import com.lti.inventory.model.Factory;
import com.lti.inventory.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FactoyServiceImpl implements FactoryService{

    @Autowired
    private FactoryRepository repo;

    @Override
    public List<Factory> getAllFactories() {
        return repo.findAll();
    }

    @Override
    public List<Factory> addFactory(Factory f) {
        repo.save(f);
        return this.getAllFactories();
    }

    @Override
    public List<Factory> removeFactory(Factory f) {

        repo.delete(f);
        return this.getAllFactories();
    }

    @Override
    public List<Factory> updateFactory(Integer id, Factory f) {
        List<Factory> factories=repo.findAll();
        for(Factory factory:factories){
            if(factory.getFactoryId()==id){
                factory.setFactoryName(f.getFactoryName());
                factory.setFactoryLocation(f.getFactoryLocation());

                break;
            }
        }
       repo.saveAll(factories);
        return this.getAllFactories();
    }
}
