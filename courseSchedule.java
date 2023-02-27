//time complexity : O(m*n)
//space complexity : O(m*n)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] arr = new int[numCourses];
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        Queue<Integer> q= new LinkedList<>();
        int count =0;
        for(int[]p: prerequisites){
            arr[p[0]]++;
            if(map.containsKey(p[1])) map.get(p[1]).add(p[0]);
            else{
                List<Integer> l= new ArrayList<Integer>();
                l.add(p[0]); 
                map.put(p[1],l);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                q.add(i);
                count++;
            }
        }
        if(q.size()==0) return false;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(map.containsKey(curr)){
               List <Integer> l=  map.get(curr);
               for(int a:l){
                   arr[a]--;
                   if(arr[a]==0){ q.add(a);
                   count++;}
               }
            }
        }
        return (count==numCourses);
    }
}
