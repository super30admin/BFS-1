/*
Time Complexity:O(|E|+|V|)
Space Complexity:O(|E|+|V|)
*/
class Solution {
    static boolean flag;
    static int des;
    public boolean canFinish(int n, int[][] pre) {
        int num=pre.length;
        Map<Integer,List<Integer>> adj=new HashMap();
        for(int i=0;i<num;i++){
            adj.putIfAbsent(pre[i][0],new ArrayList());
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        
        flag=false;
        for(int i=0;i<n;i++){
            if(adj.containsKey(i)){
                des=i;
                bfs(adj,i,n);
                if(flag)
                    return false;
            }
        }
        return true;
    }
    private void bfs(Map<Integer,List<Integer>> adj,int src,int n){
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new ArrayDeque();
        q.add(src);
        vis[src]=true;
        while(!q.isEmpty()){
            List<Integer> l1=adj.get(q.poll());
            for(int i=0;i<l1.size();i++){
                if(des==l1.get(i)){
                    flag=true;
                    return;
                }
                if(!vis[l1.get(i)] && adj.containsKey(l1.get(i))){
                    vis[l1.get(i)]=true;
                    q.add(l1.get(i));
                }
            }
        }
    }
}