package Array2;

public class Array {
    public int numero [];
    public int [] numero1 = {2};
    public int [] numero2 = {3};

    public Array(){

    }

    public boolean comprobacion(int [] numero){
        boolean res = true;

        for (int i = 0; i < numero.length; i++) {
            if(numero[i] == 2 || numero[i] == 3) {
                res = true;
            }else{
                res = false;
            }
        }



        return res;


    }
}
