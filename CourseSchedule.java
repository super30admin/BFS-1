public class CourseSchedule {
    boolean canFinish = true;
    HashMap<Integer, List<Integer>> map = new HashMap();
    int[]   dependencyCount;
    Queue<Integer> queue = new LinkedList();
    int count = 0;

    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        dependencyCount = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++)
        {
            dependencyCount[prerequisites[i][0]] += 1;
            if(map.containsKey(prerequisites[i][1]))
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            else
            {
                List<Integer> newList = new ArrayList();
                newList.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], newList);
            }
        }

        for(int i = 0; i < dependencyCount.length; i++)
        {
            if(dependencyCount[i] == 0)
            {
                queue.add(i);
                count++;
            }
        }
        if(count == numCourses)
            return true;
        if(queue.isEmpty())
            return false;

        while(!queue.isEmpty())
        {
            int node = queue.poll();
            findIndepedentNodes(node);
        }

        return count == numCourses;
    }

    public void findIndepedentNodes(int node)
    {
        List<Integer> depList = map.get(node);
        if(depList == null)
            return;

        for(int i : depList)
        {
            dependencyCount[i] = dependencyCount[i]-1;
            if(dependencyCount[i] == 0)
            {
                count++;
                queue.add(i);
            }
        }
    }
}
