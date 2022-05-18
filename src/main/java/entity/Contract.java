package entity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_contracts")
public class Contract implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateConclusion", length = 10)
    private Date dateConclusion;

    @Column(name = "insuranceAmount", length = 15)
    private double insuranceAmount;

    @Temporal(TemporalType.DATE)
    @Column(name = "statusDate", length = 10)
    private Date statusDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAgent", nullable = false)
    private Agent agent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypeInsurance", nullable = false)
    private TypeInsurance typeInsurance;

    public Contract() {

    }

    public Contract(Date dateConclusion, double insuranceAmount, Date statusDate, Client client, Agent agent, TypeInsurance typeInsurance) {
        this.dateConclusion = dateConclusion;
        this.insuranceAmount = insuranceAmount;
        this.statusDate = statusDate;
        this.client = client;
        this.agent = agent;
        this.typeInsurance = typeInsurance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateConclusion() {
        return dateConclusion;
    }

    public void setDateConclusion(Date dateConclusion) {
        this.dateConclusion = dateConclusion;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public TypeInsurance getTypeInsurance() {
        return typeInsurance;
    }

    public void setTypeInsurance(TypeInsurance typeInsurance) {
        this.typeInsurance = typeInsurance;
    }
}
