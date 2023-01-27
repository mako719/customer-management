package com.raisetech.customermanagement.service;

import com.raisetech.customermanagement.entity.Customer;
import com.raisetech.customermanagement.form.CreateForm;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void createCustomer(CreateForm form);
}
