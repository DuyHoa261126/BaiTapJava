package Ticket;

public class Cuahang {
    private final int maxN = 20;
    private final int[] ve;
    private int n;

    public Cuahang() {
        n = 0;
        ve = new int[maxN];
    }

    public synchronized void mua(int soluong) {
        if (n + soluong > maxN) {
            System.out.println("Không đủ vé để mua!");
            return;
        }

        for (int i = 0; i < soluong; i++) {
            n++;
            ve[n - 1] = n;
            System.out.println("Vé số " + n + " đã được mua.");
        }

        Ketnoi.Dongbo().setDem(n);
    }

    public synchronized void sanXuat() {
        int k = Ketnoi.Dongbo().getDem();
        System.out.println("Sản xuất lại vé, số lượng: " + k);
    }
}
