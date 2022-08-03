package com.example.tema4spring1.service;
import com.example.tema4spring1.Repository.OrdersRepository;
import com.example.tema4spring1.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    //Get all orders
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    //Get orders by id
    public Optional<Orders> getById(Integer id){
        return ordersRepository.findById(id);
    }

    //Insert order
    public Orders saveOrders(Orders orders){
        return ordersRepository.save(orders);
    }

    //Update order
    public Orders updateOrders(Orders orders, Integer id){
        Orders o = ordersRepository.findById(id).get();

        if(Objects.nonNull(orders.getStatus()) && !"".equalsIgnoreCase(orders.getStatus())){
            o.setStatus(orders.getStatus());
        }
        if(Objects.nonNull(orders.getComments()) && !"".equalsIgnoreCase(orders.getComments())){
            o.setComments(orders.getComments());
        }
        return ordersRepository.save(o);
    }

    //Delete order
    public void deleteOrders(Integer id){
        ordersRepository.deleteById(id);
    }
}