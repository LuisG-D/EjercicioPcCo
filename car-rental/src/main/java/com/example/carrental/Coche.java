package com.example.carrental;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    private String manufacturer;
    private String model;
    private Integer dateFabric;

    public Coche() {

    }

    public Coche(Long carId, String manufacturer, String model, Integer dateFabric) {
        this.carId = carId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.dateFabric = dateFabric;
    }

    public Long getcarId() {
        return carId;
    }

    public void setcarId(Long carId) {
        this.carId = carId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getdateFabric() {
        return dateFabric;
    }

    public void setdateFabric(Integer dateFabric) {
        this.dateFabric = dateFabric;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "carId=" + carId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", dateFabric=" + dateFabric +
                '}';
    }
}
