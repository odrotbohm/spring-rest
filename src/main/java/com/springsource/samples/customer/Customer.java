package com.springsource.samples.customer;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;


/**
 * Domain class for customers.
 * 
 * @author Oliver Gierke - gierke@synyx.de
 */
@Data
@XmlRootElement
public class Customer {

    private CustomerNumber number;

    private String firstname;
    private String lastname;


    protected Customer() {

    }


    public Customer(CustomerNumber number, String firstname, String lastname) {

        this.number = number;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public String getName() {

        return String.format("%s %s", firstname, lastname);
    }


    public boolean isNew() {

        return number == null;
    }
}
