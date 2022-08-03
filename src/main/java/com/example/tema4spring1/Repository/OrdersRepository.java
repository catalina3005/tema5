package com.example.tema4spring1.Repository;
import com.example.tema4spring1.model.Orders;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    Optional<Orders> findById(Integer Id);
    List<Orders> findAll();

}
