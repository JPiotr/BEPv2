package wsei.project.BEP.entityes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.sql.Timestamp;
import java.util.*;

@Document("acceses")
public class Acces {
    @Id
    private String id;
    @DocumentReference(collection = "clients")
    @Field
    public Client cid;
    @Field
    public Date insertDate;

    @Field
    public Date modyfyDate;

    @Field
    public List<TeamViewer> tvAccesses = new ArrayList<>();
    @Field
    public List<AnyDesk> adAccesses = new ArrayList<>();
    @Field
    public List<RDP> rdpAccesses = new ArrayList<>();
    @Field
    public List<Enova> enovaAccesses = new ArrayList<>();

    public Acces(Client cid) {
        this.id = UUID.randomUUID().toString();
        this.cid = cid;
        this.insertDate = new Date();
    }

    public void addEnova(Enova enova){
        enovaAccesses.add(enova);
    }
    public List<Enova> getEnovaAccesses() {
        return enovaAccesses;
    }

    public void setEnovaAccesses(List<Enova> enovaAccesses) {
        this.enovaAccesses = enovaAccesses;
    }

    public String getId() {
        return id;
    }

    public Client getCid() {
        return cid;
    }

    public void setCid(Client cid) {
        this.cid = cid;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public Date getModyfyDate() {
        return modyfyDate;
    }

    public void setModyfyDate(Date modyfyDate) {
        this.modyfyDate = modyfyDate;
    }

    public List<TeamViewer> getTvAccesses() {
        return tvAccesses;
    }

    public void setTvAccesses(List<TeamViewer> tvAccesses) {
        this.tvAccesses = tvAccesses;
    }

    public List<AnyDesk> getAdAccesses() {
        return adAccesses;
    }

    public void setAdAccesses(List<AnyDesk> adAccesses) {
        this.adAccesses = adAccesses;
    }

    public List<RDP> getRdpAccesses() {
        return rdpAccesses;
    }

    public void setRdpAccesses(List<RDP> rdpAccesses) {
        this.rdpAccesses = rdpAccesses;
    }

    @Override
    public String toString() {
        return "Acces{" +
                "id='" + id + '\'' +
                ", cid=" + cid +
                ", insertDate=" + insertDate +
                ", modyfyDate=" + modyfyDate +
                ", tvAccesses=" + tvAccesses +
                ", adAccesses=" + adAccesses +
                ", rdpAccesses=" + rdpAccesses +
                '}';
    }
}
