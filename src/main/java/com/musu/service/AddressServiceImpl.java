package com.musu.service;

import com.musu.model.AddressEntity;
import com.musu.model.User;
import com.musu.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ortayol on 15.01.2017.
 */
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public User getAddressbyId(int id){

        return addressRepository.getAddressbyId(id);


    }
}
