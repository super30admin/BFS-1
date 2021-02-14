// Time-complexity:O(n)
// Space complexity:O(n)
// Ran succesfully on leetcode:No
// Solution with approach:
//I created an aray with number of courses and marked -1 whenever a course with some prerequisite comes, in the end if there are courses remaining.
//But i ma not sure why is it not passing all test cases.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] arr=new int[numCourses];
        int count=0;
        for(int i=0;i<prerequisites.length;i++)
        {
            if(arr[prerequisites[i][0]]!=-1)
            {
                count++;
                arr[prerequisites[i][0]]=-1;
            }
        }
        return count<numCourses ? true: false;
    }
}