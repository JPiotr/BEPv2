package wsei.project.BEP.entityes.Access;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import wsei.project.BEP.entityes.Type;

import java.time.LocalDate;
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
    private final LocalDate insertDate;
    @Field
    public LocalDate modyfyDate;

    public AnyDesk(String name, String number, String password, Type type) {
        this.id = UUID.randomUUID().toString();
        this.insertDate = LocalDate.now();
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
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getModyfyDate() {
        return modyfyDate;
    }

    public void setModyfyDate(LocalDate modyfyDate) {
        this.modyfyDate = modyfyDate;
    }

    public String getId() {
        return id;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }
}
