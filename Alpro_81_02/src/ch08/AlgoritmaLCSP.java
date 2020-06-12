package ch08;

public class AlgoritmaLCSP {
    public static String lcsp (String String1, String String2) {

        int aku = String1.length();
        int kamu = String2.length();
        int[][]length = new int[aku+1][kamu+1];
        int max = 0;
        int min = 0;

        for(int i = 0; i < aku; i++) {
            for(int j = 0; j < kamu; j++) {
                if( i == 0 || j == 0){
                    length[i][j] = 0;
                }

                else if(String1.charAt(i-1)==String2.charAt(j-1)){
                    length[i][j] = length[i-1][j-1]+1;
                    max = Math.max(max, length[i][j]);
                    min = i;
                }

                else {

                    length[i][j] =0;
                }
            }
        }

        return String1.substring(min-max+1, min+1);
    }

    public static void main(String[] args) {
        System.out.println(lcsp("Kita Bisa","Kami Bisa"));

        System.out.println("");
    }   
}