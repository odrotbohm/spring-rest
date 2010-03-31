package com.springsource.samples.customer;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;

import com.springsource.samples.customer.internal.InvalidContentException;


/**
 * Unit test for {@link CustomerRestController}.
 * 
 * @author Oliver Gierke
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerRestControllerUnitTest {

    private CustomerRestController controller;

    @Mock
    private CustomerRepository repository;


    @Before
    public void setUp() {

        controller = new CustomerRestController(repository);
    }


    @Test(expected = InvalidContentException.class)
    public void throwsExceptionOnValidationError() throws Exception {

        BindingResult result = mock(BindingResult.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(result.hasErrors()).thenReturn(true);

        controller.createCustomer(new Customer(), result, response);
    }
}
