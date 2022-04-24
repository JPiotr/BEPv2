package wsei.project.BEP.entityes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

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
    public String password = "none";
    @Field
    @DocumentReference(collection = "types")
    public Type type;

    public TeamViewer(String name, String connectionId, String password, Type type) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.connectionId = connectionId;
        this.password = password;
        this.type = type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamViewer)) return false;
        TeamViewer that = (TeamViewer) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getConnectionId().equals(that.getConnectionId()) &&
                getPassword().equals(that.getPassword()) &&
                getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getConnectionId(), getPassword(), getType());
    }

    @Override
    public String toString() {
        return "TeamViewer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", connectionId='" + connectionId + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
