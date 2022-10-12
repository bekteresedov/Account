package com.account.data.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateAccountRequest {
    @NotBlank(message = "CustomerId must not be empty")
    Long customerId;
    @Min(value = 0, message = "Initial Credit value must not be negative value")
    BigDecimal initialCredit;
}
