package com.springsource.samples.customer;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springsource.samples.customer.internal.InvalidContentException;


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
    public void createCustomer(@Valid Customer customer, BindingResult result,
            HttpServletResponse response) {

        if (result.hasErrors()) {
            throw new InvalidContentException();
        }

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
    public void updateCustomer(@Valid Customer customer) {

        repository.save(customer);
    }
}
