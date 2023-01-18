//tc : O(vertices+edges)
//sc : O(vertices + edges)
//run successfully on leetcode
//no problems 

//Made Adjacency list and created the graph
//iterated through entire graph for any loop,
//loop?false:true;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] pre = new int[numCourses];

        for (int[] num : prerequisites) {
            pre[num[0]]++;
            map.putIfAbsent(num[1], new ArrayList<>());
            map.get(num[1]).add(num[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pre[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            for (int num2 : map.getOrDefault(q.poll(), new ArrayList<>())) {
                pre[num2]--;
                if (pre[num2] == 0)
                    q.add(num2);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (pre[i] != 0)
                return false;
        }
        return true;
    }
}