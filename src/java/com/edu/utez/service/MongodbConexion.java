package com.edu.utez.service;

import com.edu.utez.entity.EntityCarDao;
import com.mongodb.MongoClientException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class MongodbConexion {
    public MongoClient conexion() throws MongoClientException{
        MongoClient client=null;
        try{
            //desactivar slf4j
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE);
            client = MongoClients.create("mongodb+srv://m001-student:m001-mongodb-basics@sandbox.xbrgd.mongodb.net/agency?retryWrites=true&w=majority");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Ocurrio un error, verificar la URI de conexión");
        }
        System.out.println("Conexión establecida.");
        return client;

    }
    public static void main(String[] args) {
        //Test de conexión
        MongodbConexion c = new MongodbConexion();
        c.conexion();
        //Pruebas
        //new EntityCarDao().insertNew(new EntityCar("Kawazaki","Ford","2020"));
        //new EntityCarDao().update(new EntityCar("Ford Focus","Ford","2017"), "60317e937c3fa83fa197eafb");
        //System.out.println(new EntityCarDao().uniqueCar("602f073bde91122f9ce1289c"));
        //Document document = (Document) new EntityCarDao().uniqueCar("602f073bde91122f9ce1289c");
        //new EntityCarDao().delete("60317e937c3fa83fa197eafb");
    }
}