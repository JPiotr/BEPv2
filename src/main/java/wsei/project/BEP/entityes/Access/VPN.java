package wsei.project.BEP.entityes.Access;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import wsei.project.BEP.entityes.Type;

import java.time.LocalDate;
import java.util.UUID;

@Document("vpns")
public class VPN {
    @Id
    private String id;
    @Field
    public String ipaddress;
    @Field
    public String name;
    @Field
    private String password = "none";
    @Field
    private String connFileUrl;
    @Field
    public VpnTypes typeOfVpn;
    @Field
    @DocumentReference(collection = "types")
    public Type type;
    @Field
    private final LocalDate insertDate;
    @Field
    public LocalDate modyfyDate;

    public VPN(String ipaddress, String name, String password, String connFileUrl, VpnTypes typeOfVpn, Type type) {
        this.id = UUID.randomUUID().toString();
        this.insertDate = LocalDate.now();
        this.ipaddress = ipaddress;
        this.name = name;
        this.password = password;
        this.connFileUrl = connFileUrl;
        this.typeOfVpn = typeOfVpn;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnFileUrl() {
        return connFileUrl;
    }

    public void setConnFileUrl(String connFileUrl) {
        this.connFileUrl = connFileUrl;
    }

    public VpnTypes getTypeOfVpn() {
        return typeOfVpn;
    }

    public void setTypeOfVpn(VpnTypes typeOfVpn) {
        this.typeOfVpn = typeOfVpn;
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
        return "VPN{" +
                "id='" + id + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", connFileUrl='" + connFileUrl + '\'' +
                ", typeOfVpn=" + typeOfVpn +
                ", type=" + type +
                ", insertDate=" + insertDate +
                ", modyfyDate=" + modyfyDate +
                '}';
    }
}

enum VpnTypes{
    OPEN_VPN,WINDOWS_VPN,CISCO_VPN,OPEN_VPN_CONNECTION,FORTICLIENT
}
