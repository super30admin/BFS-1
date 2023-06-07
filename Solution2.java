class Solution2 {
    int[][] edges;
    int n;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        edges = new int[n][n];
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> order = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int fv = prerequisites[i][1];
            int sv = prerequisites[i][0];
            edges[fv][sv] = 1;
        }
        for(int i = 0; i < n; i++) {
            if( helper(i) ) {
                list.add(i);
            }
        }
        if( list.size() == 0) {
            return false;
        }
        while( !list.isEmpty() ) {
            int v = list.remove(list.size()-1);
            order.add(v);
            for(int i = 0; i < n; i++) {
                if( edges[v][i] == 1 ) {
                    edges[v][i] = 0;
                    if( helper(i) ) {
                        list.add(i);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if( edges[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helper(int column) {
        for(int i = 0; i < n; i++) {
            if( edges[i][column] == 1) {
                return false;
            }
        }
        return true;
    }
}