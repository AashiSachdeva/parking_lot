package com.main;
public class Parking{
    private final int totalSlot;
    private int vacantSlot;
    private String parkingData[];

    public Parking(int totalSlot){
    	
        this.totalSlot = totalSlot;
        parkingData = new String[totalSlot];
        vacantSlot = 0;
    }

    public String park(String registrationNumber, String colour){

            for(int i = 0 ; i < totalSlot ; ++i){
                if(parkingData[i] == null){
                    parkingData[i] = (new ParkingData(i+1,registrationNumber,colour)).getDetails();
                    return "Allocated Slot Number: "+(i+1);
                } 
            }
        
        return "Sorry, parking lot is full";
    }

    public String[] status(){
        
        return parkingData;
    }

    public String leave(int slotNumber){
        parkingData[slotNumber-1] = null;
        return "Slot number "+slotNumber+" is free";
    }

    public String getRegistrationNumberFromColour(String colour){
        String regNumber = "";
        int count=0;
        for(int i = 0 ; i < totalSlot ; ++i){
            if(parkingData[i] != null && parkingData[i].split("\t\t")[2].equals(colour)){
                if(count != 0) regNumber += ", ";
                regNumber += parkingData[i].split("\t\t")[1];
                count++;
            } 
        }
        return regNumber;
    }

    public String getSlotNumberFromColour(String colour){
        String slotNumber = "";
        int count =0;
        for(int i = 0 ; i < totalSlot ; ++i){
            if(parkingData[i] != null && parkingData[i].split("\t\t")[2].equals(colour)){
                if(count != 0) slotNumber += ", ";
                slotNumber += parkingData[i].split("\t\t")[0];
                count++;
            } 
        }
        return slotNumber;
    }

    public String getSlotNumberFromRegistrationNumber(String registrationNumber){
        for(int i = 0 ; i < totalSlot ; ++i){
            if(parkingData[i] != null && parkingData[i].split("\t\t")[1].equals(registrationNumber)){
                return parkingData[i].split("\t\t")[0];
            } 
        }
        return "Not Found";
    }


  


}