package com.Advertisement.Advertisement.dtos;

public class CarDetailsDTO {
    
    private String name;
    private String code;
    private String type;

    public CarDetailsDTO(){

    }

    public CarDetailsDTO(String name, String code, String type){
        this.name = name;
        this.code = code;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}