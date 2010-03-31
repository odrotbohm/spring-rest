package com.springsource.samples.customer;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

import org.springframework.util.Assert;


/**
 * Simple wrapper DTO for {@link Customer} collections.
 * 
 * @author Oliver Gierke
 */
@Data
@XmlRootElement
class Customers {

    private List<Customer> customer = new ArrayList<Customer>();


    protected Customers() {

    }


    public Customers(List<Customer> customers) {

        Assert.notNull(customers);
        this.customer = customers;
    }
}
