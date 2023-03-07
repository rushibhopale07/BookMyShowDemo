package com.example.BookMyShow_Application.Converters;

import com.example.BookMyShow_Application.EntityLayer.ShowEntity;
import com.example.BookMyShow_Application.EntryDTOs.ShowsEntryDto;

public class ShowsConverter {

    public static ShowEntity convertDtoToEntity(ShowsEntryDto showsEntryDto)
    {
        ShowEntity showEntity = ShowEntity.builder()
                .showTime(showsEntryDto.getShowTime())
                .showDate(showsEntryDto.getShowDate())
                .showType(showsEntryDto.getShowType())
                .build();
        return showEntity;
    }
}
