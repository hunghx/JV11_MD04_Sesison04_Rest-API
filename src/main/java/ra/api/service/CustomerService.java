package ra.api.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ra.api.model.dto.request.CustomerAddDto;
import ra.api.model.dto.request.CustomerUpdateDto;
import ra.api.model.entity.Customer;
import ra.api.repository.ICustomerRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService{
    private final ICustomerRepository customerRepository;
    private final ModelMapper mapper;
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomersById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("ID khng tìm thấy"));
    }

    @Override
    public Customer addCustomer(CustomerAddDto request) {
//        Customer cus = new Customer(null, request.getFirstName(), ...)
        Customer cus = mapper.map(request, Customer.class); // chuyển đối gi trị thuộc tính theo tên thuộc tính
        return customerRepository.save(cus);
    }

    @Override
    public Customer updateCustomer(CustomerUpdateDto request, Long id) {
        // kiểm tra tồn tại
        customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id không tôn tại"));
        Customer cus = mapper.map(request, Customer.class);
        cus.setId(id);

        return customerRepository.save(cus);
    }

    @Override
    public void deleteCustomer(Long id) {
        // kiểm tra tồn tại
        customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id không tôn tại"));
        customerRepository.deleteById(id);
    }
}
