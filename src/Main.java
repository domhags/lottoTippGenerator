import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] lottozahlen = eingabeLottozahlen();
        System.out.println("Das sind Ihre Lottozahlen: " + Arrays.toString(lottozahlen));
    }

    public static int[] eingabeLottozahlen() {
        Scanner scanner = new Scanner(System.in);
        Set <Integer> eingegebeneZahlen = new HashSet<>();
        int[] lottozahlen = new int[6];
        int anzahlEingaben = 0;

        while (anzahlEingaben < 6) {
            System.out.printf("Geben Sie die %d. Zahl ein: (1-45) ", anzahlEingaben + 1);
            String eingabe = scanner.nextLine();

            try {
                int zahl = Integer.parseInt(eingabe);

                if (zahl < 1 || zahl > 45) {
                    System.out.println("Die Zahl muss zwischen 1 und 45 liegen. Wiederholen!");
                } else if (eingegebeneZahlen.contains(zahl)) {
                    System.out.println("Diese Zahl haben Sie schon. Bitte nochmals eingeben!");
                } else {
                    lottozahlen[anzahlEingaben] = zahl;
                    eingegebeneZahlen.add(zahl);
                    anzahlEingaben++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Das ist keine Zahl. Wiederholen!");
            }
        }
        Arrays.sort(lottozahlen);
        return lottozahlen;
    }
}
