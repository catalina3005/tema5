package com.example.tema4spring1.service;
import com.example.tema4spring1.Repository.ProductsRepository;
import com.example.tema4spring1.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    //Get all products

    public List<Products> getAllProducts() {
        return (List<Products>)productsRepository.findAll();
    }

    //Get products by id
    public Optional<Products> getById(Integer id) {
        return productsRepository.findById(id);
    }

    //Insert products by id
    public Products saveProducts(Products product){
        return productsRepository.save(product);
    }

    //Update products
    public Products updateProducts(Products product, Integer id) {
        Products p = productsRepository.findById(id).get();

        if(Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
            p.setName((product.getName()));
        }
        if(Objects.nonNull(product.getPrice())) {
            p.setPrice((product.getPrice()));
        }
        return productsRepository.save(p);

    }

    //Delete products
    public void deleteProducts(Integer id){
        productsRepository.deleteById(id);
    }

}