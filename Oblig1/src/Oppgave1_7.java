import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by Bashi, Abdifatah Ali on 18.09.2017.
 */
public class Oppgave1_7 {
    public static void main(String[] args) {
        int[] tempArray = new int[]{1, 2, 3, 4};
        char[] character = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        print(tempArray);
        System.out.println();
        //  rotateNumber(tempArray);
        // print(tempArray);
        System.out.println();
        rotation(character, 3);
        printChar(character);
        System.out.println();

        String a = flett("ABCDFGJ", "IJ");
        //String b = flett("IJKLMN","OPQ");
        //String c = flett("","AB");
        //System.out.println(a + " " + b + " " + c);
        System.out.println(a);

        //modus(tempArray);

        // print(oddArray(tempArray));

        //  System.out.println(modus(tempArray));

        // System.out.println("Antall byttinger er: " + ombyttinger(randomArray(6)));

        //print(randomArray(5));
        // ombyttinger(randomArray(6));

    }


    /*
    Oppgave 1.
     */
    public static int min(int[] inputArray) {
        if (inputArray.length < 1) {
            throw new NoSuchElementException("Tabellen er tom!");
        }
        for (int i = 0; i < inputArray.length - 1; i++) {

            for (int j = i + 1; j < inputArray.length; j++) {

                if (inputArray[i] > inputArray[j]) {
                    bytt(inputArray, i, j);

                }
            }


        }
        return inputArray[0];
    }

    /*
   Metode som beregner antall ombyttinger som blir gjort.
     */

    public static int ombyttinger(int[] inputArray) {
        int antall = 0;

        for (int i = 0; i < inputArray.length - 1; i++) {
            int min = 0;
            for (int j = i + 1; j < inputArray.length; j++) {

                if (inputArray[i] > inputArray[j]) {
                    min = j;
                    antall++;
                    bytt(inputArray, i, j);


                }

            }


        }
        return antall;
    }



    /*
    Oppgave 2
     */

    // Metode som finner modus tallet dvs. tallet som forekommer ofte.
    public static int modus(int[] inputArray) {
        if (inputArray.length < 1 || !erSortert(inputArray)) {
            throw new IllegalStateException("Tabellen er tom eller ikke-sortert ");
        }
        int modus = inputArray[0];
        int maks = 0;
        for (int i = 0; i < inputArray.length; i++) {
            int verdi = inputArray[i];
            int antall = 0;
            for (int j = 0; j < inputArray.length; j++) {
                if (inputArray[j] == verdi) {
                    antall++;
                }
                if (antall > maks) {
                    modus = verdi;
                    maks = antall;
                }

            }

        }
        return modus;
    }

    /*
    Oppgave 3
     */
    //Modus versjon 2/generelt
    public static int modus2(int[] inputArray) {
        if (inputArray.length < 1) {
            throw new IllegalStateException("Tabellen er tom!");
        }
        int modus = inputArray[0];
        int maks = 0;
        for (int i = 0; i < inputArray.length; i++) {
            int verdi = inputArray[i];
            int antall = 0;
            for (int j = 0; j < inputArray.length; j++) {
                if (inputArray[j] == verdi) {
                    antall++;
                }
                if (antall > maks) {
                    modus = verdi;
                    maks = antall;
                }

            }

        }
        return modus;
    }


    /*
    Oppgave 4.
 Sitter fast med oppgave 4.

  */
    public static int[] delSortering(int[] inputArray) {
        int[] tempArray = new int[inputArray.length];
        return tempArray;
    }

    /*
    Oppgave 5. rotasjon av tabell på en enhet
     */
// Her roteres tabellen en enhet mot venstre.
    public static void leftRotation(char[] arr) {
        char[] tempArray = new char[arr.length];
        char temp = arr[arr.length - 1];

        for (int i = 1; i < tempArray.length; i++) {
            tempArray[i] = arr[i - 1];
        }
        tempArray[0] = temp;
        System.arraycopy(tempArray, 0, arr, 0, arr.length);

    }

    /*
    Oppgave 6
     */
    // Her roteres tabellen en enhet mot høyre.
    public static void rightRotation(char arr[]) {
        char[] tempArray = new char[arr.length];
        char temp = arr[0];

        for (int i = 0; i < tempArray.length - 1; i++) {
            tempArray[i] = arr[i + 1];
        }
        tempArray[arr.length - 1] = temp;
        System.arraycopy(tempArray, 0, arr, 0, arr.length);

    }

    /*
    Generelt rotasjonsmetode som roterer tabell elementene k enhet mot høyre eller venstre.
     Hvis k > 1 roteres det mot venstre ellers mot høyre.
     */
    public static void rotation(char arr[], int k) {
        if (k < 1) {
            for (int i = 0; i > k; i--) {
                rightRotation(arr);

            }
        }
        for (int i = 0; i < k; i++) {
            leftRotation(arr);

        }

    }
    /*
    Oppgave 7.
     */

    public static String flett(String s, String t) {
        String resultat = "";
        if (s.length() >= t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (i < t.length()) {
                    resultat += s.charAt(i);
                    resultat += t.charAt(i);
                } else resultat += s.charAt(i);

            }

        } else if (t.length() >= s.length()) {
            for (int i = 0; i < t.length(); i++) {
                if (i < s.length()) {
                    resultat += s.charAt(i);
                    resultat += t.charAt(i);
                } else
                    resultat += t.charAt(i);

            }

            return resultat;


        }

        return resultat;
    }



























    /*
    Her samles  det alle hjelpe metode som vi bruker her i klassen
     */
     /*
    Helpe metode som printer ut verdiene til en int array.
     */

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[i]);
        }
    }
/*
    Helpe metode som printer ut verdiene til en char array.
     */

    public static void printChar(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[i]);
        }
    }
    /*
    hjlepe metode som genererer random tabell elementer.
     */

    public static int[] randomArray(int n) {
        int[] tempArray = new int[n];
        Random r = new Random();
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = r.nextInt(9);

        }
        return tempArray;
    }


    //Metode som sjkeker at tabellen er sortert i stigende rekkefølge.
    public static boolean erSortert(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            int j = i + 1;
            if (inputArray[i] > inputArray[j]) return false;

        }
        return true;
    }

    /*
    Meotde som bytter plass til to elementer.
     */

    public static void bytt(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }


}
