package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlgoritmaBMSS {

    public void AlgoritmaBMSS (String aku, String kamu) {

        char[]txt = aku.toCharArray();
        char[]path = kamu.toCharArray();
        int kita = indeks(txt,path);
        if(kita == -1) {
            System.out.println("Gak ada Perbandingan");
        }
        else {
            System.out.println("Path di Posisi Ke : "+kita);
        }
    }

    public int indeks(char[]txt,char[]path) {
        if (path.length == 0)
            return 0;
        int charTabel[] = makeCharTabel(path);
        int offsetTabel[] = makeOffsetTabel(path);
        for (int i = path.length - 1, j; i < txt.length;){
            for (j = path.length - 1; path[j] == txt[i]; --i, --j)
                if (j == 0)
                return i;
            i += Math.max(offsetTabel[path.length - 1 - j], charTabel[txt[i]]);
        }
        return -1;
        }
            private int[]makeCharTabel(char[]path){
            final int jumlahAlpahbet = 256;
            int[]tabel = new int[jumlahAlpahbet];

                 for(int i = 0; i < tabel.length; i++)
                     tabel[i]=path.length;

                 for (int i = 0; i < path.length-1; ++i)
                    tabel[path[i]]=path.length-1-i;
                    return tabel;
    }
    private static int[]makeOffsetTabel(char[]path) {

        int[]tabel = new int[path.length];
        int posisiTerakhir = path.length;
            for(int i = path.length-1; i >= 0; --i){
            if(awalan(path, i+1))
            posisiTerakhir = i+1;
            tabel[path.length-1-i]=posisiTerakhir-i+path.length-1;
        }
        for(int i = 0; i < path.length-1; ++i){
            int slen = akhiran(path,i);
            tabel[slen] = path.length-1-i+slen;
        }
        return tabel;
    }

    private static boolean awalan(char[]path, int kamu){
        for(int i = kamu, j = 0; i < path.length; ++i, ++j)
            if(path[i]!=path[j])
            return false;
            return true;
    }
    
    private static int akhiran(char[]path, int kamu){
        int len = 0;
        for(int i = kamu, j = path.length-1; i >= 0 && path[i]==path[j];--i,--j)
        len += 1;
        return  len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Algoritma Boyer Moore String Search ( BMSS )");
        System.out.println("Input Teks");
        String txt = input.readLine();
        System.out.println("Input Path");
        String path = input.readLine();
        AlgoritmaBMSS bm = new AlgoritmaBMSS();
        bm.AlgoritmaBMSS(txt,path);

        System.out.println("");
    }    
}