package wsei.project.BEP.entityes;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("teamviewers")
public class TeamViewer {
    @MongoId
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
}
