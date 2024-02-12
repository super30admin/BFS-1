//Time - O(n)
//Space - O(n)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] courses = new int[numCourses];
        for(int[] pre: prerequisites){
            courses[pre[0]]++;
        }
        for(int[] pre: prerequisites){
            if(hm.containsKey(pre[1])){
                ArrayList<Integer> l = hm.get(pre[1]);
                l.add(pre[0]);
                hm.put(pre[1],l);
            }
            else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(pre[0]);
                hm.put(pre[1],l);

            }
        }
        for(int i=0;i<courses.length;i++){
            if(courses[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                int c = q.poll();
                if(hm.containsKey(c)){
                    List<Integer> sub = hm.get(c);
                    for(int j=0;j<sub.size();j++){
                        int co = sub.get(j);
                        courses[co]--;
                        if(courses[co]==0){
                            q.add(co);
                        }
                    }

                }
                
            }
        }
        for(int i=0;i<courses.length;i++){
            if(courses[i]!=0){
                return false;
            }
        }
        return true;


    }
}
