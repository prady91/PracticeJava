import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pradyumna on 2/18/19.
 * https://www.interviewbit.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    private String generateSignature(List<Integer> combinationList) {
        StringBuilder str = new StringBuilder();
        combinationList.stream()
                .map(v -> v+",")
                .forEach(str::append);
        return str.toString();
    }

    private void combinationSumUtil (int remainingSum, int index,
                                     List<Integer> numList, ArrayList<Integer> currentCombination,
                                     ArrayList<ArrayList<Integer>> combinationList, HashSet<String> signatureSet) {
        if (remainingSum < 0) {
            return;
        }

        if (remainingSum == 0) {
            String signature = generateSignature(currentCombination);
            if (!signatureSet.contains(signature)) {
                combinationList.add(new ArrayList<>(currentCombination));
                signatureSet.add(signature);
            }
            return;
        }

        if (index >= numList.size()) {
            return;
        }

        int currentNum = numList.get(index);
        remainingSum = remainingSum - currentNum;
        currentCombination.add(currentNum);
        combinationSumUtil(remainingSum, index+1, numList, currentCombination, combinationList, signatureSet);

        remainingSum = remainingSum + currentNum;
        currentCombination.remove(currentCombination.size()-1);
        combinationSumUtil(remainingSum, index+1, numList, currentCombination, combinationList, signatureSet);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {

        Collections.sort(a);
        ArrayList<ArrayList<Integer>> combinationList = new ArrayList<>();
        combinationSumUtil(b, 0, a, new ArrayList<>(), combinationList, new HashSet<>());

        return combinationList;
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int target = 8;
        int[] nums = new int[]{10,1,2,7,6,1,5};
        ArrayList<Integer> numList = new ArrayList<>();
        Arrays.stream(nums)
                .forEach(numList::add);

        numList.stream()
                .forEach(System.out::println);
        combinationSumII.combinationSum(numList, target)
                .stream()
                .forEach(System.out::println);
    }
}
