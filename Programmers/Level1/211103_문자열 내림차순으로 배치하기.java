//https://programmers.co.kr/learn/courses/30/lessons/12917

import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        Character[] chArr = new Character[s.length()];
        for(int i=0; i<s.length(); i++){
            chArr[i] = s.charAt(i);
        }
        
        quickSort(chArr, 0, s.length()-1);
        
        char[] cArr = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            cArr[i] = chArr[i];
        }
        answer = String.valueOf(cArr);
        return answer;
    }
    
    public int partition(Character[] chArr, int leftBorder, int rightBorder){
        int pivot = leftBorder;
        int lowIndex = leftBorder;
        int highIndex = rightBorder+1;
        
        do{
            do{
                lowIndex++;
            }
            while((lowIndex < rightBorder) && (chArr[pivot] < chArr[lowIndex]));
            
            do{
                highIndex--;
            }
            while((highIndex > leftBorder) && (chArr[pivot] > chArr[highIndex]));
            //System.out.println("l[" + lowIndex + "] : " + chArr[lowIndex] + ", h[" + highIndex + "] : " + chArr[highIndex]);
            if (lowIndex < highIndex)
                swap(chArr, lowIndex, highIndex);
        }while(lowIndex < highIndex);
        
          swap(chArr, pivot, highIndex);
        pivot = highIndex;
        //System.out.println("----------리턴 전 : " + Arrays.toString(chArr));
        return pivot;
    }
    
    public void quickSort(Character[] chArr, int left, int right){
        if(left >= right)
            return;
        
        int pivot = partition(chArr, left, right);
        
        quickSort(chArr, left, pivot-1);
        quickSort(chArr, pivot+1, right);
    }
    
    public void swap(Character[] chArr, int i1, int i2){
        Character temp = chArr[i1];
        chArr[i1] = chArr[i2];
        chArr[i2] = temp;
    }
}