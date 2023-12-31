package com.example.comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NowPlayingListViewController implements Initializable {
    @FXML
    private TableColumn<Movie, LocalDate> dateColumn;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableColumn<Movie, Double> popularityColumn;

    @FXML
    private TableColumn<Movie, Integer> idColumn;

    @FXML
    private TableView<Movie> tableView;

    @FXML
    private TableColumn<Movie, String> titleColumn;
    @FXML
    private ImageView posterImageView;
    @FXML
    private HBox descriptionHBox;

    @FXML
    private Label descriptionLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        descriptionLabel.setVisible(false);
        descriptionHBox.setVisible(false);

        try {
            APIResponse apiResponse = APIUtility.callNowPlaying();
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
            popularityColumn.setCellValueFactory(new PropertyValueFactory<>("popularity"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            idColumn.setCellValueFactory(new PropertyValueFactory<>("MovieId"));

            tableView.getItems().addAll(apiResponse.getResults());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tableView.getSelectionModel().selectedItemProperty().addListener((obs,oldValue, movieSelected)->{
            if(movieSelected!=null) {
                descriptionTextArea.setText(movieSelected.getDescription());
                descriptionLabel.setVisible(true);
                descriptionHBox.setVisible(true);

                try{
                    posterImageView.setImage(new Image(movieSelected.getPoster()));
                }catch (IllegalArgumentException e){
                    posterImageView.setImage(new Image(
                            Main.class.getResourceAsStream("images/default_poster.png")));
                }
            }
        });
    }
    @FXML
    void changeToPopularView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "popular-list-view.fxml" );
    }
}
