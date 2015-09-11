package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit tests for the Spring Application Context.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringContextTest
{
  /**
   * Tests that the Spring Application Context loads correctly.
   */
  @Test
  public void testContextLoads()
  {
  }
}
