//Time complexity is O(E+V) - E is num of courses, V is num of dependencies
//Space complexity is O(E+V) - E is num of courses, V is num of dependencies
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        //Keep count to get num of dependencies for each subject to take
        int[] dep=new int[n];
        //Hashmap to store courses depend on given subject
        HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        for(int[] cou : prerequisites){
            dep[cou[0]]=dep[cou[0]]+1;
            List<Integer> temp = hm.getOrDefault(cou[1], new ArrayList());
            temp.add(cou[0]);
            hm.put(cou[1], temp);
        }
        boolean[] completed=new boolean[n];
        Stack<Integer> st = new Stack<Integer>();
        //Below is the code to find independent courses to start with
        //Save the initial courses taken to stack
        for(int i=0;i<n;i++){
            if(dep[i]==0){
                st.push(i);
                completed[i]=true;
            }
        }
        while(!st.isEmpty()){
            int temp=st.pop();
            List<Integer> templi = hm.getOrDefault(temp, new ArrayList());
            if(templi.size()>0)
            //Get the list of courses depend on completed course temp, and minus the    dependencies for the subject. 
            //If the count of dependencies become 0, we can take that course and push to stack
            for(int num: hm.get(temp)){
                dep[num]=dep[num]-1;
                if(dep[num]==0){
                    completed[num]=true;
                    st.push(num);
                }
            }
        }
        //If any of course value is false, we can return false as not possible to take all courses
        for(boolean b : completed){
            if(!b){
                return false;
            }
        }
        return true;
    }
}