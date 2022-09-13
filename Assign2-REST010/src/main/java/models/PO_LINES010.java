package models;

import javax.persistence.*;

@Entity(name = "PO_LINES010")
@Table(name = "PO_LINES010")
@NamedNativeQuery(name = "PO_LINES010.findByPo",
        query = "SELECT * FROM po_lines010 WHERE (po_no010 =:poNo010)",
        resultClass = PO_LINES010.class)
public class PO_LINES010 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lineNo010")
    private int lineNo010;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poNo010")
    private POs010 po;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partNo010")
    private Parts010 part;

    @Column(name = "linePrice010")
    private float linePrice010;

    public PO_LINES010() {}

    public int getLineNo010() {
        return lineNo010;
    }

    public void setLineNo010(int lineNo010) {
        this.lineNo010 = lineNo010;
    }

    public Parts010 getPart() {
        return part;
    }

    public void setPart(Parts010 part) {
        this.part = part;
    }

    public float getLinePrice010() {
        return linePrice010;
    }

    public void setLinePrice010(float linePrice010) {
        this.linePrice010 = linePrice010;
    }

    public POs010 getPo() {
        return po;
    }

    public void setPo(POs010 po) {
        this.po = po;
    }
}
