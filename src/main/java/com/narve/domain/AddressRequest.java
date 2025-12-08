package com.narve.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class AddressRequest {

    private  Integer employeeId;
    private List<AddressDomain> addresses;
}
