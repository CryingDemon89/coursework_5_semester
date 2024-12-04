package com.example.train_station.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; // аннотация для работы со столбцами в sql, id указывается автоматически
import jakarta.persistence.GenerationType; // класс отвечающих за тип данных перечисление
import jakarta.persistence.Id; // указание на первичный ключ

@Entity
public class Train {
    private long id;
    private String name;
    private long car_num; //кол-во вагонов
    private long compartment_num; // кол-во мест купе
    private long berth_num; // кол-во мест плацкарт
    public Train() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}
    public long getCar_num() {return car_num;}
    public void setCar_num(long car_num) {this.car_num = car_num;}
    public long getCompartment_num() {return compartment_num;}
    public void setCompartment_num(long compartment_num) {
        this.compartment_num = compartment_num;
    }
    public long getBerth_num() {return berth_num;}
    public void setBerth_num(long berth_num) {this.berth_num = berth_num;}
}
