package com.account.data.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CustomerDto {

    Long id;
    String name;
    String surname;
    Set<CustomerAccountDto>accounts;
}
