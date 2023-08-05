import java.util.*;
public class Main {
    public static void main(String[] args) {

        List<String> list = new java.util.LinkedList<>();
        list.add("Ali");
        list.add("Oai");
        list.add("Vohid");
        list.add("Vohid");
        list.add("Asror");
        list.add("Bahrom");
        list.add("Shohasan");
        list.add("Shahriyor");
        list.add("Guli");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ism kiriting");
        String s = scanner.nextLine();
       filterData(list,s).forEach(System.out::println);
    }
    private static Set<String> filterData(List<String> list, String s){
        Set<String> res=new LinkedHashSet<>();
        List<String> filtered = list.stream().filter(s1 -> s1.equalsIgnoreCase(s))
                .toList();
        if (filtered.size()!=0) {
            filtered.forEach(System.out::println);
        }else {
            List<String> list1 = list.stream()
                    .filter(s1 -> s1.length() >= s.length()
                            || Character.toLowerCase(s1.charAt(0))==
                            Character.toLowerCase(s.charAt(0)) ||
                            Character.toLowerCase(s1.charAt(s1.length()-1))==
                                    Character.toLowerCase(s.charAt(s.length()-1))
                    )
                    .toList();
            if(list1.size()<2){
                list1.forEach(System.out::println);
                return res;
            }

            Map<String,Integer> map = new LinkedHashMap<>();
            for (String value : list1) {
                int a = 0;
                for (int i = 0; i < value.length(); i++) {
                    for (int k = 0; k < s.length(); k++) {
                        if (Character.toLowerCase(value.charAt(i)) ==
                                Character.toLowerCase(s.charAt(k))) {
                            a++;
                        }
                    }
                }
                map.put(value, a);
            }

            Collection<Integer> values = map.values();
            List<Integer> sortedRates = values.stream().sorted(Comparator.reverseOrder()).toList();
            for (Integer sortedRate : sortedRates) {
                for (String s1 : map.keySet()) {
                    if (map.get(s1).equals(sortedRate)) {
                        res.add(s1);
                    }
                }
            }
//            map.forEach((s1, integer) -> System.out.println(s1+" "+integer));
            }
        return res;
    }
}
