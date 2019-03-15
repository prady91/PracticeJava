import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pradyumna on 1/17/19.
 */
public class WordBreakNew {


    private boolean isPossible (String s, Set<String> wordSet, Map<String, Boolean> possibleSplitStrings) {
        if (possibleSplitStrings.containsKey(s)) {
            return possibleSplitStrings.get(s);
        }
        if (wordSet.contains(s)) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            String subString = s.substring(0, i);
            if (wordSet.contains(subString)) {
                boolean splitResult = isPossible(s.substring(i), wordSet, possibleSplitStrings);
                possibleSplitStrings.put(s.substring(i), splitResult);
                if (splitResult) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = wordDict.stream().collect(Collectors.toSet());
        return isPossible(s, wordSet, new HashMap<>());
    }

}
