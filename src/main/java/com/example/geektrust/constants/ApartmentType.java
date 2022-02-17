package com.example.geektrust.constants;

public enum ApartmentType {

    TWO_BHK(2, 3), THREE_BHK(3, 5);

    private int numOfRooms;
    private int persons;

    ApartmentType(int numOfRooms, int persons) {
        this.numOfRooms = numOfRooms;
        this.persons = persons;
    }

    public int getPersons() {
        return persons;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public static ApartmentType getAppartmentType(int persons) {
        if (persons == 2) {
            return ApartmentType.TWO_BHK;
        }
        return ApartmentType.THREE_BHK;
    }
}
