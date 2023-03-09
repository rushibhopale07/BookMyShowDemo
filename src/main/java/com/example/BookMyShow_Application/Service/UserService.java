package com.example.BookMyShow_Application.Service;

import com.example.BookMyShow_Application.Converters.UserConverter;
import com.example.BookMyShow_Application.EntityLayer.TicketEntity;
import com.example.BookMyShow_Application.EntityLayer.UserEntity;
import com.example.BookMyShow_Application.EntryDTOs.UserEntryDto;
import com.example.BookMyShow_Application.Repository.UserRepository;

import com.example.BookMyShow_Application.ResponseDTOs.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<TicketResponse> getListOfTicket(int userId) throws Exception
    {
        if(userRepository.existsById(userId)) {
            List<TicketResponse> ticketResponseList =new ArrayList<>();
            List<TicketEntity> ticketList = userRepository.findById(userId).get().getListOfTickets();
            for(TicketEntity ticket : ticketList)
            {
                TicketResponse ticketResponse = TicketResponse.builder()
                        .movieName(ticket.getMovieName())
                        .theaterName(ticket.getTheaterName())
                        .showDate(ticket.getShowDate())
                        .showTime(ticket.getShowTime())
                        .totalAmount(ticket.getTotalAmount())
                        .bookedSeats(ticket.getBookedSeats())
                        .ticketId(ticket.getTicketId()).build();
                ticketResponseList.add(ticketResponse);
            }
            return ticketResponseList;
        }
        else
            throw new Exception("User Not Found");
    }
}
