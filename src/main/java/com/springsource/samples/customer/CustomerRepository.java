package com.springsource.samples.customer;

import java.util.List;


/**
 * @author Oliver Gierke
 */
public interface CustomerRepository {

    /**
     * Finds a single {@link Customer}.
     * 
     * @param number
     * @return
     */
    public Customer findBy(CustomerNumber number);


    /**
     * Finds all {@link Customer}s.
     * 
     * @return
     */
    public List<Customer> findCustomers();


    /**
     * Saves the given customer.
     * 
     * @param customer
     */
    public void save(Customer customer);


    /**
     * Deletes the {@link Customer} with the given number.
     * 
     * @param number
     */
    public void delete(CustomerNumber number);
}
