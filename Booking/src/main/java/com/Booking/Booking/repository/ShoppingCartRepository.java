package com.Booking.Booking.repository;
import java.util.List;

import com.Booking.Booking.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    public ShoppingCart findOneByid(Long id);
    public ShoppingCart findOneByuserId(Long id);
    public List<ShoppingCart> findAll();
}

