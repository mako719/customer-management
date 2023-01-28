package com.raisetech.customermanagement.mapper;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.raisetech.customermanagement.entity.Customer;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerMapperTest {

    @Autowired
    CustomerMapper customerMapper;

    @Test
    @DataSet(value = "datasets/customers.yml")
    @Transactional
    void 全ての顧客情報が取得できること() {
        List<Customer> customers = customerMapper.findAll();
        assertThat(customers)
                .hasSize(2)
                .contains(
                        new Customer(1, "tanaka", 35, "shoulder", "yamada"),
                        new Customer(2, "suzuki", 28, "neck", "yamamoto")
                );
    }
}
