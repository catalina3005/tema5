package com.example.tema4spring1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.tema4spring1.service.ProductsService;
import com.example.tema4spring1.model.Products;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {
    @Autowired
    ProductsService productsService;

    //Insert
    @PostMapping("/products")
    public Products save(@RequestBody Products product){

        return productsService.saveProducts(product);
    }

    //Get all products
    @GetMapping("/products/all")
    public List<Products> findAll(){
        return productsService.getAllProducts();
    }

    //Get products by id
    @GetMapping("/products/{id}")
    public Optional<Products> getById(@PathVariable("id") Integer id){

        return productsService.getById(id);
    }

    // Update
    @PutMapping("/products/{id}")
    public Products update(@RequestBody Products product,
                           @PathVariable("id") Integer id)
    {

        return productsService.updateProducts(product, id);
    }

    // Delete
    @DeleteMapping("/products/{id}")
    public String deleteProducts(@PathVariable("id") Integer id)
    {

        productsService.deleteProducts(id);
        return "Deleted Successfully";
    }


}