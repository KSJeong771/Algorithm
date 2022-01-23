//https://programmers.co.kr/learn/courses/30/lessons/42860

import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        //알파벳 바꾸는 시간
        int changeAlphabet = 0;
        for(int i=0; i<name.length(); i++){
            int a = Math.min((name.charAt(i) - 'A'), ('Z' - name.charAt(i) + 1));
            // System.out.println(name.charAt(i) + " " + a);
            changeAlphabet += a;
        }
       
        //오른쪽으로 쭉 이동하는 시간
        int rightStraight = name.length()-1;
        for(int i=name.length()-1; i>=0; i--){
            rightStraight = i;
            if(name.charAt(i) != 'A') break;
        }
        
        int rightMin = rightStraight;
        
        //시작점을 제외한 모든 점에서 오른쪽으로 갔다가 왼쪽으로 꺾는 시간을 체크
        for(int i=1; i<name.length(); i++){
            //A 인덱스
            int indexA = i;
            for(int j=i; j<name.length(); j++){
                indexA = j;
                if(name.charAt(j) == 'A') break;
            }
            int lengthA = 0;
            for(int j=indexA; j<name.length(); j++){
                if(name.charAt(j) != 'A') break;
                lengthA++;
            }
            int rightTurn = (2 * (indexA-1)) + (name.length() - indexA - lengthA);
            rightMin = Math.min(rightMin, rightTurn);
        
        // System.out.println("indexA : " + indexA + " lengthA : " + lengthA
        //                    + " rightTurn : " + rightTurn + " rightStraight : " + rightStraight
        //                    + " rightMin : " + rightMin);
        }
        
        //왼쪽으로 쭉 이동하는 시간
        int leftStraight = name.length()-1;
        for(int i=name.length()-1; i>=0; i--){
            leftStraight = i;
            if(name.charAt(i) != 'A') break;
        }
        
        int leftMin = leftStraight;
        
        //시작점을 제외한 모든 점에서 왼쪽으로 갔다가 오른쪽으로 꺾는 시간을 체크
        for(int i=name.length()-1; i>0; i--){
            //A 인덱스
            int indexA = i;
            for(int j=i; j>=0; j--){
                indexA = j;
                if(name.charAt(j) == 'A') break;
            }
            int lengthA = 0;
            for(int j=indexA; j>=0; j--){
                if(name.charAt(j) != 'A') break;
                lengthA++;
            }
            int doubled = (2 * (name.length()-1-indexA));
            int remaining = (indexA - lengthA < 0) ? 0 : indexA - lengthA;
            int leftTurn = doubled + remaining;
            leftMin = Math.min(leftMin, leftTurn);
        
        // System.out.println("indexA : " + indexA + " lengthA : " + lengthA
        //                    + " leftTurn : " + leftTurn + " leftStraight : " + leftStraight
        //                    + " leftMin : " + leftMin + " doubled : " + doubled + " remaining : " + remaining);
        }
        
        System.out.println("rightMin : " + rightMin + " leftMin : " + leftMin + " changeAlphabet : " + changeAlphabet);
        return changeAlphabet + Math.min(rightMin, leftMin);
    }
}