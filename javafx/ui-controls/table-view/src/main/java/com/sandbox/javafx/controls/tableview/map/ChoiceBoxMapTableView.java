package com.sandbox.javafx.controls.tableview.map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * <div>
 * Created with IntelliJ IDEA.
 * User: Jian-Min Gao <br>
 * Date: 2015/11/16 <br>
 * Time: 10:22 <br>
 * </div>
 */
public class ChoiceBoxMapTableView extends Application {
    public static final String Column1MapKey = "A";
    public static final String Column2MapKey = "B";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(300);
        stage.setHeight(500);

        final Label label = new Label("Student IDs");
        label.setFont(new Font("Arial", 20));

        TableColumn<Map, String> firstDataColumn = new TableColumn<>("Configuration Key");
        TableColumn<Map, Integer> secondDataColumn = new TableColumn<>("Value");

        firstDataColumn.setCellValueFactory(new MapValueFactory<>(Column1MapKey));
        firstDataColumn.setMinWidth(130);
        secondDataColumn.setCellValueFactory(new MapValueFactory<>(Column2MapKey));
        secondDataColumn.setMinWidth(130);

        TableView tableView = new TableView<>(generateDataInMap());

        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getColumns().setAll(firstDataColumn, secondDataColumn);

        //first column cell factory
        firstDataColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        secondDataColumn.setCellFactory(param -> {
            ObservableList<Integer> values = FXCollections.observableArrayList();
            for (int i = 0; i < 20; i++) {
                values.add(i);
            }
            return new ChoiceBoxTableCell<>(values);
        });

        final VBox vbox = new VBox();

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);

        stage.show();
    }

    private ObservableList<Map> generateDataInMap() {
        int max = 10;
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for (int i = 1; i <= max; i++) {
            Map<String, Object> dataRow = new HashMap<>();

            String value1 = "A" + i;
            dataRow.put(Column1MapKey, value1);
            dataRow.put(Column2MapKey, i);

            allData.add(dataRow);
        }
        return allData;
    }
}
