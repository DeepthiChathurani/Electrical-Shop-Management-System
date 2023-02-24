package lk.ijse.electricalshop.dao.custom;

import lk.ijse.electricalshop.dao.CrudDAO;
import lk.ijse.electricalshop.dao.SuperDAO;
import lk.ijse.electricalshop.entity.Employee;

public interface EmployeeDAO extends CrudDAO<Employee,String>, SuperDAO {

}
