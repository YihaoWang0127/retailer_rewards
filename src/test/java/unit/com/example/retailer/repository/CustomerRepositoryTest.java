package unit.com.example.retailer.repository;

import com.example.retailer.Retailer_Rewards_ProgramApplication;
import com.example.retailer.entity.Customer;
import com.example.retailer.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Retailer_Rewards_ProgramApplication.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(
        locations = "classpath:application-test.properties")
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testApplication(){

        // given
        Customer alex = new Customer("Alex");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Customer found = customerRepository.findByCustomerId(1L);

        // then
        assertThat(found.getCustomerName())
                .isEqualTo(alex.getCustomerName());

    }

}
