import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC39CombinationSum {
    //LINK: https://leetcode.com/problems/combination-sum/description/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates,target,0, new ArrayList<>(), result);
        return result ;
    }
    public void helper(int[] candidates, int target , int pivotInx, List<Integer> path,
                       List<List<Integer>> result){
        //Base Condition
        if(target<0)
            return;
        if(target == 0){
            result.add(new ArrayList<>(path));
        }

        //Logic
        for(int i=pivotInx; i<candidates.length;i++){ // loop that iterates through the candidates starting from the pivotInx
            //Action: Adding into path
            path.add(candidates[i]); //The current candidate (candidates[i]) is added to the path.

            //Calling recursion
            helper(candidates, target - candidates[i], i, path, result);  //function is called recursively with the updated target (target - candidates[i]), the //
            //current index (i), the updated path, and the result list

            //Backtracking
            path.remove(path.size()-1); //Backtracking is achieved by removing the last element from the path after the recursive call (path.remove(path.size()-1))

        }

    }
}
