package ch06;

public class  AlgoritmaSelectionSort {
    public static void main(String[] args) {

        int[] Narray = {82, 12, 41, 38, 19, 26, 9, 48, 20, 55, 8, 32, 3};
        for(int i = 0; i < Narray.length-1; i++){
            int x = i;
            for(int j = i; j < Narray.length; j++){
                boolean urutan = Narray[j] < Narray[x];
                if(urutan){
                x = j;
                }
            }
            int y = Narray[i];
            Narray[i] = Narray[x];
            Narray[x] = y;
        }
        cetak(Narray);
    }

    public static void cetak(int[] Narray) {
        System.out.print("Hasil Mengurutkan Array dengan Selection Sort= ");
        for(int i = 0; i < Narray.length; i++) {
            System.out.print(Narray[i]+ " ");
        } 
        System.out.println("");      
    }   
}