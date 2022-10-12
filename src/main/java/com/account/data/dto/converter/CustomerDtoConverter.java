package com.account.data.dto.converter;

import com.account.data.dto.AccountCustomerDto;
import com.account.data.dto.CustomerDto;
import com.account.data.entity.Customer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CustomerDtoConverter {

    final CustomerAccountDtoConverter customerAccountDtoConverter;


    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> customer){
        return customer.map(f -> new AccountCustomerDto(f.getId(), f.getName(), f.getSurname())).
                orElse(null);
    }

    public CustomerDto convertToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAccounts()
                        .stream()
                        .map(customerAccountDtoConverter::convert)
                        .collect(Collectors.toSet()));

    }
    }

