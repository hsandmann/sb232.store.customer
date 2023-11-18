package store.customer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@Accessors(chain = true, fluent = true)
public class Customer {

    private String id;
    private String name;
    private Date birthdate;
    private String cpf;
    private String email;
    private String password;
    private String hashPassword;
    
}
