package com.example.BookMyShow_Application.Service;

import com.example.BookMyShow_Application.Converters.TicketConverter;
import com.example.BookMyShow_Application.EntityLayer.*;
import com.example.BookMyShow_Application.EntryDTOs.ShowsEntryDto;
import com.example.BookMyShow_Application.EntryDTOs.TicketEntryDto;
import com.example.BookMyShow_Application.Repository.ShowsRepository;
import com.example.BookMyShow_Application.Repository.TicketRepository;
import com.example.BookMyShow_Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowsRepository showsRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public String addTicket(TicketEntryDto ticketEntryDto) throws Exception
    {
        TicketEntity ticketEntity = TicketConverter.convertDtoToEntity(ticketEntryDto);
        //check the seat is available or not
        boolean isValidSeat = checkSeatIsBookedOrNot(ticketEntryDto);
        if(isValidSeat == false)
            throw new Exception(" Requsted Seat Not Available");
        //if seat available we need to calculate total price
        ShowEntity showEntity = showsRepository.findById(ticketEntryDto.getShowId()).get();

        List<String> requstedSeats = ticketEntryDto.getRequstedSeats();

        List<ShowSeatEntity> showSeatEntityList = showEntity.getListOfShowSeats();

        int totalAmount=0;

        for(ShowSeatEntity showSeatEntity : showSeatEntityList)
        {
            String seatNo =showSeatEntity.getSeatNumber();
            if(requstedSeats.contains(seatNo))
            {
               totalAmount += showSeatEntity.getPrice();
               showSeatEntity.setBooked(true);
               showSeatEntity.setBookedAt(new Date());
            }
        }
        ticketEntity.setTotalAmount(totalAmount);

        String movieName= showEntity.getMovieEntity().getMovieName();
        String theaterName= showEntity.getTheaterEntity().getName();

        ticketEntity.setMovieName(movieName);
        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheaterName(theaterName);

        //set the show seats
        String allotedSeats = getAllotedSeatsFromShowSeats(requstedSeats);
        ticketEntity.setBookedSeats(allotedSeats);

        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();

        ticketEntity.setUser(userEntity);
        ticketEntity.setShowEntity(showEntity);

        ticketEntity = ticketRepository.save(ticketEntity);

        List<TicketEntity> ticketEntityList = showEntity.getListOfTickets();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfTickets(ticketEntityList);

        showsRepository.save(showEntity);

        List<TicketEntity> ticketEntityList1 = userEntity.getListOfTickets();
        ticketEntityList1.add(ticketEntity);
        userEntity.setListOfTickets(ticketEntityList1);

        userRepository.save(userEntity);

        String body = "Hi this is to confirm your booking for seat No "+allotedSeats +"for the movie : " + ticketEntity.getMovieName();


        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("rushibhopale2159@gmail.com");
        mimeMessageHelper.setTo(userEntity.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("Confirming your booked Ticket");

        javaMailSender.send(mimeMessage);



        return "Ticket has Successfully added";
    }
    private String getAllotedSeatsFromShowSeats(List<String> allocatedSeats)
    {
        String bookedSeats="";
        for(String seats : allocatedSeats)
        {
            bookedSeats+=seats+", ";
        }
        return bookedSeats;
    }
    private boolean checkSeatIsBookedOrNot(TicketEntryDto ticketEntryDto)
    {
        ShowEntity showEntity = showsRepository.findById(ticketEntryDto.getShowId()).get();

        List<String> requstedSeats = ticketEntryDto.getRequstedSeats();

        List<ShowSeatEntity> showSeatEntityList = showEntity.getListOfShowSeats();

        for(ShowSeatEntity showSeatEntity : showSeatEntityList)
        {
            String seatNo =showSeatEntity.getSeatNumber();
            if(requstedSeats.contains(seatNo))
            {
                if(showSeatEntity.isBooked()== true) {
                    return false;
                }
            }
        }
        return true;
    }
}
