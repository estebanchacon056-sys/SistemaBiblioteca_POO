/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author AXEL
 */
public class ClienteDAO {
    
    private MongoCollection<Document> coleccion;

    // Constructor de la clase
    public ClienteDAO() {
        // Obtiene la conexión desde tu clase ConexionMongo
        MongoDatabase db = ConexionMongo.getDatabase();
        // Se conecta a la colección "Clientes"
        this.coleccion = db.getCollection("Clientes");
    }

    /**
     * Método para insertar un nuevo cliente en la base de datos
     */
    public void insertar(String nombre, String ciudad, int edad) {
        // 1. Se crea el documento con los datos estructurados
        Document doc = new Document("nombre", nombre)
                .append("ciudad", ciudad)
                .append("edad", edad);
        
        // 2. Se inserta el documento de forma real en la colección de MongoDB
        coleccion.insertOne(doc);
        
        System.out.println("¡Cliente insertado correctamente!");
    }
}