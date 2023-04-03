package search;

import java.util.*;

public class AllSearchingStrategy implements SearchingStrategy {
    @Override
    public void search(List<String> people, String query) {
        ArrayList<String> foundPeople = new ArrayList<>();
        Map<String, Set<Integer>> searchIndexes = new HashMap<>();
        for (String person : people) {
            for (String attr : person.toLowerCase().split(" ")) {
                Set<Integer> indicies = new HashSet<>();
                if (searchIndexes.containsKey(attr)) {
                    indicies.addAll(searchIndexes.get(attr));
                    indicies.add(people.indexOf(person));
                    searchIndexes.put(attr, indicies);
                } else {
                    indicies.add(people.indexOf(person));
                    searchIndexes.putIfAbsent(attr, indicies);
                }
            }
        }
        String[] queries = query.split(" ");
        Set<Integer> indexes = new HashSet<>();
        boolean flag = false;
        for (String qry: queries) {
            if (searchIndexes.get(qry) != null) {
                if (flag) {
                    indexes.retainAll(searchIndexes.get(qry));
                } else {
                    flag = indexes.addAll(searchIndexes.get(qry));
                }
            }
        }
        if (indexes.size() != 0) {
            System.out.println(indexes.size() + " persons found:");
            indexes.forEach(i -> foundPeople.add(people.get(i)));
            foundPeople.forEach(System.out::println);
        } else {
            System.out.println("No matching people found.");
        }
    }
}
