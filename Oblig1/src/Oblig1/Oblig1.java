package Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by Bashi, Abdifatah Ali on 18.09.2017.
 */
public class Oblig1 {
    public static void main(String[] args) {
        int[] tempArray = new int[]{5, -2, 11, 3, -4, 22,1, 4,9};
        char[] character = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        String t = flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");
        //String tt = flettStringTabell("OD", "LE", "AA" ,"VV");
        System.out.println(t);
        int[] e = {8,9,2,10,5,6,1,7,3,4};
        int []a = new int[] {1,3,3,5, 5,5,6,};
        int[] f = {1,8,9,2,10,5,6,3,7,4};
       int [] b = new int[] {1,2,3,4,5};
        int []c = new int[] {4, 9, 3, 6, 1, -5, 7, 8, 10, 2};
        int []d = new int[] {2, 5, 8, 4, 3, 10, 1, 7, 6, 9};
       //print(e);
       // min(e);
       //print(e);
        System.out.println(modus1(a));

//        System.out.println("Verdien som ligger i første plass er_ " +e[0]);
//        System.out.println("");
//        System.out.println(ombyttinger(b));
//        System.out.println(ombyttinger(c));
//        System.out.println(ombyttinger(d));
//
//        System.out.println(minV2(c));

        // print(tempArray);
        //System.out.println();
        //  rotateNumber(tempArray);
        // print(tempArray);
        //System.out.println();
        //rotation(character, 3);
        //printChar(character);
        // System.out.println();


//        delsortering(tempArray);
//        print(tempArray);
        // System.out.println("");

        // selectionSort(tempArray);
        // quickSort(tempArray, 0, tempArray.length-1);

        //String b = flett("IJKLMN","OPQ");
        //String c = flett("","AB");
        //System.out.println(a + " " + b + " " + c);

//        String []temp = {"AFH", "BAH", "DT", "IA"};
//        flettStringTabell(temp);
        //tidsSortering(randPerm(100000));
        //modus(tempArray);

        // print(oddArray(tempArray));

        //  System.out.println(modus(tempArray));

        // System.out.println("Antall byttinger er: " + ombyttinger(randomArray(6)));

        //print(randomArray(5));
        // ombyttinger(randomArray(6));

    }


    /*
    Oppgave 1.
  Her finner vi mninst verdien av en tabell.
   */
    public static int min(int[] inputArray) {
        if (inputArray.length < 1) {
            throw new NoSuchElementException("Tabellen er tom!");
        }
        int sistindex=inputArray.length-1 ;
        for (int i = sistindex; i > 0 ; i--) {

                if (inputArray[i] < inputArray[i-1]) {
                    bytt(inputArray, i-1, i);
                }


            }

        return inputArray[0];
    }



    /*
   Metode som beregner antall ombyttinger som blir gjort.
     */

    public static int ombyttinger(int[] inputArray) {
        int antall = 0;
        if (inputArray.length < 1) {
            throw new NoSuchElementException("Tabellen er tom!");
        }
        int sistindex=inputArray.length-1 ;
        for (int i = sistindex; i > 0 ; i--) {

            if (inputArray[i] < inputArray[i-1]) {
                bytt(inputArray, i-1, i);
                antall++;
            }


        }
        return antall;
    }



    /*
    Oppgave 2
     */

    // Metode som finner modus tallet dvs. tallet som forekommer ofte.
    public static int modus1(int[] inputArray) {
        if (inputArray.length < 1 || !erSortert(inputArray)) {
            throw new IllegalStateException("Tabellen er tom eller ikke-sortert ");
        }
        int modus = inputArray[0];
        int maks = 0;
        for (int i = 0; i < inputArray.length; i++) {
            int verdi = inputArray[i];
            int antall = 0;
            for (int j = i+1; j < inputArray.length; j++) {
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
    Modus mer generelt.
     */

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
 Den metoden skal dele parametertabellen a i to sorterte deler.
 Venstre del skal inneholde oddetallene sortert og høyre del partallene sortert.


  */
    public static void delsortering(int[] inputArray) {
        int left = 0;
        int right = inputArray.length - 1;
        while (left < right) {

            if (Math.abs(inputArray[left]) % 2 != 0 && left < right) {
                left++;
            } else if (Math.abs(inputArray[left]) % 2 == 0 && left  < right) {
                bytt(inputArray, left, right);
                right--;
            }


        }

        quickSort(inputArray, 0, right);
        quickSort(inputArray, right , inputArray.length - 1);


    }

    public static int minV2(int [] inputArray) {

        int min = 0;
        int minVerdi = inputArray[min];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < minVerdi) {
                min = i;
                bytt(inputArray, i, min);
                inputArray[i]= inputArray[i-1];
            }


        }
        return inputArray[min];
    }









    /*
    Oppgave 5.
   Den metoden roteres  elementene i en tabell.
   En rotasjon på én enhet gjøres ved at det siste elementet blir det første og alle de andre forskyves én enhet mot høyre
     */

    public static void rotasjon(char[] arr) {
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
    Rotering, mer generelt
     */

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
    public static void rotasjon(char arr[], int k) {
        if (k < 1) {
            for (int i = 0; i > k; i--) {
                rightRotation(arr);

            }
        }
        for (int i = 0; i < k; i++) {
            rotasjon(arr);

        }

    }
    /*
    Oppgave 7.
    Den skal «flette» sammen tegnstrengene s og t slik at resultatet blir en tegnstreng der annethvert tegn kommer fra s og annethvert fra t.
    Hvis s og t har ulik lengde, skal det som er «til overs» legges inn bakerst.
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

    public static String flett(String... s) {
        String resultat = "";
        int longest = longestString(s);
        for (int i = 0; i < longest; i++) {
            for (int j = 0; j < s.length; j++) {
                if (i < s[j].length())
                    resultat += s[j].charAt(i);

            }


        }

        return resultat;
    }

    public static int longestString(String... s) {
        int length = 0;
        for (int i = 0; i < s.length; i++) {
            if (length < s[i].length()) {
                length = s[i].length();
            }

        }
        return length;

    }





    /*
    Her samles  det alle hjelpe metode som vi bruker her i klassen.
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
    Kvikksorterings metode. Vi bruker den som hjelpemetode i oppgave 4.
     */
    public static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pp = partition(a, start, end);
            quickSort(a, start, pp - 1);
            quickSort(a, pp + 1, end);

        }
    }

    public static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {

            if (a[j] <= pivot) {
                i++;

                bytt(a, i, j);
            }
        }

        bytt(a, i + 1, end);
        return i + 1;
    }




    /*
    Hjlepemetode som genererer random tabell elementer.
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

    /*
    Meotde som generer og permuterer random array elementer
     */

    public static int[] randPerm(int n) {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k
            bytt(a, k, i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }


}
