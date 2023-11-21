package store.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController()
public class CustomerResource implements CustomerController {

    @Autowired
    private CustomerService customerService;

    @Override
    public List<CustomerOut> list() {
        return customerService.list().stream().map(CustomerParser::to).toList();
    }

    @Override
    public CustomerOut get(@PathVariable(required = true) String id) {
        Customer found = customerService.find(id);
        return found == null ? null : CustomerParser.to(found);
    }

    @Override
    public void delete(@PathVariable(required = true) String id) {
        customerService.delete(id);
    }

    @Override
    public ResponseEntity<Object> create(@RequestBody CustomertIn in) {
        return ResponseEntity.created(
                    ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(customerService.create(CustomerParser.to(in)).id())
                        .toUri())
                    .build();
    }

    @Override
    public CustomerOut login(@RequestBody CustomertIn in) {
        if (in.email() == null || in.email().trim().length() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email is missing");
        if (in.password() == null || in.password().trim().length() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password is missing");
        return CustomerParser.to(customerService.findBy(in.email(), in.password()));
    }

}
