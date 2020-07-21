package com.Booking.Booking.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.Booking.Booking.dtos.BookingRequestFrontDTO;
import com.Booking.Booking.dtos.ItemInCartDTO;
import com.Booking.Booking.dtos.ItemInCartFrontDTO;
import com.Booking.Booking.dtos.ReservationDTO;
import com.Booking.Booking.enums.RequestStates;
import com.Booking.Booking.model.ItemInCart;
import com.Booking.Booking.model.requests.BookingRequest;
import com.Booking.Booking.repository.BookingRequestRepository;
import com.Booking.Booking.service.BookingRequestService;
import com.Booking.Booking.service.ItemInCartService;
import com.Booking.Booking.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value = "booking")
public class BookingRequestController {

    @Autowired
    BookingRequestService bookingRequestService;

    @Autowired
    ItemInCartService itemInCartService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/hello")
    public ResponseEntity<?> get() {

        return new ResponseEntity<>(String.format("OMMMMMMGMF"), HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<ItemInCartFrontDTO>> Login(@RequestBody List<ItemInCartDTO> lista) {

        System.out.println("Pogodio je back");

        bookingRequestService.makeRequests(lista);

        itemInCartService.removeAll();

        return new ResponseEntity<>(shoppingCartService.fotCart(), HttpStatus.OK);
    }

    @PostMapping(value = "/getAllForAgent")
    public ResponseEntity<List<BookingRequestFrontDTO>> getAllSpecificForAgent(@RequestBody RequestStates state) {

        List<BookingRequestFrontDTO> requests = bookingRequestService.getAllSpecificForAgent(state);

        System.out.println("pogodio je kontroler, broj oglasa vraca==" + requests.size());

        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping(value = "/getGroupsForAgent")
    public ResponseEntity<List<Long>> getAllSpecificGroupsForAgent(@RequestBody RequestStates state) {

        List<Long> groups = bookingRequestService.getSpecificGroupsForAgent(state);

        System.out.println("pogodio je kontroler, broj grupa==" + groups.size());

        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @PostMapping(value = "/acceptRequest")
    public ResponseEntity<Long> acceptRequest(@RequestBody Long grupa) {

        System.out.println("Pogodio prihvatanje zahteva grupe: " + grupa);

        bookingRequestService.acceptRequest(grupa);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/getAllSpecificForBuyer")

    public ResponseEntity<List<BookingRequestFrontDTO>> getAllSpecificForBuyer(@RequestBody RequestStates state) {

        List<BookingRequestFrontDTO> requests = bookingRequestService.getAllSpecificForBuyer(state);

        System.out.println("pogodio je kontroler, broj oglasa vraca==" + requests.size());

        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping(value = "/grups")
    public ResponseEntity<List<Long>> getAllSpecificGroupsForBuyer(@RequestBody RequestStates state) {

        List<Long> groups = bookingRequestService.getSpecificGroupsForBuyer(state);

        System.out.println("pogodio je kontroler, broj grupa==" + groups.size());

        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @PostMapping(value = "/cancelRequest")
    public ResponseEntity<Long> cancelRequest(@RequestBody Long group) {

        bookingRequestService.cancelRequest(group);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // @GetMapping(value = "/getAllBookings")
    // public ResponseEntity<List<BookingRequest>> getAllBookings() {
    // List<BookingRequest> booked = new ArrayList<BookingRequest>();
    // List<BookingRequest> all = bookingRequestService.findAll();

    // for (BookingRequest request : all) {
    // if ((request.getStateOfRequest().name().equals("RESERVED")
    // || request.getStateOfRequest().name().equals("PAID"))
    // && request.getTimeFrom().isAfter(LocalDateTime.now())) {
    // booked.add(request);
    // }
    // }
    // return new ResponseEntity<>(booked, HttpStatus.OK);
    // }

    @GetMapping(value = "/getAllBookings")
    public ResponseEntity<List<BookingRequest>> getAllBookings() {
        List<BookingRequest> booked = new ArrayList<BookingRequest>();
        List<BookingRequest> all = bookingRequestService.findAll();

        for (BookingRequest request : all) {
            if ((request.getStateOfRequest().name().equals("RESERVED")
                    || request.getStateOfRequest().name().equals("PAID"))
                    && request.getTimeFrom().isAfter(LocalDateTime.now())) {
                booked.add(request);
            }
        }
        return new ResponseEntity<>(booked, HttpStatus.OK);
    }


    @PostMapping(value = "/reserve")
    public ResponseEntity<Long> reserve(@RequestBody ReservationDTO reservation) {

        

        bookingRequestService.saveReserve(reservation);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}