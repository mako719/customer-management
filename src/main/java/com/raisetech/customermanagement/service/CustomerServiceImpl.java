package com.raisetech.customermanagement.service;

import com.raisetech.customermanagement.ResourceNotFoundException;
import com.raisetech.customermanagement.entity.Customer;
import com.raisetech.customermanagement.form.CreateForm;
import com.raisetech.customermanagement.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public List<Customer> findAll(){
        return customerMapper.findAll();
    }

    @Override
    public Customer findById(int id){
        return this.customerMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
    }

    @Override
    public void createCustomer(CreateForm form){
        customerMapper.createCustomer(form);
    }
}
