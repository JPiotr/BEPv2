package wsei.project.BEP.entityes.Access;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Document("acceses")
public class Access {
    @Id
    private String id;
    @Field
    private LocalDateTime insertDate;
    @Field
    public LocalDateTime modifyDate;
    @Field
    protected List<TeamViewer> tvAccesses = new ArrayList<>();
    @Field
    protected List<AnyDesk> adAccesses = new ArrayList<>();
    @Field
    protected List<RDP> rdpAccesses = new ArrayList<>();
    @Field
    protected List<Enova> enovaAccesses = new ArrayList<>();
    @Field
    protected List<VPN> vpnAccesses = new ArrayList<>();
    @Field
    public Integer accessesCount = 0;

    public Access() {
        this.id = UUID.randomUUID().toString();
        this.insertDate = LocalDateTime.from(LocalDate.now().atTime(LocalTime.now()));;
    }
    public void setAccessesCount(){
        this.accessesCount = this.adAccesses.size() +
                this.tvAccesses.size() +
                this.rdpAccesses.size() +
                this.enovaAccesses.size() +
                this.vpnAccesses.size();
    }
    public Integer getAccessesCount(){
        return this.accessesCount;
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

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModyfyDate() {
        this.setAccessesCount();
        this.modifyDate = LocalDateTime.from(LocalDate.now().atTime(LocalTime.now()));
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
        return "Access{" +
                "id='" + id + '\'' +
                ", insertDate=" + insertDate +
                ", modyfyDate=" + modifyDate +
                ", tvAccesses=" + tvAccesses +
                ", adAccesses=" + adAccesses +
                ", rdpAccesses=" + rdpAccesses +
                '}';
    }
}
