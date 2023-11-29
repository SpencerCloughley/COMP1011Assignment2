package com.example.comp1011assignment2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class NowPlayingListViewController implements Initializable {
    @FXML
    private TableColumn<Movie, LocalDate> dateColumn;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn<Movie, Double> popularityColumn;

    @FXML
    private TableColumn<Movie, Integer> rankColumn;

    @FXML
    private TableView<Movie> tableView;

    @FXML
    private TableColumn<Movie, String> titleColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            NowPlaying nowPlaying = APIUtility.callNowPlaying();
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
            popularityColumn.setCellValueFactory(new PropertyValueFactory<>("popularity"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

            tableView.getItems().addAll(nowPlaying.getResults());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
