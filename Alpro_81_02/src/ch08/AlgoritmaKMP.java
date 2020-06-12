package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlgoritmaKMP {

    private int[] gagal;
    public AlgoritmaKMP(String txt, String pat) {

        gagal = new int[pat.length()];
        fail(pat);

        int aku = akuPerbandingan(txt, pat);
        if (aku == -1)
            System.out.println("Gak ada Perbandingan");
        else
            System.out.println("Perbandingan Terletak di Indeks-"+aku);
    }

    private void fail(String pat) {
        int pertama = pat.length();
        gagal[0] = -1;
        for(int i = 1; i < pertama; i++) {

            int j = gagal[i-1];
            while((pat.charAt(i)!= pat.charAt(j+1))&&j>=0)
                j = gagal[j];
            if(pat.charAt(i) == pat.charAt(j+1))
                gagal[i]= j+1;
            else
                gagal[i] = -1;
        }
    }

    private int akuPerbandingan(String txt, String pat){
        int j = 0;
        int i = 0;
        int lens = txt.length();
        int lenp = pat.length();
        while(j < lens && i < lenp) {
            if(txt.charAt(j)==pat.charAt(i)) {
                j++;
                i++;
            }
            else if(i == 0)
                j++;
            else
                i = gagal[i-1]+1;
        }
        return((i==lenp)?(j-lenp):-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Algoritma Knouth Mooris Pratt");
        System.out.println("Input Teks");
        String txt = input.readLine();
        System.out.println("Input Path");
        String pat = input.readLine();
        AlgoritmaKMP kmp = new AlgoritmaKMP(txt, pat);

        System.out.println("");
    }

}
