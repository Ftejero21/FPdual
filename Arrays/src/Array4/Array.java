package Array4;

public class Array {

    public Array(){

    }

    public int [] comprobar(int [] numero){
        int[] res = new int [numero.length];

        for (int i = 0; i < numero.length; i++) {
            res[i] = numero[numero.length -1 -i];
        }

        return res;
    }
}
