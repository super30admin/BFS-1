// Time Complexity:             O(n)
// Space Complexity:            O(n)
// where n is number of nodes in tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class ImportanceEmployee {
    
    // ******************** BFS Approach ********************
    
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);                              // adding all ids and employee objects in map
        }

        int totalImp = 0;

        Queue<Employee> q = new LinkedList<>();

        q.add(map.get(id));

        while(!q.isEmpty()) {
            Employee e = q.remove();                       // processing current employee
            totalImp += e.importance;                      // adding importance in result
            for(int subId : e.subordinates) {
                q.add(map.get(subId));                     // adding children in queue
            }
        }

        return totalImp;
    }
    
//     // ******************** DFS Approach ********************
    
//     Map<Integer, Employee> map;
//     int totalImp = 0;

//     public int getImportance(List<Employee> employees, int id) {

//         map = new HashMap<>();

//         for(Employee e : employees) {                                                   // maintaining map for employee id, employee object
//             map.put(e.id, e);
//         }

//         dfs(id);

//         return totalImp;

//     }

//     private void dfs(int id) {

//         Employee e = map.get(id);                                                       // getting employee object from current employee id
//         totalImp += e.importance;                                                       // adding importance of the current employee

//         for(int subId : e.subordinates) {                                               // calling dfs on all subordinates
//             dfs(subId);
//         }

//     }
}
