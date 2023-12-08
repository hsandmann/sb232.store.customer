package store.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class CustomerParser {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static Customer to(CustomertIn in) {
        try { 
            return in == null ? null : Customer.builder()
                .name(in.name())
                .birthdate(sdf.parse(in.birthdate()))
                .cpf(in.cpf())
                .email(in.email())
                .password(in.password())
                .build();
        } catch(ParseException e) {
            throw new RuntimeException("erro no formato da data: yyyyMMdd", e);
        }
    }

    public static CustomerOut to(Customer o) {
        return o == null ? null : new CustomerOut(
            o.id(),
            o.name(),
            sdf.format(o.birthdate()),
            o.cpf(),
            o.email()
        );
    }
    
}
