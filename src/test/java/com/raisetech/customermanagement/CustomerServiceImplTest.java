package com.raisetech.customermanagement;

import com.raisetech.customermanagement.entity.Customer;
import com.raisetech.customermanagement.form.CreateForm;
import com.raisetech.customermanagement.mapper.CustomerMapper;
import com.raisetech.customermanagement.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl customerServiceImpl;

    @Mock
    CustomerMapper customerMapper;
    List customerList = List.of(new Customer(1, "tanaka", 35, "shoulder", "yamada"), new Customer(2, "suzuki", 28, "neck", "yamamoto"));

    @Test
    public void 顧客情報を全件取得できること() {
        doReturn(customerList).when(customerMapper).findAll();

        List<Customer> actual = customerServiceImpl.findAll();
        assertThat(actual).isEqualTo(customerList);
    }

    @Test
    public void 顧客情報を1件登録できること() {
        doNothing().when(customerMapper).createCustomer(any(CreateForm.class));
        customerServiceImpl.createCustomer(any(CreateForm.class));
        verify(customerMapper).createCustomer(any(CreateForm.class));
    }
}
