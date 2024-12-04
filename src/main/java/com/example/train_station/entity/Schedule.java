package com.example.train_station.entity;

import jakarta.persistence.*;

@Entity
public class Schedule {
    private long id;
    private String arr_time; // время пприбытия
    private String name;
    private long path; //путь
    private String train; //название поезда
    private String driver;
    public Schedule() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getArr_time() {return arr_time;}
    public void setArr_time(String arr_time) {this.arr_time = arr_time;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public long getPath() {return path;}
    public void setPath(long path) {this.path = path;}
    public String getTrain() {return train;}
    public void setTrain(String train) {this.train = train;}
    public String getDriver() {return driver;}
    public void setDriver(String driver) {this.driver = driver;}

}
