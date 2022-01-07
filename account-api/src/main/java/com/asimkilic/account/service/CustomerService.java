package com.asimkilic.account.service;

import com.asimkilic.account.dto.CustomerDto;
import com.asimkilic.account.dto.converter.CustomerDtoConverter;
import com.asimkilic.account.exception.CustomerNotFoundException;
import com.asimkilic.account.model.Customer;
import com.asimkilic.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id : " + id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto(findCustomerById(customerId));

    }

    public List<CustomerDto> getAllCustomer() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerDtoConverter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
