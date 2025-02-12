package lk.acpt.demofx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadViewController implements Initializable {

    public ArrayList<Vehicles> DataLoad() {

        try {
            //load the installed driver to this class
            Class.forName("com.mysql.cj.jdbc.Driver");


            //create a connection with database server and database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "10661");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from  vehicle");


            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Vehicles> list = new ArrayList();

            while (resultSet.next()) {
                Vehicles vehicle = new Vehicles();

                vehicle.setId(resultSet.getInt(1));
                vehicle.setBrand(resultSet.getString(2));
                vehicle.setPrice(resultSet.getDouble(3));
                vehicle.setModel(resultSet.getString(4));
                vehicle.setNoOfGears(resultSet.getInt(5));

                list.add(vehicle);
            }
            return list;


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private TableView<Vehicles> tabaleView;

    @FXML
    void load(ActionEvent event) {

        tabaleView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tabaleView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tabaleView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tabaleView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfGears"));
        tabaleView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<Vehicles> list = DataLoad();


        tabaleView.setItems(FXCollections.observableArrayList(list));


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabaleView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tabaleView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tabaleView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tabaleView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("noOfGears"));
        tabaleView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<Vehicles> list = DataLoad();


        tabaleView.setItems(FXCollections.observableArrayList(list));
    }
}
