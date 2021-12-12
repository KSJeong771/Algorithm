//https://programmers.co.kr/learn/courses/30/lessons/12946#

import java.util.*;

class Solution {
    ArrayList<int[]> list = new ArrayList();
    public int[][] solution(int n) {
        var stacks = new ArrayList<Stack<Integer>>();
        var stack1 = new Stack<Integer>();
        for(int i=n; i>=1; i--)
            stack1.push(i);
        stacks.add(stack1);
        stacks.add(new Stack<Integer>());
        stacks.add(new Stack<Integer>());
        
        printStacks(stacks);
        moveStack(stacks, 0, 1, 2, n);
        printStacks(stacks);
        
        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
    
    public void moveStack(ArrayList<Stack<Integer>> stacks, int from, int temp, int to, int size){
        if(size == 0)
            return;
        
        //임시 장소로 윗 노드들 옮기기
        moveStack(stacks, from, to, temp, size-1);
        
        //메인 1개짜리 노드를 목적지로 이동
        var value = stacks.get(from).pop();
        stacks.get(to).push(value);
        list.add(new int[]{from+1, to+1});
        
        //임시 장소에서 목적지로 이동
        moveStack(stacks, temp, from, to, size-1);
    }
    
    public void printStacks(ArrayList<Stack<Integer>> stacks){
        System.out.println("--------------");
        for(var stack : stacks){
            for(var value : stack){
                System.out.print(value + " ");
            }
                System.out.println();
        }
        System.out.println("--------------");
    }
}