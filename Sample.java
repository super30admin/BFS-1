        // Binary Tree Level Order Traversal

// Time Complexity : O(n)  .. n = number of nodes
// Space Complexity : O(2^h) .. h = height of tree

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return new ArrayList();
            
        List<List<Integer>> list = new ArrayList();

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> cur = new ArrayList();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                cur.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            list.add(new ArrayList(cur));
        }
        
        return list;
    }
}

        // Course Schedule

// Time Complexity : O(E + V)  .. n = number of nodes
// Space Complexity : O(E + V) .. h = height of tree

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap();
        int[] coursesCompleted = new int[numCourses];

        for(int[] course : prerequisites){
            coursesCompleted[course[0]]++;
            if(!map.containsKey(course[1]))
                map.put(course[1], new ArrayList());
            map.get(course[1]).add(course[0]); 
        }

        Queue<Integer> q = new LinkedList();

        for(int i=0;i<numCourses;i++){
            if(coursesCompleted[i] == 0)
                q.add(i);
        }

        if(q.isEmpty())
            return false;

        while(!q.isEmpty()){
            int node = q.remove();
            List<Integer> curList = map.get(node);
            if(curList == null)
                continue;
            for(int num : curList){
                coursesCompleted[num]--;
                if(coursesCompleted[num] == 0)
                    q.add(num);
            }
        }

        for(int i=0;i<numCourses;i++){
            if(coursesCompleted[i] > 0)
                return false;
        }

        return true;
    }
}
