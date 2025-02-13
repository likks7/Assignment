import java.util.*;

public class AnagramGrouping {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] strs = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }

        List<List<String>> result = groupAnagrams(strs);
        
        System.out.println("Grouped Anagrams: " + result);
        
        scanner.close();
    }
}
