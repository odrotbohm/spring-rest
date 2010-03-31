package com.springsource.samples.customer.internal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author Oliver Gierke
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidContentException extends RuntimeException {

    private static final long serialVersionUID = 2620685905341304380L;
}
