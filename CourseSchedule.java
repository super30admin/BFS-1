/**
 * 
 * Time Complexity O(n) if we consider as graph then O(V)
 * Space Complexity O(n)/O(V) we maintain extra space for maintainting adjacency List
 * }
 */
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         if(prerequisites.length==0 ||prerequisites==null){
            return true;
        }
        int inDegree[]=new int[numCourses];
        HashMap<Integer,List<Integer>> cmap=new HashMap<>();
        Queue<Integer> d=new LinkedList<>();
        int m=prerequisites.length;
        int n=prerequisites[0].length;
       
        for(int i=0;i<m;i++){
            int curr=prerequisites[i][0];
            int preq=prerequisites[i][1];
            
            inDegree[curr]=inDegree[curr]+1;
            List<Integer> temp;
            if(!cmap.containsKey(preq)){
                cmap.put(preq,new ArrayList<>());
            }
            cmap.get(preq).add(curr);
        }

        
        for(int k=0;k<inDegree.length;k++){
            if(inDegree[k]==0){
                d.add(k);
            }
        }
            int count=0;
            while(!d.isEmpty()){
                int course=d.poll();
                System.out.println(course);
                count++;
                
                
                
                List<Integer> edges=cmap.get(course);

                
                if(edges!=null){
                    for(int i=0;i<edges.size();i++){
                        int edge=edges.get(i);
                        inDegree[edge]=inDegree[edge]-1;
                        if(inDegree[edge]==0){
                            d.add(edge);
                            
                        }
                    
                        
                }
                }
                
            }
        if(count!=numCourses)
            return false;
        
        return true;
        
    }
}