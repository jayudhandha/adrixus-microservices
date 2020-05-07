package com.adrixus.controllers;

import com.adrixus.models.Customer;
import com.adrixus.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController implements CustomerApi{

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createCustomer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customerModel) {
        customerService.createCustomer(customerModel);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCustomer/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        return new ResponseEntity<>(customerService.getCustomer(Long.valueOf(customerId)), HttpStatus.OK);
    }
}
