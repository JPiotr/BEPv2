package wsei.project.BEP.entityes;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("anydesks")
public class AnyDesk {
    @MongoId
    private String id;
    @Field
    public String name;
    @Field
    public String number;
    @Field
    public String password = "none";
    @Field
    @DocumentReference(collection = "types")
    public Type type;
}
