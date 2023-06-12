import java.util.ArrayList;
import java.util.List;
 class Fibonacci {
    interface Callback {
        void sucesion(Integer suces);
    }
    void generar(int cantidad, Callback callback){
        List<Integer> sucesion = new ArrayList<>();
        sucesion.add(0);
        sucesion.add(1);
        for (int i = 2; i < cantidad-2; i++) {
            sucesion.add(sucesion.get(i-2) + sucesion.get(i-1));
        }


        for(Integer su : sucesion){
            callback.sucesion(su);
        }
    }
}
public class E1_JoseMiguelIzarra {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.generar(10, new Fibonacci.Callback() {
            @Override
            public void sucesion(Integer suces) {
                System.out.println(suces);
            }
        });

    }
}