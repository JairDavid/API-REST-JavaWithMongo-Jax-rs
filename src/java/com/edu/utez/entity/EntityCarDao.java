package com.edu.utez.entity;

import com.edu.utez.service.MongodbConexion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import jdk.nashorn.internal.parser.JSONParser;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class EntityCarDao extends MongodbConexion {
    MongoDatabase agency = conexion().getDatabase("agency");
    MongoCollection<Document> cars = agency.getCollection("cars");
    public boolean insertNew(EntityCar entityCar){
        try{
            Document car = new Document("model",entityCar.getModel())
                    .append("brand",entityCar.getBrand())
                    .append("year",entityCar.getYear());
            cars.insertOne(car);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<EntityCar> carsList(){
        List<Document> list = cars.find().into(new ArrayList<Document>());
        List<EntityCar> carList = new ArrayList<>();
        for (Document var: list
             ) {
            carList.add(new EntityCar(
                    var.getObjectId("_id").toString(),
                    var.getString("model"),
                    var.getString("brand"),
                    var.getInteger("year")
            ));
        }

        return carList;
    }

    public String uniqueCar(String _id){
        Document car;
        try{
            car = new Document("_id", new ObjectId(_id));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return cars.find(car).first().toJson();
    }
    public boolean update(EntityCar entityCar, String _id){
        try{
            Bson filter = eq("_id",new ObjectId(_id));
            UpdateResult updateResult = cars.updateOne(filter,combine(
                    set("model",entityCar.getModel()),
                    set("brand",entityCar.getBrand()),
                    set("year",entityCar.getYear())));
            System.out.println(updateResult);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean delete(String _id){
        try{
            DeleteResult result = cars.deleteOne(new Document("_id", new ObjectId(_id)));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
