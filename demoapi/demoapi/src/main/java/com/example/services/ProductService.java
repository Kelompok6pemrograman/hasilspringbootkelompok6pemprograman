package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.entities.Product;
import com.example.models.repos.ProductRepo;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }
    public Product findOne(Long id){
        Optional<Product> temp = productRepo.findById(id);
        if(!temp.isPresent()){
            return null;
        }
        return temp.get();
    }
    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }
    public void removeOne(Long id){
        productRepo.deleteById(id);
    }
    public List<Product> findByName(String name){
    return productRepo.findByNameContains(name);
    }

    
}
