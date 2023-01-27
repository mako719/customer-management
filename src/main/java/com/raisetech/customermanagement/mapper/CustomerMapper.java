package com.raisetech.customermanagement.mapper;

import com.raisetech.customermanagement.entity.Customer;
import com.raisetech.customermanagement.form.CreateForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CustomerMapper {
    @Select("SELECT * FROM customers")
    List<Customer> findAll();

    @Insert("INSERT INTO customers (id, name, age, site, staff) VALUES (#{id}, #{name}, #{age}, #{site}, #{staff})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createCustomer(CreateForm form);
}
