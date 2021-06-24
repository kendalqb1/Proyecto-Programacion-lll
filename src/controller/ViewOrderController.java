package controller;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DAO.FactureDao;
import model.Facture;
import model.FactureRecovery;
import model.decorator.Beverage;
import view.Ventanas;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewOrderController {

    Ventanas v = new Ventanas();
    FactureDao fdao = new FactureDao();
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField filterField;

    @FXML
    private TableView<FactureRecovery> tableOrders;

    @FXML
    private TableColumn<FactureRecovery, String> columnID;

    @FXML
    private TableColumn<FactureRecovery, String> columnClient;

    @FXML
    private TableColumn<FactureRecovery, String> columnBeverages;

    @FXML
    private TableColumn<FactureRecovery, String> columnState;

    @FXML
    private TableColumn<FactureRecovery, String> columnDate;

    @FXML
    private TableColumn<FactureRecovery, Double> columnTotal;


    @FXML
    void initialize() throws SQLException {
        tableOrders.getItems().clear();
        columnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        columnClient.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        columnBeverages.setCellValueFactory(new PropertyValueFactory<>("arrayBeverages"));
        columnState.setCellValueFactory(new PropertyValueFactory<>("stateOrder"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnTotal.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        ResultSet result = fdao.read();
        while (result.next()) {
            tableOrders.getItems().add(new FactureRecovery(
                    result.getString("id"),
                    result.getString("cliente"),
                    result.getString("contenido"),
                    result.getString("estado"),
                    result.getString("fecha"),
                    Double.parseDouble( result.getString("costo"))
            ));
        }
//        FilteredList<FactureRecovery> filteredData = new FilteredList<>(tableOrders.getItems(), p->true);
//        filterField.textProperty().addListener((observable, oldValue, newValue)-> {
//            filteredData.setPredicate(factureRecovery -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowerCase = newValue.toLowerCase();
//                return factureRecovery.getStateOrder().toLowerCase().contains(lowerCase);
//            });
//        });
//        SortedList<FactureRecovery> sortedData =  new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(tableOrders.comparatorProperty());
//        tableOrders.setItems(sortedData);
    }

    @FXML
    void changeState() throws SQLException {
        FactureRecovery f = orderSelect();
        if (f.getStateOrder().equals("Completada")) {
            //TODO: CREAR VENTANA
            System.out.println("Completada");
        }
        if(f.getStateOrder().equals("En proceso")) {
            f.setStateOrder("Completada");
            fdao.update(f);
        }
        if(f.getStateOrder().equals("Pendiente")) {
            f.setStateOrder("En proceso");
            fdao.update(f);
        }

        initialize();
    }

    @FXML
    void saveOrders() {

    }

    @FXML
    void goToMenu() {
        v.crearVentana("Menu.fxml", "Main Menu");
        ((Stage) anchorPane.getScene().getWindow()).close();
    }


    FactureRecovery orderSelect() {
        for (int i = 0; i < tableOrders.getItems().size(); i++) {
            if(tableOrders.getSelectionModel().isSelected(i)){
                return tableOrders.getItems().get(i);
            }
        }
        return null;
    }
}
