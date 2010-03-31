package com.springsource.samples.customer;

import java.util.UUID;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;

import com.springsource.samples.customer.internal.CustomerNumberTypeAdapter;


/**
 * Value object for {@link Customer} numbers.
 * 
 * @author Oliver Gierke
 */
@Data
@XmlType
@XmlJavaTypeAdapter(CustomerNumberTypeAdapter.class)
public class CustomerNumber {

    private final String number;


    @Override
    public String toString() {
        
        return number;
    }


    /**
     * Creates a new random {@link CustomerNumber}.
     * 
     * @return
     */
    public static CustomerNumber next() {

        return new CustomerNumber(UUID.randomUUID().toString());
    }
}
