package com.example.tema4spring1.controllers;
import com.example.tema4spring1.model.Orders;
import com.example.tema4spring1.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    //Insert
    @PostMapping("/orders")
    public Orders save(@RequestBody Orders orders){
        return ordersService.saveOrders(orders);
    }

    //Get all orders
    @GetMapping("/orders/all")
    public List<Orders> getAll() {
        return ordersService.getAllOrders();
    }

    //Get orders by id
    @GetMapping("/orders/{Id}")
    public Optional<Orders> getById(@PathVariable("Id") Integer id){
        return ordersService.getById(id);
    }

    //Update
    @PutMapping("/orders/{ID}")
    public Orders update(@RequestBody Orders orders, @PathVariable("ID") Integer id) {
        return ordersService.updateOrders(orders, id);
    }

    //Delete
    @DeleteMapping("/orders/{ID}")
    public String delete(@PathVariable("ID")Integer id){
        ordersService.deleteOrders(id);
        return "Deleted Successfully";
    }
}