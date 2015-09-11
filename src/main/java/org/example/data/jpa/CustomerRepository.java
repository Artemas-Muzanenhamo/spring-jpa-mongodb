package org.example.data.jpa;

import org.example.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Contract for data access operations on {@link Customer}.
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>
{
}
