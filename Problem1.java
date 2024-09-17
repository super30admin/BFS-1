//Time Complexity:O(n)
//Space Complexity:O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result=new ArrayList();
        if(root==null)
            return result;
        Queue<TreeNode> q= new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> res=new ArrayList();
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.poll();
                res.add(n.val);
                if(n.left!=null)q.add(n.left);
                if(n.right!=null)q.add(n.right);
            }
            result.add(res);
        }
        return result;
    }
}

-------------------------------------------------------------------------------------------------------
//Time Complexity:O(|E| + |V|) where |V| is the number of courses, and |E| is the number of dependencies.
//Space Complexity:O(|E| + |V|) where |V| is the number of courses, and |E| is the number of dependencies.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees=new int[numCourses];
        HashMap<Integer,List<Integer>>hm= new HashMap();
        for(int i=0;i<prerequisites.length;i++)
        {
            indegrees[prerequisites[i][0]]++;
            if(!hm.containsKey(prerequisites[i][1]))
            {
                hm.put(prerequisites[i][1],new ArrayList());
            }
            hm.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q= new LinkedList();
        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i]==0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int course=q.poll();
            List<Integer> children=hm.get(course);
            if(children!=null)
            {
                for(int child:children)
                {
                    indegrees[child]--;
                    if(indegrees[child]==0)
                        q.add(child);
                }
            }
        }
        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i]!=0)
                return false;
        }
        return true;
    }
}
----------------------------------------------------------------------------------------------------
//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    List<Integer> ans = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q= new LinkedList();
        if(root==null)
            return ans;
        q.offer(root);
        while(!q.isEmpty())
        {
            int s=q.size();
            while(s>0)
            {
                s--;
                TreeNode n=q.poll();
                if(s==0)
                    ans.add(n.val);
                if(n.left!=null)
                    q.offer(n.left);
                if(n.right!=null)
                    q.offer(n.right);
            }
        }
        return ans;
    }
   
}