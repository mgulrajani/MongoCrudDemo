package com.training.dbs;
import com.mongodb.DocumentToDBRefTransformer;
import com.mongodb.client.*;
import org.apache.log4j.BasicConfigurator;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.print.Doc;
import java.util.logging.Logger;
public class MongoCRUD {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    private static MongoCollection<Document> collection;

    public static void main(String[] args) {
        String name = "Thunderstruck";
        Logger logger = Logger.getLogger("MongoCRUD.class");

        // to configure default on the console
        BasicConfigurator.configure();
        //connected to mongo
        connectMongo();

        //created a  Document with hard coded valuesfor artist title and genre ,
       //insertDocument();

       // updateDocument();

         // deleteDocument();

      // displayAllDocuments();

       displayDocumentByName(name);

    }

    private static void displayDocumentByName(String name) {

        Document query =  new Document();
        query.put("name",name);
        FindIterable<Document> allDocs =  collection.find(query);
        for(Document d: allDocs){
            System.out.println(d.get("name"));
            System.out.println(d.get("artist-group"));
        }

    }

    public static void displayAllDocuments() {

        //we want to retreive all documents

       FindIterable<Document> allDocs =  collection.find();
       for(Document d: allDocs){
           System.out.println(d.get("name"));
       }

    }

    public static void deleteDocument() {

        Document docToBeDeleted = new Document();
        docToBeDeleted.put("artist","AR Rahman");
        collection.deleteOne(docToBeDeleted);
        System.out.println("doc deleted");

    }


    public static void deleteDocument(Document d) {

          collection.deleteOne(d);
        System.out.println("doc deleted");

    }
    private static void updateDocument() {
        // first is the filter /query , what you want to modify
         Document searchDoc =
                  collection.find(new Document("title","some song")).first();

        System.out.println(searchDoc.toString());
        //what i want to update genre to pop music
         Bson updateValue =  new Document("genre","indian classical music");


         Bson updateOperation =new Document("$set",updateValue);

         collection.updateOne(searchDoc , updateOperation);
        System.out.println("doc updated");



    }

    public static void connectMongo() {

        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database =  mongoClient.getDatabase("music");
        collection =  database.getCollection("mData");
    }

    public  static void insertDocument(){

         Document doc = new Document();

         doc.put("artist","AR Rahman");

         doc.put("genre","soft music");

         doc.put("title","some song");

         collection.insertOne(doc);

    }

    public static void insertDocument(Document d){
         collection.insertOne(d);
    }








}


