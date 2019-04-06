package caro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CaroPresenter {

    private static CaroView caroView;

    public CaroPresenter(CaroView caroView) {
        this.caroView = caroView;
        jbinit();
        allAction();
    }

    public void allAction() {
        caroView.addMnuKhoiTaoActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CaroPresenter.this.jbinit();
            }
        });
        caroView.addMnuThoatActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CaroPresenter.this.dispose();
            }
        });
        caroView.addMnuRobotActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (CaroPresenter.caroView.getMnuRobot().getText().equals("Chọn chơi với máy")) {
                    CaroPresenter.caroView.getMnuRobot().setText("Đang chơi với máy");
                    CaroPresenter.caroView.getMnuRobot().setForeground(new Color(54, 200, 200));
                    CaroPresenter.caroView.getPanel().setRobot(true);
                } else {
                    CaroPresenter.caroView.getMnuRobot().setText("Chọn chơi với máy");
                    CaroPresenter.caroView.getMnuRobot().setForeground(new Color(222, 37, 208));
                    CaroPresenter.caroView.getPanel().setRobot(false);
                }
            }
        });
        caroView.addMouseActionListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                CaroPresenter.this.doVe(e.getX(), e.getY());
            }
        });
    }

    public void jbinit() {
        caroView.getPanel().restartImage();
        if (caroView.getPanel().getXanhDo() == 1) {
            caroView.getMnuXanhDo().setText("Xanh đi");
            caroView.getMnuXanhDo().setForeground(Color.BLUE);
        } else {
            caroView.getMnuXanhDo().setText("Đỏ đi");
            caroView.getMnuXanhDo().setForeground(Color.RED);
        }
        repaint();
    }

    public void show() {
        caroView.show();
    }

    public void dispose() {
        caroView.dispose();
    }

    public void repaint() {
        caroView.repaint();
    }

    public void doVe(int x, int y) {
        int bool = caroView.getPanel().draw(x, y);
        if (caroView.getPanel().getXanhDo() == 1) {
            caroView.getMnuXanhDo().setText("Xanh đi");
            caroView.getMnuXanhDo().setForeground(Color.BLUE);
        } else {
            caroView.getMnuXanhDo().setText("Đỏ đi");
            caroView.getMnuXanhDo().setForeground(Color.RED);
        }
        repaint();
        if (bool == 1) {
            JOptionPane.showMessageDialog(null, "Xanh thắng");
            repaint();
        } else if (bool == 2) {
            JOptionPane.showMessageDialog(null, "Đỏ thắng");
            repaint();
        }
    }
}
