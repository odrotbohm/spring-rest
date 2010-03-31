package com.springsource.samples.customer;

import java.util.UUID;

import lombok.Data;


/**
 * Value object for {@link Customer} numbers.
 * 
 * @author Oliver Gierke
 */
@Data
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
