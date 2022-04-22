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

    public Type(String name) {
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
                "Id=" + id +
                ", Name='" + name + '\'' +
                '}';
    }
}
