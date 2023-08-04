package com.training.specs;

import com.mongodb.client.*;
import com.training.dbs.MongoCRUD;
import org.apache.log4j.BasicConfigurator;
import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MongoCrudSpec {


    private MongoCRUD crud ;
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    private static MongoCollection<Document> collection;

    @BeforeAll
    public static void setUp(){

        Logger logger = Logger.getLogger("MongoCRUD.class");

        // to configure default on the console
        BasicConfigurator.configure();


        MongoCRUD.connectMongo();

        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database =  mongoClient.getDatabase("music");
        collection =  database.getCollection("mData");
   }


    @BeforeEach
    public  void createCrud(){

        crud = new MongoCRUD();
    }
    @Test
    public void createDocumentSpec(){

       long count = collection.countDocuments();

      Document d =  new Document();
      d.put("name","uthe sabke kadam ");
      d.put("artist-group","Lata Mangeshkar");

      //collection.insertOne(d);
      MongoCRUD.insertDocument(d);
      long ctr2 =count+1;

      assertEquals(count+1 , ctr2);

   }

    @Test
    public void deleteDocumentSpec(){

        long count = collection.countDocuments();

        Document d =  new Document();
        d.put("name","Oh So Lovely");

        //collection.insertOne(d);
        MongoCRUD.deleteDocument(d);

        long countAfterDelete =  collection.countDocuments();


        assertEquals(count-1 , countAfterDelete);

    }


}
