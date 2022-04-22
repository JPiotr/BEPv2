package wsei.project.BEP.entityes;

import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document("clients")
public class Client{

    @MongoId
    private String code;
    @Field
    private String name;
    @Field
    private Integer number;
    @Reference
    private List<Acces> accesList;

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

    public List<Acces> getAccesList() {
        return accesList;
    }

    public void setAccesList(List<Acces> accesList) {
        this.accesList = accesList;
    }

    @Override
    public String toString(){
        return String.format(
                "Client[code=%s, name='%s', number='%s',access=['%s']]",
                code, name, number,accesList.toArray().toString());
    }

}