package com.example.mazhuang.travelbag;

import java.security.Timestamp;

/**
 * Created by mazhuang on 2018/4/12.
 */
public class Order {
   private int id;
   private String name;
   private String phone;
   private String destination;
   private int bagNum;
   private Timestamp arriveTime;
   private double price;
   private String firstStation;
   private String nowStation;
   private int status;
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setBagNum(int bagNum) {
        this.bagNum = bagNum;
    }

    public int getBagNum() {
        return bagNum;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setNowStation(String nowStation) {
        this.nowStation = nowStation;
    }

    public String getNowStation() {
        return nowStation;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }


}
