import java.util.Random;
import java.util.Scanner;

public class antriBankCrc {
    public static int ukuran;
    public static int[] queue;
    public static int front = -1;
    public static int rear = -1;
    public static int maxSize;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        maxSize = 10;
        queue = new int[maxSize];
        Random random = new Random();
        boolean aktif = true;
        while (aktif) {
            System.out.println("\n\nSistem Antri Nasabah Bank AI (maks 10 antrian)");
            System.out.println("___________________________\n1.Ambil Nomor Antrian\n2.Panggil Nomor Antrian\n3.Tampilkan Semua Nomor Antrian\n4.Keluar");
            int pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    int antriRandom = random.nextInt(99);
                    if (isFull()) {
                        System.out.println("Antrian penuh!");
                    } else {
                        enqueue(antriRandom);
                        System.out.println("Nomor yang diberikan adalah " + antriRandom);
                    }
                    break;
                case 2:
                    if (isEmpty()) {
                        System.out.println("Antrian kosong!");
                    } else {
                        System.out.println("PANGGILAN KEPADA NOMOR ANTRIAN " + dequeue() + "!!");
                    }
                    break;
                case 3:
                    displayQueue();
                    break;
                case 4:
                    aktif = false;
                    break;
                default:
                    System.out.println("Maaf, Inputan anda tidak dikenali!!");
                    break;
            }
        }
    }

    public static boolean isEmpty() {
        return front == -1;
    }

    public static boolean isFull() {
        return (front == 0 && rear == maxSize - 1) || (front == rear + 1);
    }

    public static void enqueue(int item) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == maxSize - 1) {
            rear = 0;
        } else {
            rear++;
        }
        queue[rear] = item;
    }

    public static int dequeue() {
        int item = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == maxSize - 1) {
            front = 0;
        } else {
            front++;
        }
        return item;
    }

    public static void displayQueue() {
        int i;
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Antrian dari depan ke belakang:");
        if (front <= rear) {
            for (i = front; i <= rear; i++) {
                System.out.println("Antrian ke-" + (i - front + 1) + " adalah Nomor Antrian " + queue[i]);
            }
        } else {
            for (i = front; i < maxSize; i++) {
                System.out.println("Antrian ke-" + (i - front + 1) + " adalah Nomor Antrian " + queue[i]);
            }
            for (i = 0; i <= rear; i++) {
                System.out.println("Antrian ke-" + (i - front + 1 + maxSize) + " adalah Nomor Antrian " + queue[i]);
            }
        }
    }
}
