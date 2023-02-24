package lk.ijse.electricalshop.dao;

import lk.ijse.electricalshop.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {

    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,EMPLOYEE,ITEM,ORDER,ORDERDETAIL,PAYMENT,SUPPLIER,SUPPLIERDETAIL
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER:
                return (SuperDAO) new CustomerDAOImpl();
            case EMPLOYEE:
                return (SuperDAO) new EmployeeDAOImpl();
            case ITEM:
                return (SuperDAO) new ItemDAOImpl();
            case ORDER:
                return (SuperDAO) new OrderDAOImpl();
            case ORDERDETAIL:
                return (SuperDAO) new OrderDetailDAOImpl();
            case PAYMENT:
                return (SuperDAO) new PaymentDAOImpl();
            case SUPPLIER:
                return (SuperDAO) new SupplierDAOImpl();
            case SUPPLIERDETAIL:
                return (SuperDAO) new SupplierDetailDAOImpl();
        }
        return null;
    }
}
