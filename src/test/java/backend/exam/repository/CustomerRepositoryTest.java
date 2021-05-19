package backend.exam.repository;

import backend.exam.org.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;





public class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSave() {

        Customer c = new Customer();
        c = customerRepository.save(c);
        assertNotNull(c.getId());
        assertTrue(customerRepository.findById(c.getId()).isPresent());

    }

}