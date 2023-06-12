import java.util.Random;
import java.util.Scanner;
abstract class Screen {

    static Screen factory (String title){
        if(title.equals("C")){
            return new CreateScreen();
        } else if (title.equals("R")) {
            return new ReadScreen();
        } else if (title.equals("U")) {
            return new UpdateScreen();
        }else {
            return new DeleteScreen();
        }
    }

    void show(){
        System.out.println("****** " + title() + " *******");
    }
    abstract String title();
}
class CreateScreen extends Screen {
    String title() {
        return "CREATE";
    }
}
class ReadScreen extends Screen {
    String title() {
        return "READ";
    }
}
class UpdateScreen extends Screen {
    String title() {
        return "UPDATE";
    }
}
class DeleteScreen extends Screen {
    String title() {
        return "DELETE";
    }
}
public class E3_JoseMiguelIzarra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(String.valueOf("CRUD".charAt(new
                Random().nextInt(4))));
        String action = scanner.next();



        Screen screen = Screen.factory(action);

        screen.show();
    }
}