package com.narve.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDomain {

    private Integer addressId;
    private String houseNo;
    private String street;
    private String country;
    private String stateOfCountry;
    private String zipcode;

    public AddressDomain(int addressId, String houseNo, String street, String zipcode, String stateOfCountry, String country) {
        this.addressId=addressId;
        this.houseNo=houseNo;
        this.street=street;
        this.zipcode=zipcode;
        this.stateOfCountry=stateOfCountry;
        this.country=country;
    }
}
