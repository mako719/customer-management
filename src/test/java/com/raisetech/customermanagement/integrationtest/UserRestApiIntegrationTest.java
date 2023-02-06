package com.raisetech.customermanagement.integrationtest;

import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestApiIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DataSet(value = "customers.yml")
    @Transactional
    void 顧客情報が全件取得できること() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.get("/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        JSONAssert.assertEquals("[" +
                "   {" +
                "       \"id\": 1," +
                "       \"name\": \"tanaka\"," +
                "       \"age\": 35," +
                "       \"site\": \"shoulder\"," +
                "       \"staff\": \"yamada\"" +
                "   }," +
                "   {" +
                "       \"id\": 2," +
                "       \"name\": \"suzuki\"," +
                "       \"age\": 28," +
                "       \"site\": \"neck\"," +
                "       \"staff\": \"yamamoto\"" +
                "   }" +
                "]", response, JSONCompareMode.STRICT);
    }

    @Test
    @Transactional
    void 顧客情報の登録成功し201レスポンスとLocationヘッダに登録したidとレスポンスとしてメッセージが返ること() throws Exception {
         String response = mockMvc.perform(MockMvcRequestBuilders.post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[" + "{" +
                                "       \"name\": \"takahashi\"," +
                                "       \"age\": 55," +
                                "       \"site\": \"shoulder\"," +
                                "       \"staff\": \"yamada\"" +
                                "   }" +
                                "]")
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost:8080/customers/names/3"))
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        JSONAssert.assertEquals("[" + "{" +
                        "       \"id\": \"3\"," +
                        "       \"message\": \"顧客情報が登録されました。\"" +
                        "   }" +
                        "]",
                response, JSONCompareMode.STRICT);
    }
}
