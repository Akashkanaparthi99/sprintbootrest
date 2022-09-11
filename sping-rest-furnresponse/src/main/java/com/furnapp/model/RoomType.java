package com.furnapp.model;

public enum RoomType {
    BED("Bedroom"),
    OFFICE("Office room"),
    DINING("Dining room"),
    STUDY("Study room"),
    KIDS("Kids room"),
    GUEST("Guest room"),
    STORE("Store room"),
    LIVING("Living room");

    public final String room;

    RoomType(String type) {
        this.room = type;
    }
}
