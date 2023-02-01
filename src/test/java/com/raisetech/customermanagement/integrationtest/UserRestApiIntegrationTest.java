package com.raisetech.customermanagement.integrationtest;

import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestApiIntegrationTest {

    @Autowired
    MockMvc mockmvc;

    @Test
    @DataSet(value = "customers.yml")
    @Transactional
    void 顧客情報が全件取得できること() throws Exception{

    }
}
