package org.example.domain;

import org.springframework.data.mongodb.crossstore.RelatedDocument;

import javax.persistence.*;

/**
 * Represents a customer.
 */
@Entity
@Table(name = "customer")
public class Customer
{
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @RelatedDocument
  private Survey survey;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Customer()
  {
    super();
  }

  /**
   * Creates a customer with a given name.
   *
   * @param name The customer name.
   */
  public Customer(final String name)
  {
    this();

    this.name = name;
  }

  /**
   * Gets the customer name.
   *
   * @return The customer name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets an optional survey assigned to the customer.
   *
   * @return A {@link Survey}.
   */
  public Survey getSurvey()
  {
    return survey;
  }

  /**
   * Sets an optional survey assigned to the customer.
   *
   * @param survey A {@link Survey}.
   */
  public void setSurvey(final Survey survey)
  {
    this.survey = survey;
  }
}
