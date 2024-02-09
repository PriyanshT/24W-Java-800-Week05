package org.georgiancollege.week05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CreateBookController implements Initializable {

    @FXML
    private TextField authorTextField;

    @FXML
    private CheckBox availabilityCheckBox;

    @FXML
    private TextField bookNameTextField;

    @FXML
    private Label finalLabel;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private TextField priceTextBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am in the initialize function.");

        // hide the final label
        finalLabel.setVisible(false);

        // add data to genre combo box
        genreComboBox.getItems().addAll(Book.findGenres());
    }

    @FXML
    void saveBook(ActionEvent event) {
        System.out.println("Button Clicked!");

        // un-hide the final label
        finalLabel.setVisible(true);

        try {
            // get user data and store it in variables
            String bookName = bookNameTextField.getText();
            String author = authorTextField.getText();
            String genre = genreComboBox.getSelectionModel().getSelectedItem();
            double price = Double.parseDouble(priceTextBox.getText());
            boolean availability = availabilityCheckBox.isSelected();

            // initialize a book object and pass the values to the constructor
            Book book = new Book(1, bookName, author, genre, price, availability);
            finalLabel.setText(book.toString());
        } catch (Exception e){
            finalLabel.setText(e.getMessage());
        }
    }

}

