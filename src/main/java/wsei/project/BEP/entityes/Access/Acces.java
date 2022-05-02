package wsei.project.BEP.entityes.Access;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;
import wsei.project.BEP.entityes.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Document("acceses")
public class Acces {
    @Id
    private String id;
    @DocumentReference(collection = "clients")
    @Field
    public Client cid;
    @Field
    private LocalDateTime insertDate;

    @Field
    public LocalDateTime modyfyDate;

    @Field
    public List<TeamViewer> tvAccesses = new ArrayList<>();
    @Field
    public List<AnyDesk> adAccesses = new ArrayList<>();
    @Field
    public List<RDP> rdpAccesses = new ArrayList<>();
    @Field
    public List<Enova> enovaAccesses = new ArrayList<>();
    @Field
    public List<VPN> vpnAccesses = new ArrayList<>();

    public Acces(Client cid) {
        this.id = UUID.randomUUID().toString();
        this.cid = cid;
        this.insertDate = LocalDateTime.from(LocalDate.now().atTime(LocalTime.now()));;
    }


    public List<VPN> getVpnAccesses() {
        return vpnAccesses;
    }

    public void setVpnAccesses(List<VPN> vpnAccesses) {
        this.setModyfyDate();
        this.vpnAccesses = vpnAccesses;
    }

    public List<Enova> getEnovaAccesses() {
        return enovaAccesses;
    }

    public void setEnovaAccesses(List<Enova> enovaAccesses) {
        this.setModyfyDate();
        this.enovaAccesses = enovaAccesses;
    }

    public String getId() {
        return id;
    }

    public Client getCid() {
        return cid;
    }

    public void setCid(Client cid) {
        this.setModyfyDate();
        this.cid = cid;
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

    public List<TeamViewer> getTvAccesses() {
        return tvAccesses;
    }

    public void setTvAccesses(List<TeamViewer> tvAccesses) {
        this.setModyfyDate();
        this.tvAccesses = tvAccesses;
    }

    public List<AnyDesk> getAdAccesses() {
        return adAccesses;
    }

    public void setAdAccesses(List<AnyDesk> adAccesses) {
        this.setModyfyDate();
        this.adAccesses = adAccesses;
    }

    public List<RDP> getRdpAccesses() {
        return rdpAccesses;
    }

    public void setRdpAccesses(List<RDP> rdpAccesses) {
        this.setModyfyDate();
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
