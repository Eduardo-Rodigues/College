package com.example.app_api_paises_novo.dao;

import com.example.app_api_paises_novo.model.Pais_Model;

import java.util.ArrayList;

public interface InterfaceGenericDao {

    long insert (Pais_Model obj);
    long update (Pais_Model obj);
    ArrayList<Pais_Model> getAll();
    Pais_Model getById(int id);
}
