package com.springsource.samples.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


/**
 * @author Oliver Gierke
 */
@Repository
class CustomerInMemoryRepository implements CustomerRepository {

    private final List<Customer> customers = new ArrayList<Customer>();


    public CustomerInMemoryRepository() {

        customers.add(new Customer(CustomerNumber.next(), "Dave", "Matthews"));
        customers
                .add(new Customer(CustomerNumber.next(), "Carter", "Beauford"));
        customers.add(new Customer(CustomerNumber.next(), "Tim", "Rexnolds"));
        customers.add(new Customer(CustomerNumber.next(), "Jeff", "Coffin"));
    }


    @Override
    public Customer findBy(CustomerNumber number) {

        if (number == null) {
            return null;
        }

        for (Customer customer : customers) {
            if (number.equals(customer.getNumber())) {
                return customer;
            }
        }

        return null;
    }


    @Override
    public List<Customer> findCustomers() {

        return Collections.unmodifiableList(customers);
    }


    @Override
    public void save(Customer customer) {

        Assert.notNull(customer);

        if (customer.isNew()) {

            customer.setNumber(CustomerNumber.next());
            customers.add(customer);
        } else {

            Customer original = findBy(customer.getNumber());

            original.setFirstname(customer.getFirstname());
            original.setLastname(customer.getLastname());
        }
    }


    @Override
    public void delete(CustomerNumber number) {

        Customer customer = findBy(number);

        if (customer != null) {
            customers.remove(customer);
        }
    }
}
