package com.example.BookMyShow_Application.Service;

import com.example.BookMyShow_Application.Converters.TheaterConverter;
import com.example.BookMyShow_Application.EntityLayer.TheaterEntity;
import com.example.BookMyShow_Application.EntityLayer.TheaterSeatEntity;
import com.example.BookMyShow_Application.EntryDTOs.TheaterEntryDto;
import com.example.BookMyShow_Application.EnumLayer.SeatType;
import com.example.BookMyShow_Application.Repository.TheaterRepository;
import com.example.BookMyShow_Application.Repository.TheaterSeatRepository;
import com.example.BookMyShow_Application.ResponseDTOs.TheaterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String createTheater(TheaterEntryDto theaterEntryDto) throws Exception, NullPointerException
    {
        if(theaterEntryDto.getName()==null||theaterEntryDto.getLocation()==null){
            throw new Exception("Name or location is not valid");
        }
        //Set its Attributes
        TheaterEntity theaterEntity= TheaterConverter.convertDtoToEntity(theaterEntryDto);
        //Set the child attributes theaterSeats

        List<TheaterSeatEntity> theaterSeatEntityList = createSeatEntity(theaterEntity,theaterEntryDto);

        theaterEntity.setListOfTheaterSeats(theaterSeatEntityList);

        // we set all the child attributes
        //now save this to database
        theaterRepository.save(theaterEntity);
        return  "Theater is Created";
    }
    private List<TheaterSeatEntity> createSeatEntity(TheaterEntity theaterEntity,TheaterEntryDto theaterEntryDto)
    {
        // we need to set premium seats and classic seats
        int noOfClassicSeats= theaterEntryDto.getClassicSeatNo();
        int noOfPremiumSeats = theaterEntryDto.getPremiumSeatNo();

        // set the seats in theaterseatentity
         List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

         for(int i=1;i<=noOfClassicSeats;i++)
         {
             TheaterSeatEntity theaterSeat = TheaterSeatEntity.builder()
                     .seatNumber(i+"C")
                     .seatType(SeatType.CLASSIC)
                     .theaterEntity(theaterEntity)
                     .build();
             theaterSeatEntityList.add(theaterSeat);
         }

        for(int i=1;i<=noOfPremiumSeats;i++)
        {
            TheaterSeatEntity theaterSeat = TheaterSeatEntity.builder()
                    .seatNumber(i+"P")
                    .seatType(SeatType.PREMIUM)
                    .theaterEntity(theaterEntity)
                    .build();
            theaterSeatEntityList.add(theaterSeat);
        }
        return theaterSeatEntityList;
    }

    public List<TheaterResponse> Theaters()
    {

        List<TheaterResponse> theaterList = new ArrayList<>();
        List<TheaterEntity> theaterEntityList = theaterRepository.findAll();
        for(TheaterEntity theaterEntity: theaterEntityList)
        {
            TheaterResponse theaterResponse = TheaterResponse.builder()
                    .id(theaterEntity.getId())
                    .name(theaterEntity.getName())
                    .sizeOfTheater(theaterEntity.getListOfTheaterSeats().size())
                    .build();
            theaterList.add(theaterResponse);
        }
        return theaterList;
    }
}
