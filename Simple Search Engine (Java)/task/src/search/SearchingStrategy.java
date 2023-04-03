package search;

import java.util.List;
import java.util.Scanner;

public interface SearchingStrategy {
    void search(List<String> people, String query);
}
