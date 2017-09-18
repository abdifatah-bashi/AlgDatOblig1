import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by Bashi, Abdifatah Ali on 18.09.2017.
 */
public class Oppgave1_7 {
    public static void main(String[] args) {
        int[] tempArray = new int[]{66, 5, 33, -2, 33, 1, 33, 6};

        // print(tempArray);
        // min(tempArray);



       //modus(tempArray);

      // print(oddArray(tempArray));





      //  System.out.println(modus(tempArray));

        // System.out.println("Antall byttinger er: " + ombyttinger(randomArray(6)));

        //print(randomArray(5));
        // ombyttinger(randomArray(6));

    }


    /*
    Oppgave 1
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
    Hvor mange ombyttinger vi gjør.
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
    Meotde som bytter plass til to elementer.
     */

    public static void bytt(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }

    /*
    Helpe metode som printer ut verdiene til array
     */

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" | " + array[i]);
        }
    }
    //Metode som genererer random tabell elementer.


    public static int[] randomArray(int n) {
        int[] tempArray = new int[n];
        Random r = new Random();
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = r.nextInt(9);

        }
        return tempArray;
    }
    /*
    Oppgave 2
     */

    // Metode som finner modus tallet dvs. tallet som forekommer ofte.
    public static int modus(int[] inputArray) {
      if(inputArray.length < 1 || !erSortert(inputArray)){
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
    //Modus versjon 2
    public static int modus2(int[] inputArray) {
        if(inputArray.length < 1){
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
    //Metode som sjkeker at tabellen er sortert i stigende rekkefølge.
    public static boolean erSortert(int [] inputArray){
        for (int i = 0; i <inputArray.length-1 ; i++) {
            int j=i+1;
            if(inputArray[i] > inputArray[j]) return false;

        }
        return true;
    }





   /*
   Oppgave 4.
Sitter fast med oppgave 4.

 */
   public static int [] delSortering(int [] inputArray ){
       int [] tempArray = new int [inputArray.length];
       return tempArray;
   }





}
