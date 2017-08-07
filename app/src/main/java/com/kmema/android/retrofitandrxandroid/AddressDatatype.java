package com.kmema.android.retrofitandrxandroid;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kmema on 8/5/2017.
 */

class AddressDatatype {

    @SerializedName("street")
    public String street;
    @SerializedName("city")
    public String city;
    @SerializedName("state")
    public String state;
    @SerializedName("Country")
    public String Country;
}
