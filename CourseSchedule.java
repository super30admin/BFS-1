class Solution {

    //Time Complexity : 0(V+E) where V is the vertices or courses and E is the edges or pre-requisite dependencies
    //Space Complexity: 0(V+E) where V is the vertices or courses and E is the edges or pre-requisite dependencies
    //Did it successfully run on leetcode: Yes
    //Did you face any problem: No

    //I used a hashmap to keep a track of the courses as key and along with it a list to keep track of which courses are pre
    //requisites to take it. I also used a queue for my BFS traversal and an array to store the no. of prerequisites required for
    //every subject. In my 1st for loop, I am increasing the value in the particular index of the array if it encounters the
    //course present at that index has a prerequisite. Then I am checking if the course if not present in my hashmap then
    //adding the course as key and creating a new ArrayList to store the courses required to take that subject as prereq.
    //Then I am doing topological sort such that if any subject dosen't have a dependency, I am adding it to my queue similarly
    //increasing my count pointer to keep a track of total courses taken. If the queue is empty then there is a cycle and the
    //course cannot be completed. If it's not, then I am removing the first element from the queue and checking with my hashmap
    //the courses relying upon it. I am then decreasing the value of those course in my array and if any index turns 0
    //means all the prerequisites are fulfilled for that course and the student can take that course, also increasing my
    //count pointer. At last I am checking if the counter is qual to the courses, then the semester can be completed and if not
    //then there is a loop and the output will be false.

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] a = new int[numCourses];
        for(int [] edge : prerequisites){
            a[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1] , new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(a[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()){
            return false;
        }

        while(!q.isEmpty()){
            int current = q.poll();
            List <Integer> edges = map.get(current);
            if(edges != null){
                for(int i: edges){
                    a[i]--;
                    if(a[i] == 0){
                        q.add(i);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;

    }
}