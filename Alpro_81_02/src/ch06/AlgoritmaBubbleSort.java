package ch06;

    public class AlgoritmaBubbleSort {
        public static void main(String[] args) {

            int[] Narray = {82, 12, 41, 38, 19, 26, 9, 48, 20, 55, 8, 32, 3};
            
            for(int i = 0; i < Narray.length; i++){
                for(int j = 0; j < Narray.length-1; j++){
                    boolean baris = Narray [j] < Narray [j+1];

            if(baris){
            int x = Narray[j];
            Narray[j] = Narray[j+1];
            Narray[j+1] = x;
                }
            }       
        }       

        System.out.print("Hasil Mengurutkan Array dengan Bubble Sort= ");
        for(int i = 0; i < Narray.length; i++){
            System.out.print(Narray[i]+ " ");   
        } 
        System.out.println("");      
    }
}