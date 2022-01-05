//https://programmers.co.kr/learn/courses/30/lessons/42892

import java.util.*;

class Solution {
    class TreeNode implements Comparable<TreeNode>{
        int value;
        int layer;
        int index;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int value, int layer, int index, TreeNode parent, TreeNode left, TreeNode right){
            this.value = value;
            this.layer = 1000-layer;
            this.index = index;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public int compareTo(TreeNode other){
            return this.layer - other.layer;
        }
        
        @Override
        public String toString(){
            return "(" + value + "," + (1000-layer) + "," + index + ")";
        }
    }
    
    public void addTreeElement(TreeNode rootNode, TreeNode newNode){
        //위치를 찾는다.
        var current = rootNode;
        while(newNode.parent == null){
            if(newNode.value < current.value){
                if(current.left != null){
                    current = current.left;
                }
                //넣는다.
                else{
                    current.left = newNode;
                    newNode.parent = current;
                }
            }
            else{
                if(current.right != null){
                    current = current.right;
                }
                //넣는다.
                else{
                    current.right = newNode;
                    newNode.parent = current;
                }
            }
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<TreeNode> treeNodes = new ArrayList();
        for(int i=0; i<nodeinfo.length; i++){
            treeNodes.add(new TreeNode(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null, null));
        }
        Collections.sort(treeNodes);
        
        // for(var v : treeNodes)
        //     System.out.println(v);
            
        //가장 앞에있는 것이 root
        TreeNode rootNode = treeNodes.get(0);
        // System.out.println("루트 노드 : " + rootNode);
        
        //layer 순으로 트리노드 삽입 시도
        for(var treeNode : treeNodes){
            if(treeNode == rootNode) continue;
            addTreeElement(rootNode, treeNode);
        }
        
        //전위 순회
        // System.out.println("전위 순회");
        preOrder(rootNode);
        
        // System.out.println("후위 순회");
        //후위 순회
        postOrder(rootNode);
        
        
        int[][] answer = new int[2][];
        answer[0] = new int[preOrderList.size()];
        answer[1] = new int[postOrderList.size()];
        for(int i=0; i<preOrderList.size(); i++){
            answer[0][i] = preOrderList.get(i);
        }
            
        for(int i=0; i<postOrderList.size(); i++){
            answer[1][i] = postOrderList.get(i);
        }
        
        return answer;
    }
    
    ArrayList<Integer> preOrderList = new ArrayList();
    ArrayList<Integer> postOrderList = new ArrayList();
    
    //ㄴ
    public void preOrder(TreeNode treeNode){
        if(treeNode == null) {
            return;
        }
        
        // System.out.println(treeNode);
        preOrderList.add(treeNode.index);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }
    
    //ㅢ
    public void postOrder(TreeNode treeNode){
        if(treeNode == null) {
            return;
        }
        
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        // System.out.println(treeNode);
        postOrderList.add(treeNode.index);
    }
}