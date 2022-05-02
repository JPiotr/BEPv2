package wsei.project.BEP.entityes.Access;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import wsei.project.BEP.entityes.Access.DB;
import wsei.project.BEP.entityes.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Document("enovas")
public class Enova {
    @Id
    private String id;
    @Field
    public String login;
    @Field
    private String password;

    @Field
    @DocumentReference(collection = "types")
    public Type type;

    @Field
    private LocalDateTime insertDate;

    @Field
    public LocalDateTime modyfyDate;

    @Field
    @DocumentReference(collection = "dbs")
    public DB db;

    public Enova(String login, String password, DB db, Type type) {
        this.id = UUID.randomUUID().toString();
        this.login = login;
        this.password = password;
        this.db = db;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.setModyfyDate();
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.setModyfyDate();
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.setModyfyDate();
        this.password = password;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.setModyfyDate();
        this.db = db;
    }

    @Override
    public String toString() {
        return "Enova{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", db=" + db +
                '}';
    }
}
