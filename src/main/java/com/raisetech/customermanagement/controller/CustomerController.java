package com.raisetech.customermanagement.controller;

import com.raisetech.customermanagement.entity.Customer;
import com.raisetech.customermanagement.form.CreateForm;
import com.raisetech.customermanagement.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomers(@Validated @PathVariable("id") int id) throws Exception {
        return customerService.findById(id);
    }

    @PostMapping("/customers")
    public ResponseEntity<Map<String, Serializable>> createTeam(@Validated @RequestBody CreateForm form, UriComponentsBuilder uriBuilder) {
        System.out.println(form.getName());
        customerService.createCustomer(form);
        int id = form.getId();
        URI url = uriBuilder.path("/name/" + id).
                build().
                toUri();
        return ResponseEntity.created(url).body(Map.of("id", id, "message", "顧客情報が登録されました。"));
    }

}


