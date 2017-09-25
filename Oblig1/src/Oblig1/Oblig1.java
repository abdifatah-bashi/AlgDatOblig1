
package Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;


public class Oblig1 {

    public static void main(String[] args) {

        int[] tempArray = new int[]{5, -2, 11, 3, -4, 22, 1, 4, 9};

        char[] character = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] cha = new char[]{'A', 'B', 'C', 'D'};
        String t = flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");

        //String tt = flettStringTabell("OD", "LE", "AA" ,"VV");

        System.out.println(t);

        int[] e = {8, 9, 2, 10, 5, 6, 1, 7, 3, 4};

        int[] a = new int[]{1, 3, 3, 5, 5, 5, 6,};

        int[] f = {1, 8, 9, 2, 10, 5, 6, 3, 7, 4};

        int[] b = new int[]{1, 2, 3, 4, 5, 6};

        int[] c = new int[]{-4, -1, 3, 0, 2, -3, -2, 4, 1};

        int[] d = new int[]{2, 5, 8, 4, 3, 10, 1, 7, 6, 9};
        rotasjon(character, -2);
        //delsortering(b);
        //SortAsc(d,0,d.length);
        printChar(character);
        //print(e);

        // min(e);

        //print(e);

        // System.out.println(modus1(a));

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

        int sistindex = inputArray.length - 1;

        for (int i = sistindex; i > 0; i--) {

            if (inputArray[i] < inputArray[i - 1]) {

                bytt(inputArray, i - 1, i);

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

        int sistindex = inputArray.length - 1;

        for (int i = sistindex; i > 0; i--) {

            if (inputArray[i] < inputArray[i - 1]) {

                bytt(inputArray, i - 1, i);

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

            for (int j = i + 1; j < inputArray.length; j++) {

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
        try {
            int left = 0;
            int right = inputArray.length - 1;
            int oddIndex = OddetallTeller(inputArray);

//        int odd=0;
//        for(int k=0; k<inputArray.length-1; k++){
//            if(inputArray[k]%2!=0){odd++;}
//        }
            while (left <= right) {

                if (Math.abs(inputArray[left]) % 2 != 0) {

                    left++;

                } else if (Math.abs(inputArray[left]) % 2 == 0) {

                    bytt(inputArray, left, right);

                    right--;

                }
            }

            quickSort(inputArray, 0, oddIndex - 1);
            quickSort(inputArray, oddIndex, inputArray.length - 1);
        } catch (Exception e) {
            System.out.println("Tabellen er tom..");
        }

    }

    public static int OddetallTeller(int[] a) {
        int odd = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                odd++;
            }

        }
        return odd;
    }

    public static void SortAsc(int[] inputArray, int start, int end) {
        if (inputArray.length < 1) {
            throw new NoSuchElementException("Tabellen er tom!");
        }
        for (int i = start; i < end; i++) {

            for (int j = i + 1; j < end; j++) {

                if (inputArray[i] > inputArray[j]) {
                    bytt(inputArray, i, j);

                }
            }


        }
    }


    /*

    Oppgave 5.

   Den metoden roteres  elementene i en tabell.

   En rotasjon på én enhet gjøres ved at det siste elementet blir det første og alle de andre forskyves én enhet mot høyre

     */
    public static void rotasjon(char[] arr) {
        try {
            char temp = arr[arr.length - 1];

            for (int i = arr.length - 1; i > 0; i--) {

                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        } catch (Exception e) {
            System.out.println();
        }
    }



    /*

    Oppgave 6

    Rotering, mer generelt


    /*

    Generelt rotasjonsmetode som roterer tabell elementene k enhet mot høyre eller venstre.

     Hvis k > 1 roteres det mot venstre ellers mot høyre.

     */

    /*

     */

    public static void rotasjon(char[]arr, int k){
        int n = arr.length;
        if (n < 2) return;  //her sjekkes om tabellen er tom eller inneholder bare et element.

        if ((k %= n) < 0) k += n;

        if (k <= (n+1)/2)
        {
            char[] b = Arrays.copyOfRange(arr, n - k, n);
            for (int i = n - 1; i >= k; i--) arr[i] = arr[i - k];
            System.arraycopy(b, 0, arr, 0, k);
        }
        else
        {
            char[] b = Arrays.copyOfRange(arr, 0, n - k);
            for (int i = 0; i < k; i++) arr[i] = arr[i + n - k];
            System.arraycopy(b, 0, arr, k, n - k);
        }
    }

//    public static void rotasjon(char[] arr, int k) {
//        try {
//            if (k < 1) {
//                for (int i = 0; i < Math.abs(k); i++) høyreRotasjon(arr);
//            } else {
//                for (int i = 0; i < k; i++) {
//                    venstreRotasjon(arr);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println();
//        }
//    }
//
//    public static void høyreRotasjon(char arr[]) {
//
//        char temp = arr[0];
//
//        for (int i = 1; i <= arr.length - 1; i++) {
//
//            arr[i - 1] = arr[i];
//        }
//        arr[arr.length - 1] = temp;
//
//
//    }
//
//    public static void venstreRotasjon(char[] arr) {
//        try {
//            char temp = arr[arr.length - 1];
//
//            for (int i = arr.length - 1; i > 0; i--) {
//
//                arr[i] = arr[i - 1];
//            }
//            arr[0] = temp;
//        } catch (Exception e) {
//            System.out.println();
//        }
//    }

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

            //int j = i + 1;

            if (inputArray[i] > inputArray[i + 1]) return false;


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