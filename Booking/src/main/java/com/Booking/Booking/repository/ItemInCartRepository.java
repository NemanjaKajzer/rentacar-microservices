package com.Booking.Booking.repository;


import com.Booking.Booking.model.ItemInCart;

import org.springframework.data.jpa.repository.JpaRepository;





public interface ItemInCartRepository extends JpaRepository <ItemInCart,Long> {

public ItemInCart findOneByid(Long id);


    
}