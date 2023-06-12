import java.util.List;

class ListView {

    interface Adapter {
        default String divider(){
            return "-";
        };
        default int length(){
            return 10;
        };
        String palabra(int i);
    }

    void show(Adapter adapter){
        System.out.println(adapter.divider().repeat(adapter.length()));
        for (int i = 0; i < adapter.length(); i++) {
            System.out.println(adapter.palabra(i));
            System.out.println(adapter.divider().repeat(adapter.length()));
        }
    }
}
public class E6_JoseMiguelIzarra {
    public static void main(String[] args) {
        List<String> items = List.of("Java","Python","Javascript","C#", "C++",
                "TypeScript", "PHP");
        ListView listView = new ListView();
        listView.show(new ListView.Adapter() {
            @Override
            public String divider() {
                return "-";
            }

            @Override
            public int length() {
                return items.size();
            }

            @Override
            public String palabra(int i) {
               return items.get(i);
            }
        });
    }
}