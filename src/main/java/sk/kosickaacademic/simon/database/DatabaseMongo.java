package sk.kosickaacademic.simon.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DatabaseMongo {
    MongoClient mc = new MongoClient("localhost", 27017);
    MongoDatabase db = mc.getDatabase("myfirstdb");

    public boolean insertNewData(double eur, Map<String, Double> record){
        if(record==null || record.isEmpty()) return false;
        Document doc = new Document();
        doc.append("time", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        doc.append("EUR", eur);
        for(Map.Entry temp : record.entrySet())
            doc.append((String) temp.getKey(), temp.getValue());
        db.getCollection("rates").insertOne(doc);
        return true;
    }

    public boolean deleteData(double eur){
        if(eur<=0) return false;
        db.getCollection("rates").deleteOne(Filters.eq("EUR", eur));
        return true;
    }
}
