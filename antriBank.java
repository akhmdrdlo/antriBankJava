import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
public class antriBank {
    public static int ukuran;
    public static Queue<Integer>queue;
    public static Scanner input = new Scanner(System.in);

    public static void main (String args[]){
        queue = new LinkedList<>();
        Random random = new Random();
        boolean aktif = true;
        while(aktif == true){
            System.out.println("\n\nSistem Antri Nasabah Bank AI");
            System.out.println("___________________________\n1.Ambil Nomor Antrian\n2.Panggil Nomor Antrian\n3.Tampilkan Semua Nomor Antrian\n4.Keluar");
            int pilih = input.nextInt();
            switch(pilih){
                case 1:
                    int antriRandom = random.nextInt(99);
                    System.out.println("Nomor yang diberikan adalah "+antriRandom);
                    queue.add(antriRandom);
                    System.out.println("___________________________");
                    break;
                case 2:
                    System.out.println("PANGGILAN KEPADA NOMOR ANTRIAN "+queue.poll()+"!!");
                    System.out.println("___________________________");
                    break;
                case 3:
                    Iterator<Integer> iterator = queue.iterator();
                    int nomorAntrian = 1;
                    
                    while (iterator.hasNext()) {
                        System.out.println("Antrian ke-" + nomorAntrian + " adalah Nomor Antrian " + iterator.next());
                        nomorAntrian++;
                    } 
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
}
