package com.springsource.samples.customer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Size(max = 10, min = 1)
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
