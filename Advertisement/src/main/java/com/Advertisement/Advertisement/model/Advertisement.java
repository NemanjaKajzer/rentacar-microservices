package com.Advertisement.Advertisement.model;

import java.util.ArrayList;
import javax.persistence.*;

import com.Advertisement.Advertisement.model.*;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Model model;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private FuelType fuelType;

    @ManyToOne
    private TransmissionType transmissionType;

    @ManyToOne
    private CarClass carClass;

    private int travelled;

    private int carSeats;

    private double price;

    private double discount;

    private double priceWithDiscount;

    private ArrayList<String> pictures;

    private Long postedByID;

    private Double grade;

    public Advertisement() {

    }

    public Advertisement(String name, Model model, Brand brand, FuelType fuelType, TransmissionType transmissionType,
            CarClass carClass, int travelled, int carSeats, double price, Long postedByID, double discount,
            ArrayList<String> pictures, Double grade) {
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.carClass = carClass;
        this.travelled = travelled;
        this.carSeats = carSeats;
        this.price = price;
        this.postedByID = postedByID;
        this.discount = discount;
        this.priceWithDiscount = price - (this.price * this.discount / 100);
        this.pictures = pictures;
        this.grade = grade;
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
        return this.fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public TransmissionType getTransmissionType() {
        return this.transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public CarClass getCarClass() {
        return this.carClass;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPostedByID() {
        return this.postedByID;
    }

    public void setPostedBy(Long postedByID) {
        this.postedByID = postedByID;
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

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Advertisement{" + "id=" + id + ", name='" + name + '\'' + ", model='" + model + '\'' + ", brand='"
                + brand + '\'' + ", fuelType='" + fuelType + '\'' + ", transType='" + transmissionType + '\''
                + ", carClass='" + carClass + '\'' + ", travelled=" + travelled + ", carSeats=" + carSeats + ", price="
                + price + ", postedBy=" + postedByID + ", grade=" + grade + '}';
    }
}
