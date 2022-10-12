package com.account.service.impl;
import com.account.data.dto.CustomerDto;
import com.account.data.dto.converter.CustomerDtoConverter;
import com.account.data.entity.Customer;
import com.account.data.repository.CustomerRepository;
import com.account.exception.CustomerNotFoundException;
import com.account.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;
    final CustomerDtoConverter converter;


    @Override
    public CustomerDto getCustomerById(Long customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));

    }
    @Override
    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(converter::convertToCustomerDto).collect(Collectors.toList());
    }
}
