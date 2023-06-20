package Profiles.demo.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

@Document(collection="ProfilesStore")
public class userProfile {
    public String getId() {
        return id;
    }

    private String id;
    private Map<String,Object> data;
    public userProfile(userProfile profile){
        this.id=profile.id;
        this.data=profile.getData();
    }
    public userProfile(){
        this.data=new HashMap<>();
    }
    public Map<String,Object> getData(){
        return this.data;
    }
    public Object getSpecificData(String fieldName){
        return data.get(fieldName);
    }
    public void putData(String fieldName,Object object){
        data.put(fieldName,object);
    }
}
