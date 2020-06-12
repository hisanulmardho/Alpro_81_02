package ch08;

public class AlgoritmaMR {

    public static int awal(int x, int y, int z) {       
        int hasil = 1;
        x = x%z;        
        while(y > 0){
            if((y&1)==1)
                hasil =(hasil*x)%z;
            y = y >> 1;
            x = (x*x)%z;
        }
        return hasil;
    }
    public static boolean test(int v, int w) {

        int pertama = 1+ (int)(Math.random()%(w-4));
        int x = awal(pertama, v, w);
        if(x == 1 || x == w-1)
            return true;
        while(v != w - 1) {
            x = (x*x)%w;
            v *= 2;
            if(x==1)
                return false;
            if (x==w-1)
                return true;
        }
        return false;
    }
    public static boolean prima(int w, int s) {

        if(w <= 1 || w == 4)
            return false;
        if(w <= 3)
            return true;
        int v = w-1;
        while(v%2==0)
                v/=2;
        for(int x = 0; x < s; x++)
            if(!test(v, w))
                return false;
                return true;
    }
    public static void main(String[] args) {

        int s = 4;
        System.out.println("Menampilkan Angka-angka Prima Dari Angka 100");
        for(int w = 1; w < 100; w++)
            if(prima(w, s))
            
            System.out.print(w+" ");
    }   
}