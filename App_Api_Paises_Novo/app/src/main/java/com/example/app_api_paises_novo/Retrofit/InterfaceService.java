package com.example.app_api_paises_novo.Retrofit;

import com.example.app_api_paises_novo.dto.PaisDto;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceService {
    @GET("api/paises")
    Call<ArrayList<PaisDto>> getPaisDtoCall();
}
