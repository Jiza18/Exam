import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import static java.util.stream.IntStream.range;
class Badge {
    int count;
    public static Badge INSTANCIA;

    static synchronized Badge getInstance(){
        if(INSTANCIA==null){
            INSTANCIA=new Badge();
        }
        return INSTANCIA;
    }
    synchronized void show() {
        System.out.println("("+count+")");
    }
    synchronized void increment() {
        count++;
    }
}
public class E4_JoseMiguelIzarra {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<Void>> tasks = range(0,
                10).mapToObj((IntFunction<Callable<Void>>) i -> () -> {
            Badge badge = Badge.getInstance();
            badge.increment();
            badge.show();
            return null;
        }).collect(Collectors.toList());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(tasks);
        executorService.shutdown();
    }
}