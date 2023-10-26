package store.product;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@NoArgsConstructor
public class CustomerModel {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "hashpassword")
    private String hashPassword;

    public CustomerModel(Customer o) {
        this.id = o.id();
        this.name = o.name();
        this.birthDate = o.birthdate();
        this.cpf = o.cpf();
        this.email = o.email();
        this.hashPassword = o.hashPassword();
    }

    public Customer to() {
        return Customer.builder()
            .id(this.id)
            .name(this.name)
            .birthdate(this.birthDate)
            .cpf(this.cpf)
            .email(this.email)
            .hashPassword(this.hashPassword)
            .build();
    }

}
