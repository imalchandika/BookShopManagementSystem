package lk.ijse.dep.BookShop.business.custom.impl;

import lk.ijse.dep.BookShop.business.Converter;
import lk.ijse.dep.BookShop.business.custom.CustomerBO;
import lk.ijse.dep.BookShop.dao.DAOFactory;
import lk.ijse.dep.BookShop.dao.custom.CustomerDAO;
import lk.ijse.dep.BookShop.dto.CustomerDTO;


import java.util.List;

public class CustomerBOimpl implements CustomerBO {
    CustomerDAO customerDAO;
    public CustomerBOimpl(){
        customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }

    @Override
    public List<CustomerDTO> getCustomers() throws Exception {
        return Converter.getDTOList(customerDAO.findAll());
    }

    @Override
    public boolean createCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.save(Converter.getEntity(dto));

    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteCustomer(String customerID) throws Exception {
        return customerDAO.delete(customerID);
    }

    @Override
    public CustomerDTO findCustomer(String id) throws Exception {
        return Converter.getDTO(customerDAO.find(id));
    }
}
