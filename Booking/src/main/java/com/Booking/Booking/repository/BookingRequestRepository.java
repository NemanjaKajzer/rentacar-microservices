package com.Booking.Booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.Booking.Booking.model.requests.BookingRequest;




public interface BookingRequestRepository extends JpaRepository <BookingRequest,Long> {

public BookingRequest findOneByid(Long id);

public List<BookingRequest> findByUserForId(Long userForId);

public List<BookingRequest> findByUserToId(Long userForId);


public List<BookingRequest> findAllByGroupId(Long groupId);

public BookingRequest findTopByOrderByIdDesc();
    
}