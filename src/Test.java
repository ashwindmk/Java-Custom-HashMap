/**
 * Created by ashwin on 24/8/17.
 */
public class Test {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>(25);

        map.put(0, "Alice");
        map.put(1, "Brenda");
        map.put(2, "Carrie");
        map.put(10, "Katy");
        map.put(2, "Caesy");
        map.put(25, "Zara");
        map.put(25, "Zetah");
        map.put(25, "Zeenat");

        System.out.println("25: " + map.remove(25) + " removed");

        System.out.println("0: " + map.get(0));

        System.out.println(map);
    }

}
