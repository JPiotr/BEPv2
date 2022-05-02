package wsei.project.BEP.entityes.Access;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import wsei.project.BEP.entityes.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Document("anydesks")
public class AnyDesk {
    @Id
    private String id;
    @Field
    public String name;
    @Field
    public String number;
    @Field
    private String password = "none";
    @Field
    @DocumentReference(collection = "types")
    public Type type;
    @Field
    private LocalDateTime insertDate;
    @Field
    public LocalDateTime modyfyDate;

    public AnyDesk(String name, String number, String password, Type type) {
        this.id = UUID.randomUUID().toString();
        this.insertDate = LocalDateTime.from(LocalDate.now().atTime(LocalTime.now()));
        this.name = name;
        this.number = number;
        this.password = password;
        this.type = type;
    }

    @Override
    public String toString() {
        return "AnyDesk{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", insertDate=" + insertDate +
                ", modyfyDate=" + modyfyDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.setModyfyDate();
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.setModyfyDate();
        this.number = number;
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

    public String getId() {
        return id;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }
}
