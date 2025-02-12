package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteVehicleViewController {


    @FXML
    private TextField txtID;

    @FXML
    void VehicleDElete(ActionEvent event) {
        String id = txtID.getText();

        try {
            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");


            //create a connection with database server and database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle","root","10661");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from vehicle where vid=?");
            preparedStatement.setObject(1,id);



           int i = preparedStatement.executeUpdate();
            if (i > 0) {
                // Success Alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Vehicle Deleted Successfully!");
                alert.showAndWait();
            } else {
                // Failure Alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete vehicle. Please check the ID and try again.");
                alert.showAndWait();
            }
//            if (i > 0) {
//                System.out.println("Vehicle Deleted Successfully");
//            }else{
//                System.out.println("failed");
//            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
