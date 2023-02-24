package lk.ijse.electricalshop.bo;

import lk.ijse.electricalshop.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {

    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOTypes{
        CUSTOMER,EMPLOYEE,ITEM,PLACEORDER,SUPPLIERPAYMENT
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return (SuperBO) new CustomerBOImpl();
            case EMPLOYEE:
                return (SuperBO) new EmployeeBOImpl();
            case ITEM:
                return (SuperBO) new ItemBOImpl();
            case PLACEORDER:
                return (SuperBO) new PlaceOrderBOImpl();
            case SUPPLIERPAYMENT:
                return (SuperBO) new SupplierPaymentBOImpl();
        }
        return null;
    }
}
