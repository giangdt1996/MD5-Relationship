//package ra.service.mapper;
//
//import org.springframework.stereotype.Component;
//import ra.ss5spingboot.model.domain.Customer;
//import ra.ss5spingboot.model.dto.request.CustomerRequest;
//import ra.ss5spingboot.model.dto.response.CustomerResponse;
//import ra.ss5spingboot.service.IGenericMapper;
//
//@Component
//public class CustomerMapper implements IGenericMapper<Customer, CustomerRequest, CustomerResponse> {
//
//    @Override
//    public Customer toEntity(CustomerRequest customerRequest) {
//        return Customer.builder().fullName(customerRequest.getFullName())
//                .email(customerRequest.getEmail())
//                .phoneNumber(customerRequest.getPhoneNumber())
//                .age(customerRequest.getAge()).sex(customerRequest.isSex()).build();
//    }
//
//    @Override
//    public CustomerResponse toResponse(Customer customer) {
//        return CustomerResponse.builder().id(customer.getId())
//                .fullName(customer.getFullName())
//                .email(customer.getEmail())
//                .phoneNumber(customer.getPhoneNumber())
//                .age(customer.getAge())
//                .sex(customer.isSex()).build();
//
//    }
//}
