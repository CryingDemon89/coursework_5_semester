package com.example.train_station.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; // аннотация для работы со столбцами в sql, id указывается автоматически
import jakarta.persistence.GenerationType; // класс отвечающих за тип данных перечисление
import jakarta.persistence.Id; // указание на первичный ключ

@Entity
public class Route {
    private long id;
    private long scheduleid;
    private String station;
    private String arr_time;
    private long stop;
    private String dep_time;

    public Route() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public long getScheduleid() {return scheduleid;}
    public void setScheduleid(long scheduleid) {this.scheduleid = scheduleid;}
    public String getStation() {return station;}
    public void setStation(String station) {this.station = station;}
    public String getArr_time() {return arr_time;}
    public void setArr_time(String arr_time) {this.arr_time = arr_time;}
    public long getStop() {return stop;}
    public void setStop(long stop) {this.stop = stop;}
    public String getDep_time() {return dep_time;}
    public void setDep_time(String dep_time) {this.dep_time = dep_time;}
}
