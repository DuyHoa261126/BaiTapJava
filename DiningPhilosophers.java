package BT5ThuyetGia;

import java.util.concurrent.locks.ReentrantLock;

class Chopstick {
    private final ReentrantLock lock = new ReentrantLock();

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}

class Philosopher extends Thread {
    private final int id;
    private final Chopstick left, right;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    private void think() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang nghĩ.");
        Thread.sleep((long)(Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang ăn.");
        Thread.sleep((long)(Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                // Tránh deadlock: triết gia cuối cùng lấy đũa theo thứ tự ngược
                if (id % 2 == 0) {
                    left.pickUp();
                    right.pickUp();
                } else {
                    right.pickUp();
                    left.pickUp();
                }

                eat();

                left.putDown();
                right.putDown();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int N = 5;
        Chopstick[] chopsticks = new Chopstick[N];
        Philosopher[] philosophers = new Philosopher[N];

        for (int i = 0; i < N; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < N; i++) {
            Chopstick left = chopsticks[i];
            Chopstick right = chopsticks[(i + 1) % N];
            philosophers[i] = new Philosopher(i, left, right);
            philosophers[i].start();
        }
    }
}

