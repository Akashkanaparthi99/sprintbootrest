package com.studentapp.model;

public interface StudentDTO {
    String getName();
    String getDepartment();
    Address getAddress();

    // nested interface
    interface AddressDTO{
        String getCity();

    }

}
