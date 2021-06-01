package view;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;

public class Dialog {
    public Alert createConfirmationDialog(String content) {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setTitle("Confirmation");
        dialog.initStyle(StageStyle.DECORATED);
        dialog.setHeaderText(null);
        dialog.setContentText(content);
        return dialog;
    }

    public Alert createInformationDialog(String content) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Information");
        dialog.initStyle(StageStyle.DECORATED);
        dialog.setHeaderText(null);
        dialog.setContentText(content);
        return dialog;
    }

    public Alert createErrorDialog(String content) {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.initStyle(StageStyle.DECORATED);
        dialog.setHeaderText(null);
        dialog.setContentText(content);
        return dialog;
    }

    public TextInputDialog createInputDialog(String title, String content) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.initStyle(StageStyle.DECORATED);
        dialog.setHeaderText(null);
        dialog.setContentText(content);
        return dialog;
    }
}
