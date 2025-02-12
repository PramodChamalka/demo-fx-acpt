package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveVehicleViewController {

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtNoOfGear;

    @FXML
    private TextField txtPrice;

    @FXML
    void cancelData(ActionEvent event) {
    System.exit(0);

    }

    @FXML
    void saveData(ActionEvent event) {
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int noOfGear = Integer.parseInt(txtNoOfGear.getText());
        double price = Double.parseDouble(txtPrice.getText());

        try {
            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");


            //create a connection with database server and database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle","root","10661");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicle(brand,price,model,noOfGears) values(?,?,?,?)");
            preparedStatement.setString(1, brand);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, model);
            preparedStatement.setInt(4, noOfGear);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Vehicle Saved");
            }else{
                System.out.println("failed");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
