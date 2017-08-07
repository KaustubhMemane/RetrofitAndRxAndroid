package com.kmema.android.retrofitandrxandroid;

import com.google.gson.annotations.SerializedName;


public class ResumeDataType {
    public String name;
    public String birthdate;
    @SerializedName("class")
    public String className;
    public String major;
    public String country;
    @SerializedName("address")
    public AddressDatatype addressDatatype;
    public String overview;
    public String skill;
    public String qualification;
    public String[] programming_language;
    public String[] Web_Development_Web_Services;
    public String[] Database_System;
    public String[] Operating_System_And_Tools;
    public String profile_image;
    public String[] videos;
}
