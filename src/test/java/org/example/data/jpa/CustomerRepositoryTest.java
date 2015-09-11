package org.example.data.jpa;

import org.example.domain.Customer;
import org.example.domain.Survey;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Integration tests for {@link CustomerRepository}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CustomerRepositoryTest
{
  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private CustomerRepository customerRepository;

  private Customer customer;

  /**
   * Sets up data required to run the tests.
   */
  @Before
  public void setup()
  {
    customer = new Customer("Customer");

    customer.setSurvey(new Survey("Survey"));

    customerRepository.save(customer);

    entityManager.flush();
    entityManager.clear();
    entityManager.close();
  }

  /**
   * Tests that customers can be loaded correctly.
   */
  @Test
  public void testFindAll()
  {
    final Iterable<Customer> customers = customerRepository.findAll();

    Assert.assertNotNull(customers);

    customers.forEach(customer -> {
      Assert.assertNotNull(customer);
      Assert.assertNotNull(customer.getName());
      Assert.assertNotNull(customer.getSurvey());
      Assert.assertNotNull(customer.getSurvey().getTitle());
    });
  }
}
