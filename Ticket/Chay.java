package Ticket;

public class Chay {
    public static void main(String[] args) {
        Cuahang m = new Cuahang();
        NguoiMua s1 = new NguoiMua(m);
        NguoiMua s2 = new NguoiMua(m);
        NguoiMua s3 = new NguoiMua(m);
        Nguoiban k = new Nguoiban(m);

        s1.start();
        s2.start();
        s3.start();
        k.start();
    }
}
