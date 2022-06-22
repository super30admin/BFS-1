class Solution {
    public boolean canFinish(int numcourses, int[][] prerequisites) {
        ArrayList arr[] = new ArrayList[numcourses];
        for (int i = 0; i < numcourses; i++) {
            arr[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            arr[a].add(b);
        }
        boolean vis1[] = new boolean[numcourses];
        boolean vis2[] = new boolean[numcourses];
        boolean flag = true;
        int i = 0;
        while (i < numcourses) {
            if (!vis1[i] && !dfs(arr, i, vis1, vis2)) {
                flag = false;
            }
            i++;
        }
        return flag;
    }

    boolean dfs(ArrayList arr[], int i, boolean vis1[], boolean vis2[]) {
        vis1[i] = true;
        vis2[i] = true;
        boolean flag = true;
        for (int temp : arr[i]) {
            if (vis2[temp])
                flag = false;
            else if (vis1[temp]) {
                continue;
            } else if (!dfs(arr, temp, vis1, vis2))
                flag = false;
        }
        vis2[i] = false;
        return flag;
    }
}