package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_type_insurances")
public class TypeInsurance implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "typeInsurance", nullable = false, length = 30)
    private String typeInsurance;

    @Temporal(TemporalType.DATE)
    @Column(name = "statusDate", length = 10)
    private Date statusDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Contract> contract;

    public TypeInsurance() {

    }

    public TypeInsurance(String typeInsurance, Date statusDate) {
        this.typeInsurance = typeInsurance;
        this.statusDate = statusDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeInsurance() {
        return typeInsurance;
    }

    public void setTypeInsurance(String typeInsurance) {
        this.typeInsurance = typeInsurance;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Тип страхования: " + this.getTypeInsurance();
    }
}
