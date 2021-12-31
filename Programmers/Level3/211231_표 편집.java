//https://programmers.co.kr/learn/courses/30/lessons/81303

import java.util.*;

class Solution {
    class Node{
        Integer number;
        Integer left;
        Integer right;
        public Node(Integer number, Integer left, Integer right){
            this.number = number;
            this.left = left;
            this.right = right;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        int cursor = k;
        Node[] data = new Node[n];
        data[0] = new Node(0, -1, 1);
        for(Integer i=1; i<n-1; i++){
            data[i] = new Node(i, i-1, i+1);
        }
        data[n-1] = new Node(n-1, n-2, -1);
        
        Stack<Node> removedStack = new Stack();
        
        for(String command : cmd){
            String[] splittedCommand = command.split(" ");
            int moveCount = (splittedCommand.length == 1) ? 0 : Integer.parseInt(splittedCommand[1]);
            
            Node currentNode;
            Node leftNode;
            Node rightNode;
            switch(command.charAt(0)){
                case 'U':
                    while(data[cursor].left != -1 && moveCount-- > 0) {
                        cursor = data[cursor].left;
                    }
                    break;
                case 'D':
                    while(data[cursor].right != -1 && moveCount-- > 0) {
                        cursor = data[cursor].right;
                    }
                    break;
                case 'C':
                    currentNode = data[cursor];
                    if(currentNode.left >= 0){
                        leftNode = data[currentNode.left];
                        leftNode.right = currentNode.right;
                    }
                    if(currentNode.right >= 0){
                        rightNode = data[currentNode.right];
                        rightNode.left = currentNode.left;
                    }
                    
                    removedStack.push(data[cursor]);
                    
                    if(currentNode.right == -1)
                        cursor = currentNode.left;
                    else
                        cursor = currentNode.right;
                    break;
                case 'Z':
                    currentNode = removedStack.pop();
                    if(currentNode.left >= 0){
                        leftNode = data[currentNode.left];
                        leftNode.right = currentNode.number;
                    }
                    if(currentNode.right >= 0){
                        rightNode = data[currentNode.right];
                        rightNode.left = currentNode.number;
                    }
                    
                    break;
            }
            
            // System.out.println("command : " + command + " cursor : " + cursor);
            // for(var v : data)
            //     System.out.printf(" %2d", v.number);
            // System.out.println();
            // for(var v : data)
            //     System.out.printf(" %2d", v.left);
            // System.out.println();
            // for(var v : data)
            //     System.out.printf(" %2d", v.right);
            // System.out.println();
            // System.out.println("stack : ");
            // for(var v : removedStack)
            //     System.out.printf(" %2d", v.number);
            // System.out.println();
            // System.out.println();
        }
            
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        while(!removedStack.isEmpty()){
            var v = removedStack.pop();
            answer[v.number] = 'X';
        }
            
        return String.valueOf(answer);
    }
}


// import java.util.*;

// class Solution {
    
//     public String solution(int n, int k, String[] cmd) {
//         Stack<Integer> removedIndexStack = new Stack();
//         int cursor = k;
//         char[] data = new char[n];
//         Arrays.fill(data, 'O');
        
//         for(String command : cmd){
//             String[] parsedCommand = command.split(" ");
//             int moveCount = (splittedCommand.length == 1) ? 0 : Integer.parseInt(splittedCommand[1]);
            
//             int temp = cursor;
//             switch(parsedCommand[0]){
//                 case "U":
//                     while(moveCount > 0 && --cursor >= 0) {
//                         if(data[cursor] == 'O') {
//                             moveCount--;
//                             temp = cursor;
//                         }
//                     }
//                     cursor = temp;
//                     break;
//                 case "D":
//                     while(moveCount > 0 && ++cursor <= n-1) {
//                         if(data[cursor] == 'O') {
//                             moveCount--;
//                             temp = cursor;
//                         }
//                     }
//                     cursor = temp;
//                     break;
//                 case "C":
//                     moveCount = 1;
//                     data[cursor] = 'X';
//                     removedIndexStack.push(cursor);
                    
//                     while(moveCount > 0 && cursor++ < n-1) {
//                         if(data[cursor] == 'O') {
//                             moveCount--;
//                             temp = cursor;
//                         }
//                     }
//                     while(moveCount > 0 && cursor-- > 0) {
//                         if(data[cursor] == 'O') {
//                             moveCount--;
//                             temp = cursor;
//                         }
//                     }
//                     cursor = temp;
//                     break;
//                 case "Z":
//                     data[removedIndexStack.pop()] = 'O';
//                     break;
//             }
//         }
        
//         return String.valueOf(data);
//     }
// }


// import java.util.*;

// class Solution {
//     class Row{
//         Integer index;
//         Integer data;
//         public Row(Integer index, Integer data){
//             this.index = index;
//             this.data = data;
//         }
//     }
    
//     public String solution(int n, int k, String[] cmd) {
//         int cursor = k;
//         List<Integer> data = new ArrayList<Integer>();
//         for(Integer i=0; i<n; i++){
//             data.add(i);
//         }
//         Stack<Row> removedStack = new Stack();
        
//         for(String command : cmd){
//             switch(command.charAt(0)){
//                 case 'U':
//                     cursor -= Integer.parseInt(command.substring(2, command.length()));
//                     if(cursor < 0) cursor = 0;
//                     break;
//                 case 'D':
//                     cursor += Integer.parseInt(command.substring(2, command.length()));
//                     if(cursor > data.size()-1) cursor = data.size()-1;
//                     break;
//                 case 'C':
//                     removedStack.push(new Row(cursor, data.get(cursor)));
//                     data.remove(cursor);
//                     if(cursor > data.size()-1) cursor = data.size()-1;
//                     break;
//                 case 'Z':
//                     Row row = removedStack.pop();
//                     data.add(row.index, row.data);
//                     if(cursor >= row.index) cursor++;
//                     break;
//             }
//         }
            
//         char[] answer = new char[n];
//         Arrays.fill(answer, 'X');
//         for(int v : data)
//             answer[v] = 'O';
            
//         return String.valueOf(answer);
//     }
// }