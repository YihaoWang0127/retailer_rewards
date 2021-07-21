package intg.com.example.retailer.rest;

import com.example.retailer.Retailer_Rewards_ProgramApplication;
import com.example.retailer.entity.Customer;
import com.example.retailer.entity.Rewards;
import com.example.retailer.entity.Transaction;
import com.example.retailer.repository.CustomerRepository;
import com.example.retailer.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = Retailer_Rewards_ProgramApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class RewardsRestControllerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testApplication() throws Exception {

        Customer customer = new Customer(1L,"Mike");

        Timestamp timestamp = Timestamp.valueOf("2021-05-01 10:30:30");

        Transaction transaction = new Transaction(4L,1L, timestamp,90);

        customerRepository.save(customer);

        transactionRepository.save(transaction);

        mvc.perform(get("http://localhost:8080/customers/1/rewards")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"customerId\":1,\"lastMonthRewardPoints\":0,\"lastSecondMonthRewardPoints\":0,\"lastThirdMonthRewardPoints\":40,\"totalRewards\":40}"));
    }


}
