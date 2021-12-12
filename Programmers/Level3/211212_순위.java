//https://programmers.co.kr/learn/courses/30/lessons/49191#

import java.util.*;

class Solution {
    TreeNode[] tree;
    
    public LinkedHashSet<Integer> visitAllLeftNodes(int node, int[] visited){
        LinkedHashSet<Integer> result = new LinkedHashSet();
        result.addAll(tree[node].leftNodes);
        
        //이미 방문한 노드면 결과를 불러오고
        if(visited[node] > 0)
            return result;
        
        //방문한 적이 없다면
        //노드를 방문하여
        visited[node] = 1;
        
        //모든 왼쪽 노드를 얻어온다.
        for(int leftNode : tree[node].leftNodes){
            result.addAll(visitAllLeftNodes(leftNode, visited));
        }
        tree[node].leftNodes.addAll(result);
        
        // System.out.print("node : " + node + " result : ");
        // for(var v : result)
        //     System.out.print(v + ", ");
        // System.out.println();
        
        return result;
    }
    
    public LinkedHashSet<Integer> visitAllRightNodes(int node, int[] visited){
        LinkedHashSet<Integer> result = new LinkedHashSet();
        result.addAll(tree[node].rightNodes);
        
        if(visited[node] > 0)
            return result;
        
        visited[node] = 1;
        for(int rightNode : tree[node].rightNodes){
            //모든 오른쪽 노드를 얻어온다.
            result.addAll(visitAllRightNodes(rightNode, visited));
        }
        tree[node].rightNodes.addAll(result);
        
        System.out.print("node : " + node + " result : ");
        for(var v : result)
            System.out.print(v + ", ");
        System.out.println();
        
        return result;
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        tree = makeTree(n, results);
        int[] visitedLeft = new int[n+1];
        int[] visitedRight = new int[n+1];
            
        for(int i=1; i<=n; i++){
            tree[i].leftNodes.addAll(visitAllLeftNodes(i, visitedLeft));
            tree[i].rightNodes.addAll(visitAllRightNodes(i, visitedRight));
        }
        
        for(int i=1; i<=n; i++){
            if(tree[i].leftNodes.size() + tree[i].rightNodes.size() == n-1)
                answer++;
        }
        
        System.out.println("--------- RESULT -----------");
        for(int i=1; i<=n; i++){
            TreeNode node = tree[i];
            
            System.out.print("i : " + i + " [");
            for(var left : node.leftNodes)
                System.out.print(left + "");
            
            System.out.print(" / ");
            
            for(var right : node.rightNodes)
                System.out.print(right + "");
            System.out.println("]");
        }
        
        return answer;
    }
    
    class TreeNode{
        LinkedHashSet<Integer> leftNodes;
        LinkedHashSet<Integer> rightNodes;
        public TreeNode(){
            leftNodes = new LinkedHashSet<Integer>();
            rightNodes = new LinkedHashSet<Integer>();
        }
    }
    
    public TreeNode[] makeTree(int n, int[][] results){
        TreeNode[] tree = new TreeNode[n+1];
        
        for(int i=0; i<=n; i++){
            tree[i] = new TreeNode();
        }
        
        for(int i=0; i<results.length; i++){
            int left = results[i][0];
            int right = results[i][1];
            tree[right].leftNodes.add(left);
            tree[left].rightNodes.add(right);
        }
        
        for(int i=1; i<=n; i++){
            TreeNode node = tree[i];
            
            System.out.print("i : " + i + " [");
            for(var left : node.leftNodes)
                System.out.print(left + "");
            
            System.out.print(" / ");
            
            for(var right : node.rightNodes)
                System.out.print(right + "");
            System.out.println("]");
        }
        
        return tree;
    }
}