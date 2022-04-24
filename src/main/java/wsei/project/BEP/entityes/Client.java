package wsei.project.BEP.entityes;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document("clients")
public class Client{

    @Id
    private String code;
    @Field
    private String name;
    @Field
    private Integer number;
    @DocumentReference(collection = "acceses")
    private Acces acces;

    public Client(String code, String name, Integer number) {
        this.code = code;
        this.name = name;
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Acces getAccesList() {
        return acces;
    }

    public void setAcces(Acces acces) {
        this.acces = acces;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", acces=" + acces +
                '}';
    }
}