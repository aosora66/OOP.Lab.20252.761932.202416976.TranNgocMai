package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.media.Playable;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.Media;

import javax.swing.event.ChangeListener;

public class CartScreenController {
    private Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private javafx.scene.control.TextField tfFilter;

    @FXML
    private javafx.scene.control.RadioButton radioBtnFilterId;

    @FXML
    private javafx.scene.control.RadioButton radioBtnFilterTitle;

    @FXML private javafx.scene.control.Label lblTotalCost;
    @FXML private javafx.scene.control.Button btnPlaceOrder;

    // Hàm khởi tạo nhận vào đối tượng Giỏ hàng
    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
        );

        tfFilter.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showFilteredMedia(newValue);
                }
        );

        lblTotalCost.setText(cart.totalCost() + " $");

        // Lắng nghe sự thay đổi của ObservableList (khi thêm/xóa sản phẩm)
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener.Change<? extends Media> c) -> {
            lblTotalCost.setText(cart.totalCost() + " $");
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    // === XỬ LÝ SỰ KIỆN NÚT REMOVE ===
    @FXML
    void btnRemovePressed(ActionEvent event) {
        // Lấy ra sản phẩm đang được chọn trên bảng
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        // Gọi hàm xóa sản phẩm khỏi giỏ hàng
        if (media != null) {
            this.cart.removeMedia(media);
        }
    }

    // === XỬ LÝ LỌC DỮ LIỆU ===
    private void showFilteredMedia(String filter) {

        if (filter == null || filter.trim().isEmpty()) {
            tblMedia.setItems(this.cart.getItemsOrdered());
            return;
        }

        String filterString = filter.toLowerCase();

        javafx.collections.transformation.FilteredList<Media> filteredList =
                new javafx.collections.transformation.FilteredList<>(this.cart.getItemsOrdered(), media -> {
                    // Nếu chọn lọc theo Title
                    if (radioBtnFilterTitle.isSelected()) {
                        return media.getTitle().toLowerCase().contains(filterString);
                    }
                    // Nếu chọn lọc theo ID
                    else if (radioBtnFilterId.isSelected()) {
                        return String.valueOf(media.getId()).contains(filterString);
                    }
                    return true;
                });

        tblMedia.setItems(filteredList);
    }

    // Xử lý khi bấm nút Place Order
    @FXML
    void btnPlaceOrderPressed(javafx.event.ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        System.out.println("Order created! Total cost: " + cart.totalCost() + " $");
        cart.getItemsOrdered().clear(); // Xóa sạch giỏ hàng sau khi đặt
    }

    // === XỬ LÝ SỰ KIỆN NÚT PLAY ===
    @FXML
    void btnPlayPressed(javafx.event.ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof hust.soict.ite6.aims.media.Playable) {
            try {
                ((hust.soict.ite6.aims.media.Playable) media).play();

                // Hiện thông báo phát thành công bằng Alert của JavaFX
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
                alert.setTitle("AIMS Media Player");
                alert.setHeaderText("Now Playing: " + media.getTitle());
                alert.showAndWait();

            } catch (Exception e) {
                e.printStackTrace();

                // Hiện hộp thoại Lỗi bằng Alert của JavaFX
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("Illegal DVD Length");
                alert.setHeaderText("Error: DVD Length is non-positive");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }
}