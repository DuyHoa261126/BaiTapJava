package Ticket;

import java.util.concurrent.atomic.AtomicInteger;

public class Ketnoi {
    private AtomicInteger dem = new AtomicInteger(0);
    private static volatile Ketnoi ketnoi = null;

    private Ketnoi() {}

    public int getDem() {
        return dem.get();
    }

    public void setDem(int dem) {
        this.dem.set(dem);
    }

    public static synchronized Ketnoi Dongbo() {
        if (ketnoi == null) {
            ketnoi = new Ketnoi();
        }
        return ketnoi;
    }
}
