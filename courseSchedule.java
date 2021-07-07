// 207.

//time - O(n)
//space - O(n) for the indegree array, hashmap and queue
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //prereq format array of 2 numbers -> 0th element course, 1st element - pre req
        //build indegree array and graph as a hashmap(adjacency lsit)
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prereq : prerequisites)
        {
            //prereq[i] = [course, prereq] -> [dest, source]           
            indegree[prereq[0]] += 1; //increase the indegree of node
            if(graph.containsKey(prereq[1])) //add edge to graph
            {
                graph.get(prereq[1]).add(prereq[0]);
            }
            else
            {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(prereq[0]);
                graph.put(prereq[1], temp);
            }
        }
        
        //process all courses with 0 indegree (no dependency) first
        Queue<Integer> support = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0) //this course has no dependency, so processed first
            {
                support.offer(i);
            }
        }
        
        while(!support.isEmpty())
        {
            Integer front = support.poll();
            List<Integer> courses = graph.get(front);
            if(courses != null)
            {
                for(Integer course : courses)
                {
                    indegree[course]--;
                    if(indegree[course] == 0)//then this course has no more dependencies
                    {
                        //so add it to queue
                        support.offer(course);
                    }
                }
            }
        }
        
        //after all courses are processed, if still indegree is 0 for some course, return false
        //else return true
        for(int in : indegree)
        {
            if(in > 0)
            {
                return false;
            }
        }
        
        return true;
    }
}
