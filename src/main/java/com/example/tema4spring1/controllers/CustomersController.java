package com.example.tema4spring1.controllers;
import com.example.tema4spring1.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.tema4spring1.service.CustomersService;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomersController {

    @Autowired
    CustomersService customersService;

    //Insert customers
    @PostMapping("/customers")
    public Customers saveCustomers(@RequestBody Customers customer){
        return customersService.saveCustomers(customer);
    }

    //Get all customers
    @GetMapping("/customers/all")
    public List<Customers> findAll(){
        return customersService.getAllCustomers();
    }

    //Get customers by id
    @GetMapping("/customers/{id}")
    public Optional<Customers> getById(@PathVariable("id") Integer id){
        return customersService.getById(id);
    }

    // Update customers
    @PutMapping("/customers/{id}")
    public Customers updateCustomers(@RequestBody Customers customer,
                                     @PathVariable("id") Integer id)
    {

        return customersService.updateCustomers(customer, id);
    }

    // Delete customers
    @DeleteMapping("/customers/{id}")
    public String deleteCustomersById(@PathVariable("id") Integer id)
    {
        customersService.deleteCustomersById(id);
        return "Deleted Successfully";
    }
}
