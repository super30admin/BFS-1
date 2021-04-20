/*
Thought Process: 
Firstly save the employees in a hasmap with key as id and value as employee. It will reduce the time comp to fetch from the initial array.
Use BFS to find the solution. Insert the root id given as input to the q. Looping through q untill its empty fetch the employee from hashmap for the id and increment importance. Then add all the subordinates to the queue.

TC -> O(N) where N is number of employees
SC -> O(H) where H is height of the tree
*/

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        
        Map<Integer, Employee> m = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int importanceRes = 0;
        
        for(Employee e : employees){
            m.put(e.id, e);
        }
        q.add(id);
        while(!q.isEmpty()){
            int polledId = q.poll();
            Employee polledEmp = m.get(polledId);
            importanceRes += polledEmp.importance;
            for(int sub : polledEmp.subordinates){
                q.add(sub);
            }
        }
        return importanceRes;
    }
}