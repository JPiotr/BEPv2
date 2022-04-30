package wsei.project.BEP.entityes.Access;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import wsei.project.BEP.entityes.Type;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document("teamviewers")
public class TeamViewer {
    @Id
    private String id;
    @Field
    public String name;
    @Field
    public String connectionId;
    @Field
    private String password = "none";
    @Field
    @DocumentReference(collection = "types")
    public Type type;
    @Field
    private final LocalDate insertDate;
    @Field
    public LocalDate modyfyDate;

    public TeamViewer(String name, String connectionId, String password, Type type) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.connectionId = connectionId;
        this.password = password;
        this.type = type;
        this.insertDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
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

    @Override
    public String toString() {
        return "TeamViewer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", connectionId='" + connectionId + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", insertDate=" + insertDate +
                ", modyfyDate=" + modyfyDate +
                '}';
    }
}
