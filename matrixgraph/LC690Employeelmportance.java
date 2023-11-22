import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC690Employeelmportance {
    /*
    Link: https://leetcode.com/problems/employee-importance/description/
   In this problem, we are given a list of type Employee and we have to find the total importance of employee and his
   childs.
   DFS:
   In this we will maintain a hashmap where we put employee id and its dependents list along with its importance.
   {1: 5, [2,3]
    2: 3,[]
    3: 3,[]}
   Instead of storing dependents list and importance, we can store address of node itself that is pointer to that node
   {
       1: *420
       2: *520
       3: *620
   }
   1)

   Time Complexity : O(N) or O(V+E)
   Space Complexity: O(V)


    */
    HashMap<Integer, Employee> map;
    int totalImportance = 0;
    public int getImportance(List<Employee> employees, int id) {
        this.map = new HashMap<>();
        for(Employee e :employees ){
            map.put(e.id, e);
        }
        dfs(id);
        return totalImportance;
    }
    public void dfs(int empid){

        Employee empDets = map.get(empid);
        totalImportance = totalImportance + empDets.importance;
        List<Integer> empList = empDets.subordinates ;
        for(int e : empList){
            dfs(e);
        }
    }
}
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
