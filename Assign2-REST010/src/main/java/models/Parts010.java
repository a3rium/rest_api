package models;

import javax.persistence.*;

@Entity(name = "Parts010")
@Table(name = "Parts010")

@NamedStoredProcedureQuery(name = "Parts010.updatePart010",
        procedureName = "UPDATE_PART_AGENT", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "partName010", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "partDescription010", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "currentPrice010", type = Float.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "currentQty010", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "partNo010", type = Integer.class)})

public class Parts010 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partNo010")
    @Id
    private int partNo010;

    @Column(name = "partName010")
    private String partName010;

    @Column(name = "partDescription010")
    private String partDescription010;

    @Column(name = "currentPrice010")
    private float currentPrice010;

    @Column(name = "qty010")
    private int qty010;

    public Parts010() {}

    public int getPartNo010() {
        return partNo010;
    }

    public void setPartNo010(int partNo010) {
        this.partNo010 = partNo010;
    }

    public String getPartName010() {
        return partName010;
    }

    public void setPartName010(String partName010) {
        this.partName010 = partName010;
    }

    public String getPartDescription010() {
        return partDescription010;
    }

    public void setPartDescription010(String partDescription010) {
        this.partDescription010 = partDescription010;
    }

    public float getCurrentPrice010() {
        return currentPrice010;
    }

    public void setCurrentPrice010(float currentPrice010) {
        this.currentPrice010 = currentPrice010;
    }

    public int getQty010() {
        return qty010;
    }

    public void setQty010(int qty010) {
        this.qty010 = qty010;
    }
}
