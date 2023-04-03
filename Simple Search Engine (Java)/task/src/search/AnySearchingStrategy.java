package search;

import java.util.*;

public class AnySearchingStrategy implements SearchingStrategy {
    @Override
    public void search(List<String> people, String query) {
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
        for (String qry: queries) {
            if (searchIndexes.get(qry) != null) {
                indexes.addAll(searchIndexes.get(qry));
            }
        }
        if (indexes.size() != 0) {
            System.out.println(indexes.size() + " persons found:");
            indexes.forEach(i -> System.out.println(people.get(i)));
        } else {
            System.out.println("No matching people found.");
        }
    }
}
