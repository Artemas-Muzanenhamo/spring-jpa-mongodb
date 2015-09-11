package org.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a survey.
 */
@Document
public class Survey
{
  private String title;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Survey()
  {
    super();
  }

  /**
   * Creates a survey with a given title.
   *
   * @param title The survey title.
   */
  public Survey(final String title)
  {
    this();

    this.title = title;
  }

  /**
   * Gets the survey title.
   *
   * @return The survey title.
   */
  public String getTitle()
  {
    return title;
  }
}
