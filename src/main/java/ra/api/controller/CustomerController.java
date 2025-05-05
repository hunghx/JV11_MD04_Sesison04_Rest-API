package ra.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.api.model.dto.request.CustomerAddDto;
import ra.api.model.dto.request.CustomerUpdateDto;
import ra.api.model.entity.Customer;
import ra.api.service.ICustomerService;

import java.util.List;

@RestController // chú thích đây là controller trả về dữ liệu JSON
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;
    // các nhóm mã quan trọng : 2xx(200,201,204), 4xx(400, 401, 403, 404), 5xx(lỗi server , pha xử lỹ)
    // api ấy về danh sách
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
       return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }
    // api ấy về danh sách
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomersById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getCustomersById(id), HttpStatus.OK);
    }
    // api thêm mới khách hàng
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerAddDto request){
        return new ResponseEntity<>(customerService.addCustomer(request), HttpStatus.CREATED);
    }
    // api cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerUpdateDto request, @PathVariable Long id){
        return new ResponseEntity<>(customerService.updateCustomer(request, id),HttpStatus.OK);
    }
    // api xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
 }
