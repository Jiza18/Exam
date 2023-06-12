import java.util.Observer;
import java.util.concurrent.Executors;
class MeaningOfLife {

    Observer observer;

     interface Observer{
        void onAnswer(int answer);
    }

    MeaningOfLife(){

        Executors.newSingleThreadExecutor().submit(() -> {
            while(true) {
                System.out.println("Calculating the meaning of life...");
                answer(observer);
            }
        });
    }
    void setObserver(Observer observer){
        this.observer = observer;
    }
    public void answer(Observer observer){
        observer.onAnswer(42);
    }
}
public class E5_JoseMiguelIzarra {
    public static void main(String[] args) {
        MeaningOfLife meaningOfLife = new MeaningOfLife();
        meaningOfLife.setObserver(new MeaningOfLife.Observer(){
            @Override
            public void onAnswer(int answer) {
                System.out.println(answer);
            }
        });
    }
}