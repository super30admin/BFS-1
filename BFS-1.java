//Time complexity O(N) and space complexity O(N)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode node = queue.remove();
                System.out.println(node.val);
                
                if(node.left!=null){
                    queue.add(node.left);
                }
                    
                if(node.right!=null){
                    queue.add(node.right);
                }
                subList.add(node.val);
                    
            }
            result.add(subList);
        }

        return result;
        
    }
}

//time complexity O(N) space complexity O(N)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        //Make an adjacency list
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<Integer>());
        } 

        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){ 
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        // System.out.println(Arrays.toString(indegree));
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        int count =0;
    

        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            List<Integer> list = map.get(course);
            for(int i=0;i<list.size();i++){
                indegree[list.get(i)]--;

                if(indegree[list.get(i)]==0){
                    queue.add(list.get(i));
                }
            }
        }

        return count==numCourses;
    }
}
