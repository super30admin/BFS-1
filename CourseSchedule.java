// Time Complexity :O(V+E). V is the Vertex. E is the edges
// Space Complexity : O(V). V is the number of vertices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null) return false;
        
        int[] prereqCount =new int[numCourses];
        HashMap<Integer,List<Integer>> hashMap = new HashMap();
        
        //prerequisites count
        for(int i=0;i<prerequisites.length;i++){
            
            //if(prereqCount.containsKey(preqrequisites[i][0]))
            //prerequisites counter
            prereqCount[prerequisites[i][0]]++;
            
            //storing dependants
            if(hashMap.containsKey(prerequisites[i][1]))
            hashMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        else{
            List<Integer> li = new ArrayList();
            li.add(prerequisites[i][0]);
            hashMap.put(prerequisites[i][1],li);  
        }
            
        }
            
            
        
        
        //adding independant subjects in queue
        Queue<Integer> q=new LinkedList();
        //checking for 0's(which are independent)
        for(int i=0;i<prereqCount.length;i++){
             if(prereqCount[i]==0){
                 q.add(i);
             }
        }
        
        //processing
        while(!q.isEmpty()){
            
            int top =q.poll();
            List<Integer> li = hashMap.get(top);
            
            if(li!=null)
        for(int i=0;i<li.size();i++){
            
            prereqCount[li.get(i)]--;
            if(prereqCount[li.get(i)]==0) 
                q.add(li.get(i)); 
        }
            
        }
            
        //checking for non-zero values
        for(int val:prereqCount){
            if(val!=0) return false;
            
        }
        return true;
        
        }
    }
