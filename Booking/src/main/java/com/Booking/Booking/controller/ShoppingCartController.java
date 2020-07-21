package com.Booking.Booking.controller;

import java.util.List;

import com.Booking.Booking.dtos.ItemInCartDTO;
import com.Booking.Booking.dtos.ItemInCartFrontDTO;
import com.Booking.Booking.model.ItemInCart;
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
//@RequestMapping(value = "shoppingCart")
public class ShoppingCartController {


    @Autowired
	private ShoppingCartService shoppingCartService;
    


    @GetMapping(value = "/forCart")
    public ResponseEntity<List<ItemInCartFrontDTO>> getAllForCart() {
		
	   
		List<ItemInCartFrontDTO> items = shoppingCartService.fotCart();

		System.out.println("pogodio je kontroler, broj oglasa vraca=="+items.size());
		
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


    @PostMapping(value = "/createShoopingCart")
    public ResponseEntity<Long> createNewCart(@RequestBody Long userId) {
		
	   
		
		shoppingCartService.save(userId);
        
        return new ResponseEntity<Long>(userId,HttpStatus.OK);
    }

   
    
}