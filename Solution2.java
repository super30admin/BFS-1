/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean result = false;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            graph.add(i, new ArrayList<>());
        }
        
        for(int[] prerequisite : prerequisites){
                ArrayList<Integer> temp = graph.get(prerequisite[1]);
                temp.add(prerequisite[0]);
                graph.remove(prerequisite[1]);
                graph.add(prerequisite[1], temp);
        }
        
        int[] indegree = new int[graph.size()];
        for(int i=0; i<graph.size(); i++){
            ArrayList<Integer> temp = graph.get(i);
            for(int val : temp){
                indegree[val]++;
            }
        }
        
        for(int i=0; i<indegree.length; i++){
            System.out.print(indegree[i]+" ");
        }
        System.out.println();
        
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ts = new ArrayList();
        
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                queue.addLast(i);
            }
        }
        
        System.out.println(graph);
        
        while(queue.size() > 0){
            int rm = queue.removeFirst();
            
            ts.add(rm);
            
            System.out.println("Removed : " + rm);
            
            ArrayList<Integer> neighbors = graph.get(rm);
            for(int neighbor : neighbors){
                System.out.println("Neighbor : " + neighbor);
                indegree[neighbor]--;
                
                if(indegree[neighbor]==0){
                    queue.addLast(neighbor);
                }
            }
        }        
        
        if(ts.size() == indegree.length){
            return true;
        }
        return result;
    }
}
