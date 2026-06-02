package hust.soict.ite6.aims.screen; // Đảm bảo đúng package của dự án bạn

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.ite6.aims.exception.LimitExceededException;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Playable;
import hust.soict.ite6.aims.cart.Cart;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart; // Thuộc tính lưu trữ giỏ hàng để tương tác dữ liệu

    // Cập nhật hàm khởi tạo nhận thêm đối tượng Cart
    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tiêu đề sản phẩm
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Giá tiền
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel chứa các nút bấm
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // 1. Xử lý nút "Add to cart"
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gọi hàm addMedia từ file Cart.java của bạn
                try {
                    cart.addMedia(media);
                } catch (LimitExceededException ex) {
                    throw new RuntimeException(ex);
                }

                // Hiển thị hộp thoại JDialog thông báo thành công trực quan
                JOptionPane.showMessageDialog(null,
                        "Added \"" + media.getTitle() + "\" to cart!",
                        "Cart Update",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        container.add(addToCartButton);

        // 2. Xử lý nút "Play" (Chỉ xuất hiện nếu Media implements Playable)
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Ép kiểu sang Playable và GỌI HÀM play() THỰC SỰ ĐỂ BẮT LỖI
                        ((Playable) media).play();

                        // Nếu không có lỗi (thời lượng > 0), hiển thị thông báo đang phát
                        String msg = "Playing Media: " + media.getTitle() + "\n"
                                + "Category: " + media.getCategory() + "\n"
                                + "Cost: " + media.getCost() + " $";

                        JOptionPane.showMessageDialog(null, msg, "AIMS Media Player", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception ex) {
                        // Bắt PlayerException (ở đây dùng Exception chung để an toàn nếu cậu chưa import kịp)
                        ex.printStackTrace(); // In chi tiết lỗi ra Console theo yêu cầu tài liệu

                        // Hiển thị hộp thoại lỗi (Error Dialog) màu đỏ
                        JOptionPane.showMessageDialog(null,
                                ex.getMessage(),
                                "Illegal DVD Length",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(playButton);
        }

        // Bố cục sắp xếp giao diện ô sản phẩm
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}