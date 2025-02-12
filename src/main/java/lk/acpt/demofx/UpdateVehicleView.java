package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;

public class UpdateVehicleView {

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtNoOfGears;

    @FXML
    private TextField txtPrice;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

        int id = Integer.parseInt(txtID.getText());

        try {
            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");


            //create a connection with database server and database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle","root","10661");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from  vehicle where vid = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                txtBrand.setText(resultSet.getString(2));
                txtModel.setText(resultSet.getString(3));
                txtPrice.setText(resultSet.getString(4));
                txtNoOfGears.setText(resultSet.getString(5));

            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void update(ActionEvent event) {
        int id = Integer.parseInt(txtID.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int noOfGears = Integer.parseInt(txtNoOfGears.getText());
        double price = Double.parseDouble(txtPrice.getText());

        try {
            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");


            //create a connection with database server and database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle","root","10661");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE vehicle SET brand = ?, model = ?, price = ?, noOfGears = ? WHERE vid = ?");

            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, price);
            preparedStatement.setObject(4,noOfGears);
            preparedStatement.setObject(5,id);



            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Vehicle Updated..");
            }else{
                System.out.println("failed");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
