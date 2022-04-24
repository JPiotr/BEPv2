package wsei.project.BEP.entityes;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("types")
public class Type {
    @MongoId
    String id;
    @Field
    String name;
    @Field
    String logourl;

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public Type(String name, String logourl) {
        if(logourl == null){
            this.logourl = "data/deflaut.svg";
        }
        else{
          this.logourl = logourl;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logourl='" + logourl + '\'' +
                '}';
    }
}
