package com.example.BookMyShow_Application.Service;

import com.example.BookMyShow_Application.Converters.UserConverter;
import com.example.BookMyShow_Application.EntityLayer.UserEntity;
import com.example.BookMyShow_Application.EntryDTOs.UserEntryDto;
import com.example.BookMyShow_Application.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String createUser(UserEntryDto userEntryDto) throws Exception, NullPointerException
    {
        UserEntity userEntity= UserConverter.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        return "User Added Successfully ";
    }
}
