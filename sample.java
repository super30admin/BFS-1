
// 0(n) time and o(h) space
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if (root == null)return;
        //logic

        if(result.size() == level){
            result.add(new ArrayList<>());

        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

//o(v + E) time and o(v) space


class Solution {
    boolean [] path;
    boolean [] visited;
    HashMap<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        map = new HashMap<>();
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        for(int[] pre: prerequisites){
            if(!map.containsKey(pre[1])){
                map.put(pre[1],new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && hasCycle(i)){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int course){
        //base
        //check path first
        if(path[course]) return true;
        if(visited[course]) return false;
        //logic
        visited[course] = true;
        //action
        path[course] = true;
        //recurrsion
        List<Integer> children = map.get(course);
        if(children != null){
            for(int child : children){
                if(hasCycle(child)) return true;
            }
        }
        path[course] = false;
        return false;
    }
}