//https://programmers.co.kr/learn/courses/30/lessons/72411

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

class Solution {
	static int max = 0;
	static HashMap<String, Integer> hmap = new HashMap<>();
	
	public static void func (String order, int course, String currentOrder) {
		if (currentOrder.length() <= course) {
            if (hmap.containsKey(currentOrder)) {
                Integer value = hmap.get(currentOrder);
                hmap.put(currentOrder, ++value);
			}else {
	            hmap.put(currentOrder, 1);
			}
		}		
		for (int i=0; i< order.length(); i++) {
			func(order.substring(i+1), course, currentOrder + order.charAt(i));
		}
	}
	
	public static void sortChar(char[] arInput, int startLeft, int startRight) {
		
		return;
	}
	
	public static void swap(char[] array, int a, int b) {
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	

    
    public String[] solution(String[] orders, int[] course) {
        List<String> lst = new ArrayList<>();
		for (var courseItem : course) {
			for (var orderItem : orders) {
				char[] arOrderItem = orderItem.toCharArray();
				Arrays.sort(arOrderItem);
				func(new String(arOrderItem), courseItem, "");
			}
			
			max = 0;
			hmap.forEach((key, value) -> {
				if (value <= 1) {
					return;
				}
				
				if (key.length() != courseItem) {
					return;
				}
				
				int val2 = value;
				if (max < val2) {
					max = val2;
				}
			});
			
			hmap.forEach((key, value) -> {
				if (value <= 1) {
					return;
				}

				if (value != max) {
					return;
				}
				
				if (key.length() != courseItem) {
					return;
				}
				
				lst.add(key);
			}); 
			
			hmap = new HashMap<String, Integer>();
		}
		
		lst.sort(Comparator.naturalOrder());
		
		String[] answer = (String[]) lst.toArray(new String[0]);
        return answer;
    }
}