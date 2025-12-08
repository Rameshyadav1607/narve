package com.narve.resource;

import com.narve.domain.AddressDomain;
import com.narve.domain.AddressRequest;
import com.narve.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressResource {
    @Autowired
    private AddressService addressService;
    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody AddressRequest addressRequest){
        return  addressService.createAddress(addressRequest);
    }
    @PutMapping("/{employeeid}")
    public ResponseEntity<String> updateAddress(@PathVariable Integer employeeid, @RequestBody AddressDomain addressDomain){
        return  addressService.updateAddress(employeeid,addressDomain);
    }

    @DeleteMapping("/{addressid}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer addressid){
      return     addressService.deleteAddress(addressid);
    }
}
