package ra.api.service;

import org.springframework.data.domain.Page;
import ra.api.model.dto.request.CustomerAddDto;
import ra.api.model.dto.request.CustomerUpdateDto;
import ra.api.model.dto.response.PageDto;
import ra.api.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    PageDto<Customer> getCustomersPagination(int page, int size);
    Customer getCustomersById(Long id);
    Customer addCustomer(CustomerAddDto request);
    Customer updateCustomer(CustomerUpdateDto request, Long id);
    void deleteCustomer(Long id);
}
