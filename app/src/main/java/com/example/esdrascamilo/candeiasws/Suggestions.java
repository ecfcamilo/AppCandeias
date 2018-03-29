package com.example.esdrascamilo.candeiasws;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Esdras Camilo on 29/03/2018.
 */

public class Suggestions {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("hotel_id")
    @Expose
    private int hotel_id;

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("english_value")
    @Expose
    private String english_value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEnglish_value() {
        return english_value;
    }

    public void setEnglish_value(String english_value) {
        this.english_value = english_value;
    }

    @Override
    public String toString() {
        return "Suggestions{" +
                "id=" + id +
                ", hotel_id=" + hotel_id +
                ", value='" + value + '\'' +
                ", english_value='" + english_value + '\'' +
                '}';
    }
}
