package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return  repository.saveAll(products);
    }
    public List<Product> getproducts(){
        return repository.findAll();
    }

    public Product getproductById(int id){
        return repository.findById(id).orElse(null);}

    public Product getproductByName(String name){
        return repository.findByName(name);
    }
    public String deleteproduct(int id){
        repository.deleteById(id);
        return "product removed";
    }
    public Product updateProduct(Product product){
        Product existingProdct=repository.findById(product.getId()).orElse(null);
        existingProdct.setName(product.getName());
        existingProdct.setQuantity(product.getQuantity());
        existingProdct.setPrice(product.getPrice());
        return repository.save(existingProdct);


    }

}
