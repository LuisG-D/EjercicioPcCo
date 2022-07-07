package com.example.pccom.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lapId;
    private String manufacturer;
    private String modelName;
    private String descriptionDevice;
    private int hardDrive;
    private int memorySize;

    public Laptop(){}

    public Laptop(Long lapId, String manufacturer, String modelName, String descriptionDevice, int hardDrive
            , int memorySize) {
        this.lapId = lapId;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.descriptionDevice = descriptionDevice;
        this.hardDrive = hardDrive;
        this.memorySize = memorySize;
    }

    public Long getLapId() {
        return lapId;
    }

    public void setLapId(Long lapId) {
        this.lapId = lapId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDescriptionDevice() {
        return descriptionDevice;
    }

    public void setDescriptionDevice(String descriptionDevice) {
        this.descriptionDevice = descriptionDevice;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lapId=" + lapId +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", descriptionDevice='" + descriptionDevice + '\'' +
                ", hardDrive=" + hardDrive +
                ", memorySize=" + memorySize +
                '}' + "\n";
    }
}
