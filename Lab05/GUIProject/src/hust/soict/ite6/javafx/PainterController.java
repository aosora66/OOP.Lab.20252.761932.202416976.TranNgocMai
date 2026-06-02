package hust.soict.ite6.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    // Khai báo thêm 2 biến ánh xạ từ FXML
    @FXML
    private RadioButton penRadio;

    @FXML
    private RadioButton eraserRadio;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color drawColor = Color.BLACK;

        // Kiểm tra nếu nút Tẩy (Eraser) đang được chọn thì đổi màu mực thành Trắng
        if (eraserRadio.isSelected()) {
            drawColor = Color.WHITE;
        }

        // Vẽ một hình tròn tại vị trí con trỏ chuột với màu tương ứng
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, drawColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

}
