package ra.api.service;

import ra.api.model.dto.request.CustomerAddDto;
import ra.api.model.dto.request.CustomerUpdateDto;
import ra.api.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    Customer getCustomersById(Long id);
    Customer addCustomer(CustomerAddDto request);
    Customer updateCustomer(CustomerUpdateDto request, Long id);
    void deleteCustomer(Long id);
}
