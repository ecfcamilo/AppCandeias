package com.example.esdrascamilo.candeiasws;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Esdras Camilo on 28/03/2018.
 */

public interface HotelService {

    @GET("/v1/hotels/autocomplete")
    Call<HotelSug> getHoteis(@Query("search") String name);
}
