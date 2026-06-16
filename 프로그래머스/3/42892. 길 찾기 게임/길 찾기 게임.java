import java.util.*;
class Cell implements Comparable<Cell>{
    int num;
    int x;
    int y;
    
    Cell(int num, int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
    
    public int compareTo(Cell cell){
        if(this.y == cell.y){
            return this.x - cell.x;
        }
        return cell.y - this.y;
    }
}
class Node{
    Cell val;
    Node left;
    Node right;
    
    Node(Cell cell){
        this.val = cell;
    }
}
class Solution {
    static int[] pre;
    static int[] post;
    static int preIdx;
    static int postIdx;
    public int[][] solution(int[][] nodeinfo) {
         
        Cell[] cells = new Cell[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++){
            cells[i] = new Cell(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(cells);
        
        Node root = new Node(cells[0]);
        
        for(int i=1; i<cells.length; i++){
            insert(root, new Node(cells[i]));
        }
        
        pre = new int[cells.length];
        post = new int[cells.length];
        
        preIdx = 0;
        postIdx = 0;
        
        preOrder(root);
        postOrder(root);
                
        return new int[][]{pre, post};
    }
    
    public void insert(Node parent, Node child){
        if(parent.val.x > child.val.x){
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }else {
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    public void preOrder(Node node){
        if(node == null) return;
        pre[preIdx++] = node.val.num;
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        post[postIdx++] = node.val.num;
    }
}