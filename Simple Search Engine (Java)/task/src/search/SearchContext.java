package search;

import java.util.List;

public class SearchContext {

    SearchingStrategy strategy;
     public SearchContext(SearchingStrategy strategy) {
         this.strategy = strategy;
     }

     public void perform(List<String> people, String query) {
         this.strategy.search(people, query);
     }
}
