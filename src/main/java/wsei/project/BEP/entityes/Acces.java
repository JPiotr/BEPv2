package wsei.project.BEP.entityes;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("acceses")
public class Acces {
    @MongoId
    private String id;
    @Field
    public Type type;
    @Field
    public String password;
    @Field
    public String login;
    @Field
    public String id_tv;
    @Field
    public String address;

    public Acces(Type type, String password, String login, String ID, String address) {
        this.type = type;
        this.password = password;
        this.login = login;
        this.id_tv = ID;
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId_tv() {
        return id_tv;
    }

    public void setId_tv(String ID) {
        this.id_tv = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Acces{" +
                "id=" + id +
                ", type='" + type.toString() + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", ID='" + id_tv + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
