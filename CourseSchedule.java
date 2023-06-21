//Time Complexity o(v+e) space complexity o(e)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length==0) return true;
        HashMap<Integer,ArrayList<Integer>> map= new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[numCourses];
        for(int[] a: prerequisites){
            arr[a[0]]++;
            if(!map.containsKey(a[1])){
                ArrayList<Integer> d = new ArrayList<>();
                d.add(a[0]);
                map.put(a[1],d);
            }
            else{
                map.get(a[1]).add(a[0]);
            }
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ArrayList<Integer> childs= map.get(curr);
            if(childs!=null){
                for(int child: childs){
                arr[child]--;
                if(arr[child]==0){
                    count++;
                    q.add(child);
                }
                if(count==numCourses) return true;
            }
            }
        }
        return false;

    }
}
