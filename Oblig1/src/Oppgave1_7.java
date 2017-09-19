import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by Bashi, Abdifatah Ali on 18.09.2017.
 */
public class Oppgave1_7 {
    public static void main(String[] args) {
        int[] tempArray = new int[]{1, 2, 3, 4};
        char[] character = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
       // print(tempArray);
        //System.out.println();
        //  rotateNumber(tempArray);
        // print(tempArray);
        //System.out.println();
        //rotation(character, 3);
        //printChar(character);
       // System.out.println();


        //String b = flett("IJKLMN","OPQ");
        //String c = flett("","AB");
        //System.out.println(a + " " + b + " " + c);

//        String []temp = {"AFH", "BAH", "DT", "IA"};
//        flettStringTabell(temp);
        tidsSortering(randPerm(100000));
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
    public static void  flettStringTabell(String []s) {
        String resultat = "";
        for (int i = 0; i < s[i].substring(i).length(); i++) {
            for (int j = 0; j <s[i].substring(j).length(); j++) {
                resultat+= s[j].charAt(i);

            }







        }
        System.out.printf("" + resultat);
    }



/*
Oppgave 8
 */

public static void tidsSortering(int[] array) {
    //Beregner tiden utvalgssortering tok
    long startTid1 = System.currentTimeMillis();
    //print(array);
    selectionSort(array);
    long tidsForskjell1 = System.currentTimeMillis() - startTid1;
    System.out.println("utvalgssorteringen tok: " + tidsForskjell1);

    //Beregner tiden Insertingssortering tok

    long startTid2= System.currentTimeMillis();
    insertionSort(array);
    long tidsForskjell2 = System.currentTimeMillis() - startTid2;
    System.out.println("Insertingssortering tok: " + tidsForskjell2);

    //Beregner tiden kvikkSoterings tok
    /*long startTid3= System.currentTimeMillis();
    quickSort(array, 0, array.length-1);
    long tidsForskjell3 = System.currentTimeMillis()- startTid3;
    System.out.println("Insertingssortering tok: " + tidsForskjell3);
*/



}

/*
Her finnes det ulike sorterings alogrithmer
 */

// Utvalgssortering(Selection Sort)

    public static int [] selectionSort(int []array){
        int minVerdi= array[0];
        for (int i = 0; i <array.length ; i++) {
            int min= i;
            for (int j = i+1; j <array.length ; j++) {
                if(array[j] < array[min]){
                    min = j;

                }

            }

            bytt(array, i , min );

        }

        return array;
    }


    // Insertingssortering (Insertion sort)

    public static int [] insertionSort(int [] array ){
        for (int i = 0; i <array.length ; i++) {
            int element = array[i];
            int j= i-1;
            while(j >= 0 &&  array[j] > element){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = element;

        }
        return array;

    }

    //Kvikksortering
    public static void quickSort(int []a, int start, int end){
        if(start < end){
            int pp = partition(a, start, end);
            quickSort(a, start, pp-1);
            quickSort(a, pp+1, end);

        }
    }

    public static int partition(int []a, int start, int end) {
        int pivot = a[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {

            if (a[j] <= pivot) {
                i++;
                //Swappping the values of i and j
                int ival = a[i];
                int jval = a[j];
                a[i] = jval;
                a[j] = ival;

            }
        }

        return i+1;

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

    /*
    Meotde som generer og permuterer random array elementer
     */

    public static int[] randPerm(int n)  // en effektiv versjon
    {
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
