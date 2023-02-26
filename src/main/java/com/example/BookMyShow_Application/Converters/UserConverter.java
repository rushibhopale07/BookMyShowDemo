package com.example.BookMyShow_Application.Converters;

import com.example.BookMyShow_Application.EntityLayer.UserEntity;
import com.example.BookMyShow_Application.EntryDTOs.UserEntryDto;

// it will converts an Dto's to Entity
public class UserConverter {
    // we make a method as a static to avoid using object

    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        UserEntity userEntity = UserEntity.builder()
                .age(userEntryDto.getAge())
                .mobNo(userEntryDto.getMobNo())
                .name(userEntryDto.getName())
                .email(userEntryDto.getEmail())
                .address(userEntryDto.getAddress()).build();
        return userEntity;
    }
}
