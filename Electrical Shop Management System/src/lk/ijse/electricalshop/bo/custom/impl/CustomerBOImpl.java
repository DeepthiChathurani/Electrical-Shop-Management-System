package lk.ijse.electricalshop.bo.custom.impl;

import lk.ijse.electricalshop.bo.custom.CustomerBO;
import lk.ijse.electricalshop.dao.DAOFactory;
import lk.ijse.electricalshop.dao.custom.CustomerDAO;
import lk.ijse.electricalshop.dto.Customer;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new lk.ijse.electricalshop.entity.Customer(customer.getCusId(),customer.getName(),
                customer.getAddress(),customer.getEmail(),customer.getContact_num(),customer.geteId()));
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    public void addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        customerDAO.add(new lk.ijse.electricalshop.entity.Customer(customer.getCusId(),customer.getName(),
                customer.getAddress(),customer.getEmail(),customer.getContact_num(),customer.geteId()));
    }
}
