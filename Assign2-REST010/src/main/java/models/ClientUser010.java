package models;

import javax.persistence.*;

@Entity(name = "ClientUser010")
@Table(name = "ClientUser010")
@NamedStoredProcedureQuery(name = "client_user010.updateClient010",
        procedureName = "UPDATE_USER_AGENT", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "clientCompName010", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "clientCity010", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "moneyOwed010", type = Float.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "clientCompPassword010", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "clientCompId010", type = Integer.class)})

public class ClientUser010 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "clientCompId010")
    private int clientCompId010;

    @Column(name = "clientCompName010")
    private String clientCompName010;

    @Column(name = "clientCity010")
    private String clientCity010;

    @Column(name = "clientCompPassword010")
    private String clientCompPassword010;

    @Column(name = "moneyOwed010")
    private float moneyOwed010;

    public ClientUser010() {}

    public int getClientCompId010() {
        return clientCompId010;
    }

    public void setClientCompId010(int clientCompId010) {
        this.clientCompId010 = clientCompId010;
    }

    public String getClientCompName010() {
        return clientCompName010;
    }

    public void setClientCompName010(String clientCompName010) {
        this.clientCompName010 = clientCompName010;
    }

    public String getClientCity010() {
        return clientCity010;
    }

    public void setClientCity010(String clientCity010) {
        this.clientCity010 = clientCity010;
    }

    public String getClientCompPassword010() {
        return clientCompPassword010;
    }

    public void setClientCompPassword010(String clientCompPassword010) {
        this.clientCompPassword010 = clientCompPassword010;
    }

    public float getMoneyOwed010() {
        return moneyOwed010;
    }

    public void setMoneyOwed010(float moneyOwed010) {
        this.moneyOwed010 = moneyOwed010;
    }
}
