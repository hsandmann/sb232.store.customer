package store.product;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, String> {
    
}
