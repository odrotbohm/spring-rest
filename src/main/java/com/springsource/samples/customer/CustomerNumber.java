package com.springsource.samples.customer;

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
}
