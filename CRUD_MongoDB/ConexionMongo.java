/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author AXEL
 */
public class ConexionMongo {
    
    private static MongoClient client;

    /**
     * Método estático para obtener la conexión a la base de datos "tienda"
     */
    public static MongoDatabase getDatabase() {
        // Si no existe una instancia de conexión, la crea
        if (client == null) {
            client = MongoClients.create("mongodb://localhost:27017");
        }
        
        // Retorna la base de datos (debe estar fuera del if para que siempre devuelva la DB)
        return client.getDatabase("tienda");
    }
}