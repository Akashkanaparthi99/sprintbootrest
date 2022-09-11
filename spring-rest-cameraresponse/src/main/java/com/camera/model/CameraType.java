package com.camera.model;

public enum CameraType {
    DSLR("DSLR Camera"),
    SLR("SLR Camera"),
    MIRRORLESS("Mirror Less Camera"),
    POINTSHOOT("Point & Shoot Camera");
    public final String type;

    CameraType(String type) {
        this.type = type;
    }
}
