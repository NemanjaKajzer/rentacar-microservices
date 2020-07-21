package com.Booking.Booking.service;

import com.Booking.Booking.dtos.AdvertisementCreationDTO;
import com.Booking.Booking.dtos.ItemInCartDTO;
import com.Booking.Booking.dtos.ItemInCartFrontDTO;
import com.Booking.Booking.model.ItemInCart;
import com.Booking.Booking.model.ShoppingCart;
import com.Booking.Booking.repository.ItemInCartRepository;
import com.Booking.Booking.repository.ShoppingCartRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.core.ParameterizedTypeReference;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ItemInCartRepository itemInCartRepository;

    @Autowired
    RestTemplate restTemplate;

public void save(Long id){

    shoppingCartRepository.save(new ShoppingCart(id, new ArrayList<Long>()));

}


public void addAItemInCart(Long itemId){
    ShoppingCart cart=shoppingCartRepository.findOneByuserId(getLogedUserId());
    cart.addOneItemInCart(itemId);
    shoppingCartRepository.save(cart);
}

public void removeItemInCart(Long itemId){
    ShoppingCart cart=shoppingCartRepository.findOneByuserId(getLogedUserId());
    cart.removeOneItemInCart(itemId);
    shoppingCartRepository.save(cart);

}

public void removeAll(){
    System.out.println("OVO JE USER"+getLogedUserId());
    ShoppingCart cart=shoppingCartRepository.findOneByuserId(getLogedUserId());
    cart.removeAllItems();
    shoppingCartRepository.save(cart);

}

public ShoppingCart getShoppingCart(Long id){
    return shoppingCartRepository.findOneByuserId(id);
}


public List<ItemInCartFrontDTO> fotCart(){
    List< Long> items=new ArrayList<>();
    List<ItemInCart> vrati=new ArrayList<ItemInCart>();
    List<ItemInCartFrontDTO> vratiDtos=new ArrayList<ItemInCartFrontDTO>();


    //dobavlja sve item  in cart ID-jeve iz korpe konkretnog logovanog usera
    for(ShoppingCart shoppingCart: shoppingCartRepository.findAll()) {
        if(shoppingCart.getUserId().equals(getLogedUserId())){
            items=shoppingCart.getItemInCartList();
        }


    }

    //Dodajem item in cart za ID-eve koje smo dobili u prethodnom kkoraku
    for(ItemInCart itemInCart: itemInCartRepository.findAll()){
    
        for(Long id : items){
        System.out.println("Ovo su oglasi koji mi trebaju=="+id);
            if(itemInCart.getId().equals(id)){
             
                vrati.add(itemInCart);


            }
        }

    }

    System.out.println("BROJ ITEMA VRATI "+vrati.size());
     // List<AdvertisementCreationDTO> advertisements=restTemplate.exchange("http://advert/getAllAdvertisementsForCart",HttpMethod.GET, entity,  new ParameterizedTypeReference<List<AdvertisementCreationDTO>>() {
   // }).getBody();

    List<AdvertisementCreationDTO> advertisements = restTemplate.exchange("http://advert/getAllAdvertisementsForCart", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<AdvertisementCreationDTO>>() {
                }).getBody();

   

//prolazi kroz sve dobavljene oglase i izdvaja one ciji se id nalaze u itemInCartu, zatim pravi novi dto koji salje na front
//
        for (ItemInCart item : vrati) {
            System.out.println("ID OGLASA U ITEM IN CART"+ item.getAdvertisementId());
            for(AdvertisementCreationDTO advert: advertisements){
                System.out.println("Ovo je id od dobavljenih advertisementa"+advert.getId());
                if(item.getAdvertisementId().equals(advert.getId())){

                 System.out.println("ISTI SU    ");
                    ItemInCartFrontDTO novi=new ItemInCartFrontDTO(item.getId(),item.getTimeFrom(),item.getTimeTo(),advert);
                    vratiDtos.add(novi);
                    

                }

            }
            
        }


     
     // new ParameterizedTypeReference<List<BookingDTO>>() {

   //     System.out.println("PROSAO JEDAN");
   //     List<AdvertisementCreationDTO> advertisements2=     restTemplate.postForObject("http://advert/getAllAdvertisementsForCart2", HttpMethod.POST,List.class, oglasi);

         
    //}).getBody();
    //List<BookingDTO> bookedTimes = restTemplate.exchange("http://book/getAllBookings", HttpMethod.GET, null,
    //            new ParameterizedTypeReference<List<BookingDTO>>() {
      //          }).getBody();

      System.out.println("OVO SU DOBAVLJENI OGLASI iz ADVERTISEMENT======"+advertisements.size());
    
return vratiDtos;

}


public Long getLogedUserId(){
    

    Long id = restTemplate.exchange("http://auth/getUserId", HttpMethod.GET, null, 
    new ParameterizedTypeReference<Long>() {} ).getBody();

    System.out.println("Nasao je id="+id);

    return id;
}

    


}