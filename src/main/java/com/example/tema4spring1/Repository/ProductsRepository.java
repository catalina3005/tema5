package com.example.tema4spring1.Repository;
import com.example.tema4spring1.model.Products;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ProductsRepository extends CrudRepository<Products, Integer> {
    void delete(Products product);
    Optional<Products> findById(Integer id);
}