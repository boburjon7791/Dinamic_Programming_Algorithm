import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> list = new java.util.LinkedList<>();
        list.add("Ali");
        list.add("Oai");
        list.add("Vohid");
        list.add("Asror");
        list.add("Bahrom");
        list.add("Shohasan");
        list.add("Shahriyor");
        list.add("Guli");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ism kiriting");
        String s = scanner.nextLine();
        List<String> filtered = list.stream().filter(s1 -> s1.equals(s))
                .toList();
        if (filtered.size()!=0) {
            filtered.forEach(System.out::println);
        }else {
            List<String> list1 = list.stream()
                    .filter(s1 -> s1.length() == s.length())
                    .toList();
            if(list1.size()<2){
                list1.forEach(System.out::println);
                return;
            }

            Map<String,Integer> map = new LinkedHashMap<>();
            for (int j=0;j<list1.size();j++) {
                int a=0;
                for (int i = 0; i < list1.get(j).length(); i++) {
                    if(list1.get(j).charAt(i)==s.charAt(i)){
                        a++;
                    }
                }
                map.put(list1.get(j),a);
            }
            Optional<Integer> first = map.values().stream().max(Integer::compareTo);
            if (first.isPresent()) {
                for (String s1 : map.keySet()) {
                    if (map.get(s1).equals(first.get())) {
                        System.out.println(map.get(s1));
                    }
                }
            }
        }
    }
}
