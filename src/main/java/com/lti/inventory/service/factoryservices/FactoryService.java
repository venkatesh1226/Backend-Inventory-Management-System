package com.lti.inventory.service.factoryservices;

import com.lti.inventory.model.Factory;
import com.lti.inventory.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins ="*")
public interface FactoryService {

    //get All Factories
    public List<Factory> getAllFactories();

    //Add Factory
    public List<Factory> addFactory(Factory f);

    //delete Factory
    public List<Factory> removeFactory(Factory id);

    //update Factory
    public List<Factory> updateFactory(Integer id, Factory f);

}
