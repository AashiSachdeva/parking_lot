package com.main;
class ParkingData{
    private int slotNumber;
    private String registrationNumber, colour;
    ParkingData(int slotNumber, String registrationNumber,String colour){
     
        this.slotNumber = slotNumber;
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }

    public String getDetails(){
        return this.slotNumber+"\t\t"+this.registrationNumber+"\t\t"+this.colour;
    }
}