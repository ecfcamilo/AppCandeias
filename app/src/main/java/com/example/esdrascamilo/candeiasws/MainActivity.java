package com.example.esdrascamilo.candeiasws;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://dev.clubecandeias.com";
    public static String PATH;
    private EditText busca_destino;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Captura do texto digitado
        busca_destino = (EditText) findViewById(R.id.destino_editText);
        TextWatcher texto = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PATH = busca_destino.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

                //---------------------------------------------------------
                //Método Retrofit Webservice

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                HotelService service = retrofit.create(HotelService.class);
                Call<HotelSug> hoteis = service.getHoteis(PATH);


                hoteis.enqueue(new Callback<HotelSug>() {
                    @Override
                    public void onResponse(Call<HotelSug> call, Response<HotelSug> response) {


                        try {
                            List < String > stringList = new ArrayList < > ();
                            ListView lista = (ListView)findViewById(R.id.destino_listView);
                            List<Suggestions> sug = response.body().getSuggestions();


                            for (int i=0; i<sug.size(); i++){
                                stringList.add(sug.get(i).getValue());
                            }

                            ArrayAdapter adapter = new ArrayAdapter <> (getApplicationContext(), android.R.layout.simple_list_item_1, stringList);
                            lista.setAdapter(adapter);

                        } catch (Exception e) {
                            Log.d("onResponse", "There is an error");
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<HotelSug> call, Throwable t) {
                        Log.i("ERRORETROFIT", "Erro: "+t.getMessage());
                    }
                });


                //---------------------------------------------------------
                //Fim do Método Retrofit

            }
        };

        busca_destino.addTextChangedListener(texto);




    }

}
