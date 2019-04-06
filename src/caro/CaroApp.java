package caro;

public class CaroApp {

    public static void main(String[] args) {
        CaroPresenter caroPresenter = new CaroPresenter(new CaroWindow());
        caroPresenter.show();
    }
}
