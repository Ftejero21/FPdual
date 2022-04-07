package Array1;

public class Array {
    public Array(){

    }

    public  boolean Comprueba(int [] numero){
        boolean res;
        if (numero[0] == 3 || numero[5] == 6) {
            res = true;
        }else{
            res = false;
        }
        return res;


    }
}
