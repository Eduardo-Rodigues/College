package com.example.app_api_paises_novo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.app_api_paises_novo.helper.SQLiteDataHelper;
import com.example.app_api_paises_novo.model.Pais_Model;
import java.util.ArrayList;

public class PaisDao implements InterfaceGenericDao {
    private SQLiteDatabase  DataBase;
    private SQLiteOpenHelper OpenHelper;
    private String[]colunas ={"CODIGO","DESCRICAO"};

    private String tabela = "PAIS";
    private Context context;
    private static PaisDao Pais_Dao_Instancia;

    public static PaisDao getPais_Dao_Instancia(Context context) {
        if(Pais_Dao_Instancia == null){
            return Pais_Dao_Instancia =new PaisDao(context);
        }
        else{
            return Pais_Dao_Instancia;
        }
    }

    private PaisDao(Context context){
        this.context = context;
        OpenHelper = new SQLiteDataHelper(this.context,
                "PAIS", null, 1);
        DataBase = OpenHelper.getWritableDatabase();
    }

    @Override
    public long insert(Pais_Model obj) {try{
        ContentValues valores = new ContentValues();
        valores.put(colunas[0], obj.getCodigo());
        valores.put(colunas[1], obj.getDescricao());
        return DataBase.insert(tabela, null, valores);
    }catch (SQLException ex){
        Log.e("PAIS", "ERRO: PaisDao.insert() "+ex.getMessage());
    }
        return 0;
    }

    @Override
    public long update(Pais_Model obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getCodigo());
            valores.put(colunas[1], obj.getDescricao());
            return DataBase.insert(tabela, null, valores);
        }catch (SQLException ex){
            Log.e("PAIS", "ERRO: PAISDAO.update() "+ex.getMessage());
        }
        return 0;

    }

    @Override
    public ArrayList<Pais_Model> getAll() {
        ArrayList<Pais_Model> lista = new ArrayList<>();
        try{
            Cursor cursor = DataBase.query(tabela,
                    colunas, null,
                    null, null,
                    null, colunas[0]+" desc");

            if(cursor.moveToFirst()){
                do{
                    Pais_Model pais_model = new Pais_Model();
                    pais_model.setCodigo(cursor.getInt(0));
                    pais_model.setDescricao(cursor.getString(1));
                    lista.add(pais_model);

                }while (cursor.moveToNext());
            }

        }catch (SQLException ex){
            Log.e("Pais", "ERRO: PaisDao.getAll() "+ex.getMessage());
        }

        return lista;
    }
    public Pais_Model getById(int id){
        try{
            String[]identificador =     {String.valueOf(id)};
            Cursor cursor = DataBase.query(tabela, colunas,
                    colunas[3]+"= ?", identificador,
                    null, null, null);

            if(cursor.moveToFirst()){
                Pais_Model pais_model = new Pais_Model();
                pais_model.setCodigo(cursor.getInt(0));
                pais_model.setDescricao(cursor.getString(1));

                return pais_model;
            }

        }catch (SQLException ex){
            Log.e("PAIS", "ERRO: Pais.getById() "+ex.getMessage());
        }
        return null;
    }
}
