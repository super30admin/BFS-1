// Time-complexity:O(V+E)
// Space complexity:O(V+E)
// Ran succesfully on leetcode:Yes
// Solution with approach:
//Created a graph witht the help of hashmap and added all courses required for a prequisite by their couunt in array and did a BFS while 
//decreasing the count in array.
class Solution {
            public boolean canFinish(int numCourses, int[][] prerequisites) {
                HashMap<Integer,List<Integer>> map= new HashMap<>();
                int[] arr= new int[numCourses];
                for(int[] x: prerequisites)
                {   if(!map.containsKey(x[1]))
                        map.put(x[1],new LinkedList<>());
                    map.get(x[1]).add(x[0]);    
                    arr[x[0]]++;            
                }
                
                Queue<Integer> q = new LinkedList<>();
                
                for(int i=0;i<numCourses;i++)
                    if(arr[i]==0)
                        q.add(i);
                
                while(!q.isEmpty())
                {
                    int key = q.poll();
                    if(map.containsKey(key)){
                        for (int i : map.get(key)){
                            arr[i]--;
                            if(arr[i]==0)   
                                q.add(i);
                        }
                    }
                }
                for(int x: arr)
                    if(x!=0)
                        return false;
                
                return true;
            }
        }