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
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);                              // adding all ids in map
        }

        int totalImp = 0;

        Queue<Employee> q = new LinkedList<>();

        q.add(map.get(id));

        while(!q.isEmpty()) {
            Employee e = q.remove();
            totalImp += e.importance;                      // adding importance in result
            for(int subId : e.subordinates) {
                q.add(map.get(subId));                     // adding children in queue
            }
        }

        return totalImp;
    }
}