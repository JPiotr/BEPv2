package wsei.project.BEP.entityes.Access;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import wsei.project.BEP.entityes.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

@Document("rdps")
public class RDP {
    @Id
    private String id;
    @Field
    public String name;
    @Field
    public String ipaddress;
    @Field
    private String password;
    @Field
    @DocumentReference(collection = "types")
    public Type type;
    @Field
    private LocalDateTime insertDate;
    @Field
    public LocalDateTime modyfyDate;

    public RDP(String name, String ipaddress, String password, Type type) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.ipaddress = ipaddress;
        this.password = password;
        this.type = type;
        this.insertDate = LocalDateTime.from(LocalDate.now().atTime(LocalTime.now()));
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.setModyfyDate();
        this.name = name;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.setModyfyDate();
        this.ipaddress = ipaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.setModyfyDate();
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.setModyfyDate();
        this.type = type;
    }

    public LocalDateTime getModyfyDate() {
        return modyfyDate;
    }

    public void setModyfyDate() {
        this.modyfyDate = LocalDateTime.from(LocalDate.now().atTime(LocalTime.now()));
    }

    @Override
    public String toString() {
        return "RDP{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", insertDate=" + insertDate +
                ", modyfyDate=" + modyfyDate +
                '}';
    }

    public void generateRdpfile(){
        //todo:thismethod
    }
}
