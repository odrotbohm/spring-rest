package com.springsource.samples.customer;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Dedicated controller for machine access.
 * 
 * @author Oliver Gierke
 */
@Controller
@RequestMapping("/rest/customers")
class CustomerRestController {

    private final CustomerRepository repository;


    @Autowired
    public CustomerRestController(CustomerRepository repository) {

        Assert.notNull(repository);
        this.repository = repository;
    }


    @RequestMapping(method = GET)
    @ResponseBody
    public Customers showCustomers(Model model) {

        return new Customers(repository.findCustomers());
    }


    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public void createCustomer(@RequestBody Customer customer,
            HttpServletResponse response) {

        repository.save(customer);
        response.setHeader("Location", String.format("/rest/customers/%s",
                customer.getNumber()));
    }


    @RequestMapping(value = "/{id}", method = GET)
    @ResponseBody
    public Customer showCustomer(@PathVariable CustomerNumber id) {

        return repository.findBy(id);
    }


    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseStatus(OK)
    public void updateCustomer(@RequestBody Customer customer) {

        repository.save(customer);
    }


    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseStatus(OK)
    public void deleteCustomer(@PathVariable CustomerNumber id) {

        repository.delete(id);
    }
}
