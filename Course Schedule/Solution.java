import java.util.*;

class CourseScheule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return false;
    }
}

class Graph {
    int V; //no of vertices
    LinkedList<Integer> adj[]; // adjacent nodes list
    boolean[] visited;
    Stack<Integer> stack;

    Graph(int v){
        V = v;
        adj = new LinkedList[V];
        visited = new boolean[V];
        stack = new Stack<Integer>();
        for(int i=0;i<V; i++){
            adj[i] = new LinkedList<>();
            visited[i] = false;
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFS(int v){
        visited[v] = true;
        System.out.print(v + " ");

        LinkedList<Integer> adjacentList = adj[v];
        for(int i=0;i<adjacentList.size();i++){
            //System.out.println(adjacentList);
            if(!visited[adjacentList.get(i)]){
                DFS(adjacentList.get(i));
            }
        }
    }

    void topologicalSortHelper(int v){
        visited[v] = true;

        LinkedList<Integer> adjacentList = adj[v];

        for(int i=0;i<adjacentList.size();i++){
            if(!visited[adjacentList.get(i)]){
                topologicalSortHelper(adjacentList.get(i));
            }
        }

        stack.push(v);
    }

    void topologicalSort(){
        topologicalSortHelper(0);
        System.out.println("Stack " + stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}

class Solution {    
    public static void main(String[] args){
        System.out.println("Course Schedule");
        //Graph graph = new Graph(4);
        Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 

//        graph.DFS(2);
        g.topologicalSort();
        
    }
}