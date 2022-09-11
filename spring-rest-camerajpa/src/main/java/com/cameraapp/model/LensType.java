package com.cameraapp.model;

public enum LensType {
    ZOOM("Zoom Lens"),
    WIDE("Wide Angle Lens"),
    PRIME("Prime Lens"),
    TELEPHOTO("Telephoto Lens");

    public String lensType;

    LensType(String lensType) {
        this.lensType = lensType;
    }
}
