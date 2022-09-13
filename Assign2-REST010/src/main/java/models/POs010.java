package models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "POs010")
@Table(name = "POs010")
@NamedNativeQuery(name = "POs010.findByClientCompId010",
        query = "SELECT * FROM pos010 WHERE (client_comp_id010=:clientCompId010)",
        resultClass = POs010.class)
@NamedNativeQuery(name = "POs010.findByPoNo010AndClientCompId010",
        query = "SELECT * FROM pos010 WHERE (client_comp_id010=:clientCompId010 AND po_no010=:poNo010)",
        resultClass = POs010.class)
@NamedStoredProcedureQuery(name = "POs010.createPo010",
procedureName = "POST_NEW_ORDER_CLIENT", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "clientCompId010", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "partNo010", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "poNo010", type = Integer.class)
})
@NamedStoredProcedureQuery(name = "POs010.createPoTest010",
procedureName = "POST_NEW_ORDER_TEST", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "newOrderInput", type = String.class)
})
@NamedStoredProcedureQuery(name = "POs010.updatePoStatus010",
procedureName = "UPDATE_PO_STATUS_AGENT", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "status010", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "poNo010", type = Integer.class)
})
@NamedStoredProcedureQuery(name = "POs010.cancelPo010",
        procedureName = "CANCEL_PO_CLIENT", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "poNo010", type = Integer.class)
})
public class POs010 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "poNo010")
    private int poNo010;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientCompId010")
    private ClientUser010 clientUser;

    @Column(name = "datePO010")
    private Date datePO010;

    @Column(name = "status010")
    private String status010;

    public POs010() {}

    public int getPoNo010() {
        return poNo010;
    }

    public void setPoNo010(int poNo010) {
        this.poNo010 = poNo010;
    }

    public Date getDatePO010() {
        return datePO010;
    }

    public void setDatePO010(Date datePO010) {
        this.datePO010 = datePO010;
    }

    public String getStatus010() {
        return status010;
    }

    public void setStatus010(String status010) {
        this.status010 = status010;
    }

    public ClientUser010 getClientUser() {
        return clientUser;
    }

    public void setClientUser(ClientUser010 clientUser) {
        this.clientUser = clientUser;
    }
}
