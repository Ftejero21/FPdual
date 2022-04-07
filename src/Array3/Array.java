package Array3;

public class Array {

    public Array(){

    }

    public int[] comprobar(int [] numero){

        int  res [] = new int[2];
        if (numero.length % 2 == 0) {
            int pos = 0;
            int posCentral = numero.length / 2;

            for (int i = posCentral; i <= posCentral + 1; i++) {
                res[pos] = posCentral;
                pos++;
            }

        }



        return res;

    }
}
