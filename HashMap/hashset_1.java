package HashMap;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class hashset_1 {
    public static void main(String[] args) {
        HashSet<String> cities=new HashSet<>();// esma ramdom values arrange hota h
        cities.add("Delhi");
        cities.add("puna");
        cities.add("Kolkata");
        cities.add("Bokaro");
        cities.add("Whi");
//        Iterator<String>  it= cities.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

        LinkedHashSet<String> lhs=new LinkedHashSet<>();// esma jisa add kea vahe order ma add hota h
        lhs.add("Delhi");
        lhs.add("puna");
        lhs.add("Kolkata");
        lhs.add("Bokaro");
        lhs.add("Whi");

        TreeSet<String> ts=new TreeSet<>();// sorted order ma arrange ho jata  or null value store ni krta h
        ts.add("Delhi");
        ts.add("puna");
        ts.add("Kolkata");
        ts.add("Bokaro");
        ts.add("Whi");

        System.out.println(cities);
        System.out.println(lhs);
        System.out.println(ts);
    }
}
