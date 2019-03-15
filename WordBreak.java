import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by pradyumna on 9/18/18.
 */
public class WordBreak {


    public List<String> wordBreakSplit(String s, List<String> wordDict) {

        List<String> wordSplit = new ArrayList<>();


        return wordSplit;

    }

    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();

        int[][] splitPossible = new int[len][len];

        Set<String> dictSet = wordDict.stream().collect(Collectors.toSet());

        for (int w=1; w<=len; w++) {
            for (int i=0; i<len; i++) {
                String word = s.substring(i, i+w);
                if (dictSet.contains(word)) {
                    splitPossible[i][i+w-1] = 1;
                } else {
                    //
                    splitPossible[i][i+w-1] = 2;
                }
            }
        }
        return false;
    }



}
