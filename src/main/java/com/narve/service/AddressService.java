package com.narve.service;

import com.narve.domain.AddressDomain;
import com.narve.domain.AddressRequest;
import com.narve.model.Address;
import com.narve.model.Employee;
import com.narve.repository.AddressRepository;
import com.narve.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<?> createAddress(AddressRequest addressRequest) {
        List<AddressDomain> addresses = addressRequest.getAddresses();
        Integer employeeId = addressRequest.getEmployeeId();
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if(employee == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee Not found");
        }
        for (AddressDomain addressdomain : addresses) {
            Address address=new Address();
            BeanUtils.copyProperties(addressdomain,address,"addressId");
            address.setEmployee(employee);
            addressRepository.save(address);
        }
        return ResponseEntity.status(HttpStatus.OK).body("address are saved");


    }

    public ResponseEntity<String> updateAddress(Integer employeeid,AddressDomain addressDomain) {

        Employee employee = employeeRepository.findByEmployeeId(employeeid);
        if(employee == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee Not found");
        }
        Address address = addressRepository.findByAddressId(addressDomain.getAddressId());
        if(address == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department Not found");
        }
        BeanUtils.copyProperties(addressDomain,address);
        address.setEmployee(employee);
        addressRepository.save(address);
        return  ResponseEntity.status(HttpStatus.OK).body("address updated");
    }



    public ResponseEntity<String> deleteAddress(Integer addressid) {
        boolean exists = addressRepository.existsById(addressid);
        if (!exists) {
          return   ResponseEntity.status(HttpStatus.NOT_FOUND).body("address not found");
        }
        addressRepository.deleteById(addressid);
        return   ResponseEntity.status(HttpStatus.OK).body("address deleted");
    }
}
