package store.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import feign.Param;

public interface CustomerRepository extends CrudRepository<CustomerModel, String> {

    @Query("SELECT c from CustomerModel c where lower(c.email) = lower(:email) and c.hashPassword = :hash")
    Optional<CustomerModel> findFirstByEmailHash(@Param("email") String email, @Param("hash") String hash);
    
}
