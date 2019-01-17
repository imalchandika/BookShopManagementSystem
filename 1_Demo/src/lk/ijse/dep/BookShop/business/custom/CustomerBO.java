package lk.ijse.dep.BookShop.business.custom;

import lk.ijse.dep.BookShop.business.SuperBO;
import lk.ijse.dep.BookShop.dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBO {
    List<CustomerDTO> getCustomers() throws Exception;

    boolean createCustomer(CustomerDTO dto) throws Exception;

    boolean updateCustomer(CustomerDTO dto) throws Exception;

    boolean deleteCustomer(String memberID) throws Exception;

    CustomerDTO findCustomer(String id) throws Exception;
}
