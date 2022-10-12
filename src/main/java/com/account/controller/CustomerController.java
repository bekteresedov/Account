package com.account.controller;

import com.account.data.dto.CustomerDto;
import com.account.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/customer/")
public class CustomerController {

    final CustomerService customerService;

    @GetMapping("/get/{customerId}")

    public ResponseEntity<CustomerDto>getCustomerById(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

}
