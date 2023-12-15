package com.example.app_api_paises_novo.controller;

import android.content.Context;
import com.example.app_api_paises_novo.Retrofit.RetrofitConfig;
import com.example.app_api_paises_novo.dao.PaisDao;
import com.example.app_api_paises_novo.dto.PaisDto;
import com.example.app_api_paises_novo.model.Pais_Model;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaisController {
    public static void getViaPais(Context context){
        try{
            retrofit2.Call<ArrayList < PaisDto>> call =new RetrofitConfig().paisService().getPaisDtoCall();
            call.enqueue(new Callback<ArrayList<PaisDto>>() {
                @Override
                public void onResponse(Call<ArrayList<PaisDto>> call, Response<ArrayList<PaisDto>> response) {
                    ArrayList<PaisDto> listaPais = response.body();

                    for (int i = 0 ; i <listaPais.size(); i++){
                        PaisDto pais = listaPais.get(i);

                        salvar(pais.getCodigo(), pais.getDescricao(),context);

                    }
                }

                @Override
                public void onFailure(Call<ArrayList<PaisDto>> call, Throwable t) {

                }
            });
        }catch (Exception ex){
        }

    }
    public static String salvar (int codigo, String descricao, Context context){
        try {
            Pais_Model pais = new Pais_Model();
            pais.setCodigo(codigo);
            pais.setDescricao(descricao);
            PaisDao.getPais_Dao_Instancia(context).insert(pais);
        } catch (Exception ex) {
            return "Erro ao gravar pais." + ex.getMessage();
        }
        return null;
    }
    public static ArrayList<Pais_Model> retornar(Context context){
        return PaisDao.getPais_Dao_Instancia(context).getAll();
    }
}
