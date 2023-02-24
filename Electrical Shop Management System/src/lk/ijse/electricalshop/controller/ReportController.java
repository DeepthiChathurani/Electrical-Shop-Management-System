package lk.ijse.electricalshop.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.electricalshop.db.DBConnection;
import lk.ijse.electricalshop.util.Navigation;
import lk.ijse.electricalshop.util.Routes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportController {
    public AnchorPane ancReport;

    public void btnItemDetails(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/electricalshop/report/ItemReport.jrxml");

        HashMap<String,Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.
                    fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException | ClassNotFoundException | JRException e) {
            throw new RuntimeException(e);

        }

    }

    public void btnBack(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.ADMIN, ancReport);
    }

    public void btnOrdersDetails(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/electricalshop/report/Orders Report.jrxml");

        HashMap<String,Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.
                    fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException | ClassNotFoundException | JRException e) {
            throw new RuntimeException(e);

        }

    }

    public void btnSupplierDetails(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/electricalshop/report/SuppliersReport.jrxml");

        HashMap<String,Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.
                    fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);
        } catch (SQLException | ClassNotFoundException | JRException e) {
            throw new RuntimeException(e);

        }
    }
}
