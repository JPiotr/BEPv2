package wsei.project.BEP.entityes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Encrypted;
import org.springframework.data.mongodb.core.mapping.Field;
import wsei.project.BEP.entityes.Access.Acces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Document("clients")
public class Client {

    @Id
    @Indexed(unique = true)
    private String code;
    @Field
    private LocalDateTime insertDate;
    @DocumentReference(collection = "acceses")
    private Acces acces;
    @Field
    public String name;
    @Field
    @Indexed(unique = true)
    public Integer number;
    @Field
    public DefaultStatus status;
    @Field
    public LocalDateTime modyfyDate;
    @Field
    public Boolean isBR;
    @Field
    public List<Client> brClients = new ArrayList<>();

    public Client(String code, String name, Integer number) {
        this.isBR = false;
        this.code = code;
        this.name = name;
        this.number = number;
        this.status = DefaultStatus.NEW;
        this.insertDate = LocalDateTime.from(LocalDate.now().atTime(LocalTime.now()));
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public LocalDateTime getModyfyDate() {
        return modyfyDate;
    }

    public void setModyfyDate() {
        this.modyfyDate = LocalDateTime.from(LocalDate.now().atTime(LocalTime.now()));
    }

    public DefaultStatus getStatus() {
        return status;
    }

    public void setStatus(DefaultStatus status) {
        this.setModyfyDate();
        this.status = status;
    }

    public List<Client> getBrClients() {
        return brClients;
    }

    public void setBrClients(List<Client> brClients) {
        this.setModyfyDate();
        this.brClients = brClients;
    }

    public Boolean getBR() {
        return isBR;
    }

    public void setBR(Boolean BR) {
        this.setModyfyDate();
        isBR = BR;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.setModyfyDate();
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.setModyfyDate();
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.setModyfyDate();
        this.number = number;
    }

    public Acces getAcces() {
        return acces;
    }

    public void setAcces(Acces acces) {
        this.setModyfyDate();
        this.acces = acces;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code='" + code + '\'' +
                ", insertDate=" + insertDate +
                ", acces=" + acces +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", status=" + status +
                ", modyfyDate=" + modyfyDate +
                ", isBR=" + isBR +
                ", brClients=" + brClients +
                '}';
    }
}