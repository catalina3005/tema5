package com.example.tema4spring1.Repository;
import com.example.tema4spring1.model.Customers;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface CustomersRepository extends CrudRepository<Customers, Integer> {
    Optional<Customers> findById(Integer id);
    List<Customers> findAll();
    void delete(Customers customer);
}