package com.Advertisement.Advertisement.dtos;

import java.util.ArrayList;
import java.util.List;

import com.Advertisement.Advertisement.model.Advertisement;
import com.Advertisement.Advertisement.model.Brand;
import com.Advertisement.Advertisement.model.CarClass;
import com.Advertisement.Advertisement.model.FuelType;
import com.Advertisement.Advertisement.model.Model;
import com.Advertisement.Advertisement.model.TransmissionType;

public class AdvertisementDTO {
   
    private Long id;

    private String name;

    private Model model;

    private Brand brand;

    private FuelType fuelType;

    private TransmissionType transmissionType;

    private CarClass carClass;

    private int travelled;
  
    private int carSeats;

    private double price;

    private double postedByID;

    private double discount;

    private double priceWithDiscount;

    private ArrayList<String> pictures;

    private double grade;

    private List<CommentPreviewDTO> comments;

    public AdvertisementDTO(String name,Model model, Brand brand, FuelType fuelType, TransmissionType transmissionType, CarClass carClass, int travelled, int carSeats, double price,double discount, ArrayList<String> pictures) {
        this.name=name;
        this.model = model;
        this.brand = brand;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.carClass = carClass;
        this.travelled = travelled;
        this.carSeats = carSeats;
        this.price=price;
        this.discount = discount;
        this.priceWithDiscount = price - (price * discount / 100);
        this.pictures=pictures;
    }

    public AdvertisementDTO(Advertisement ad)
    {
        this.id = ad.getId();
        this.name = ad.getName();
        this.model = ad.getModel();
        this.brand = ad.getBrand();
        this.fuelType = ad.getFuelType();
        this.transmissionType = ad.getTransmissionType();
        this.carClass = ad.getCarClass();
        this.travelled = ad.getTravelled();
        this.carSeats = ad.getCarSeats();
        this.price=ad.getPrice();
        this.postedByID=ad.getPostedByID();
        this.discount = ad.getDiscount();
        this.priceWithDiscount = ad.getPriceWithDiscount();
        this.grade = ad.getGrade();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Brand getBrand() {
		return this.brand;
	}

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public int getTravelled() {
        return this.travelled;
    }

    public void setTravelled(int travelled) {
        this.travelled = travelled;
    }

    public int getCarSeats() {
        return this.carSeats;
    }

    public void setCarSeats(int carSeats) {
        this.carSeats = carSeats;
    }


    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
    public ArrayList<String> getPictures() {
        return this.pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    public List<CommentPreviewDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentPreviewDTO> comments) {
        this.comments = comments;
    }

    public double getPostedByID() {
        return postedByID;
    }

    public void setPostedByID(double postedByID) {
        this.postedByID = postedByID;
    }

}