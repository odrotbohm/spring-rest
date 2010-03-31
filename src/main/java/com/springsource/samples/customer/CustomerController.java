package com.springsource.samples.customer;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Oliver Gierke
 */
@Controller
@RequestMapping("/customers")
class CustomerController {

    private final CustomerRepository repository;


    @Autowired
    public CustomerController(CustomerRepository repository) {

        Assert.notNull(repository);
        this.repository = repository;
    }


    @RequestMapping(method = GET)
    public String showCustomers(Model model) {

        model.addAttribute("customers", repository.findCustomers());

        return "customers";
    }


    @RequestMapping(method = POST)
    public String createCustomer(@ModelAttribute Customer customer) {

        repository.save(customer);

        return "redirect:/customers";
    }


    @RequestMapping(value = "/{id}", method = GET)
    public String showCustomer(@PathVariable CustomerNumber id, Model model) {

        model.addAttribute("customer", repository.findBy(id));
        return "customer";
    }


    @RequestMapping(value = "/{id}", method = PUT)
    public String updateCustomer(@ModelAttribute Customer customer) {

        repository.save(customer);

        return "redirect:/customers";
    }


    @RequestMapping(value = "/{id}", method = DELETE)
    public String deleteCustomer(@PathVariable CustomerNumber id) {

        repository.delete(id);

        return "redirect:/customers";
    }
}
