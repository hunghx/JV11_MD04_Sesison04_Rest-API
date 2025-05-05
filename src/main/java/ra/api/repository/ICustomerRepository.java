package ra.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.api.model.entity.Customer;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query("FROM Customer")
    List<Customer> findAll();
}
