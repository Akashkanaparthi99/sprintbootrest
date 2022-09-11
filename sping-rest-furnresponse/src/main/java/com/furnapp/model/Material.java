package com.furnapp.model;

public enum Material {
    TWOOD(1,"TEAK WOOD"),
    PLASTIC(2,"PALSTIC"),
    SWOOD(3,"SHESHAM WOOD"),
    MWOOD(4,"MANGO WOOD"),
    STEEL(5,"STAINLESS STEEL");

    public int grade;
    public String type;

    Material(int grade, String type) {
        this.grade = grade;
        this.type = type;
    }
}
