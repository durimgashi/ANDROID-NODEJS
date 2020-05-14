package com.up.fiekproject.Model;

public class Car {
    private int carId;
    private String brand;
    private String type;
    private String fuel;
    private Integer year;
    private Double price;
    private String color;
    private Integer numDoor;
    private String insurance;
    private String description;
    private String picturePath;
    private Integer status;

    public Car(){

    }

    public Car(String brand, String type, String fuel, Integer year, Double price, String color, Integer numDoor, String insurance, String description, String picturePath, Integer status) {
        this.brand = brand;
        this.type = type;
        this.fuel = fuel;
        this.year = year;
        this.price = price;
        this.color = color;
        this.numDoor = numDoor;
        this.insurance = insurance;
        this.description = description;
        this.picturePath = picturePath;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumDoor() {
        return numDoor;
    }

    public void setNumDoor(Integer numDoor) {
        this.numDoor = numDoor;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getProductName() {
        return brand;
    }

    public void setProductName(String productName) {
        this.brand = productName;
    }

    public String getPlatform() {
        return type;
    }

    public void setPlatform(String platform) {
        this.type = platform;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
