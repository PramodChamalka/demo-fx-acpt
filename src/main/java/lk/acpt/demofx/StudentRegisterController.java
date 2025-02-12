package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StudentRegisterController {

    Student[] students = new Student[10];
    int index=0;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    void save(ActionEvent event) {

        String name = txtName.getText();
        int id = Integer.parseInt(txtId.getText());
        int age = Integer.parseInt(txtAge.getText());
        String address = txtAddress.getText();

        Student std = new Student(name,id,age,address);
        students[index] = std;
        index++;

        System.out.println(std.getName());
        System.out.println(std.getId());
        System.out.println(std.getAge());
        System.out.println(std.getAddress());
    }

}
