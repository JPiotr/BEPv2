package wsei.project.BEP.entityes.Access;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Document
public class DB {
    @MongoId
    private String id;
    @Field
    public String name;
    @Field
    public String ipaddress;
    @Field
    public String adminLogin = "sa";
    @Field
    public String password;
    @Field
    public Boolean integratedLogin = true;

    public DB(String name, String ipaddress, String adminLogin, String password, Boolean integratedLogin) {
        this.name = name;
        this.ipaddress = ipaddress;
        this.password = password;
        this.integratedLogin = Objects.requireNonNullElse(integratedLogin, true);
        this.adminLogin = Objects.requireNonNullElse(adminLogin, "sa");
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

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIntegratedLogin() {
        return integratedLogin;
    }

    public void setIntegratedLogin(Boolean integratedLogin) {
        this.integratedLogin = integratedLogin;
    }

    @Override
    public String toString() {
        return "DB{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", adminLogin='" + adminLogin + '\'' +
                ", password='" + password + '\'' +
                ", integratedLogin=" + integratedLogin +
                '}';
    }
}
