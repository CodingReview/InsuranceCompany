package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_clients")
public class Client implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "phone", nullable = false, length = 30)
    private String phone;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "statusDate", length = 10)
    private Date statusDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Contract> contract;

    public Client() {

    }

    public Client(String surname, String name, String phone, String address, Date statusDate) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.statusDate = statusDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void setContract(List<Contract> basket) {
        this.contract = basket;
    }

    @Override
    public String toString() {
        return "Клиент: " + this.getSurname() + " " + this.getName();
    }
}
