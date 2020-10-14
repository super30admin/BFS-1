class Solution {//Time and space of O(n)
    // revise look other approach
public Node connect(Node root) {
Queue<Node> queue = new LinkedList<>();

//Base case 
if(root == null)
return null;
queue.add(root);
//Initially all next pointers are set to null.
while(!queue.isEmpty()){
int size= queue.size();
Node temp = null; 
for(int i =0 ; i<size ; i++){
    temp = queue.poll();
    //Modificaton
    if(i<size - 1){
       // System.out.println(i+" <"+(size-1));
        temp.next = queue.peek();
    }
    if(temp.left !=null)
        queue.add(temp.left);
    if(temp.right != null)
        queue.add(temp.right); 
}
}
return root;

}
}