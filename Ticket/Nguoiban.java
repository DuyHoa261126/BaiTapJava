package Ticket;

public class Nguoiban extends Thread {
    private final Cuahang cuahang;

    public Nguoiban(Cuahang c) {
        this.cuahang = c;
    }

    public void run() {
        cuahang.sanXuat();
    }
}
