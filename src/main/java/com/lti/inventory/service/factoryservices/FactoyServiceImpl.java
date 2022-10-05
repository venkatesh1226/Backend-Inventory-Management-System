package com.lti.inventory.service.factoryservices;

import com.lti.inventory.model.Factory;
import com.lti.inventory.model.Product;
import com.lti.inventory.repository.FactoryRepository;
import com.lti.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Service
@RestController
@CrossOrigin(origins = "*")
public class FactoyServiceImpl implements FactoryService{

    @Autowired
    private FactoryRepository repo;

    @Autowired
    private ProductRepository productRepo;

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
    public List<Factory> removeFactory(Integer id) {

        Factory f=null;
        for(Factory i:repo.findAll()){
            if(i.getFactoryId()==id) {
                f = i;
                break;
            }
        }
        if(f!=null) {
            repo.delete(f);
            List<Product> prods = new ArrayList<>();
            for (Product p : productRepo.findAll()) {
                if (f.getFactoryId() == p.getFactoryId()) {
                    prods.add(p);
                }
            }
            productRepo.deleteAll(prods);
        }
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
