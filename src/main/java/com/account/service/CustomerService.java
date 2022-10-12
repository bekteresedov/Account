package com.account.service;

import com.account.data.dto.CustomerDto;
import com.account.data.entity.Customer;

import java.util.List;

public interface CustomerService {

     CustomerDto getCustomerById(Long customerId);
     List<CustomerDto> getAllCustomer();

    Customer findCustomerById(Long customerId);
}
