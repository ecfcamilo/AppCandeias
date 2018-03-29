package com.example.esdrascamilo.candeiasws;

import java.util.ArrayList;

/**
 * Created by Esdras Camilo on 29/03/2018.
 */

public class HotelSug {

    private ArrayList<Suggestions> suggestions;

    public ArrayList<Suggestions> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(ArrayList<Suggestions> suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "HotelSug{" +
                "suggestions=" + suggestions +
                '}';
    }
}
