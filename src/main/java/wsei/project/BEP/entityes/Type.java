package wsei.project.BEP.entityes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;
import java.util.UUID;

@Document("types")
public class Type {
    @Id
    public String id;
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
        this.id = Objects.requireNonNullElse(id, UUID.randomUUID().toString());
        this.logourl = Objects.requireNonNullElse(logourl, "data/deflaut.svg");
        this.name = name;
    }

    public String getId() {
        return id;
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
