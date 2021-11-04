//https://programmers.co.kr/learn/courses/30/lessons/72410

class Solution {
    public String solution(String new_id) {
    	String level1 = Replacer.level1(new_id);
    	String level2 = Replacer.level2(level1);
    	String level3 = Replacer.level3(level2);
    	String level4 = Replacer.level4(level3);
    	String level5 = Replacer.level5(level4);
    	String level6 = Replacer.level6(level5);
    	//String level7 = Replacer.level7(level6);
        String answer = Replacer.level7(level6);
        return answer;
    }
}

class Logger{
	public static void WriteLog(String message){
		String methodName = Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName();
		
		StringBuilder logString = new StringBuilder();
		//logString.append("Project : ");
		//logString.append(", ");
		//logString.append("Class : ");
		//logString.append(", ");
		logString.append("Method : ");
		logString.append(methodName);
		logString.append(", LogMessage : ");
		logString.append(message);
		
		System.out.println(logString);
	}
}

class Replacer{
    public static String level1(String input) {
    	//Logger.WriteLog("input : " + input);
    	String output = input;
    	
    	output =  input.toLowerCase();

    	Logger.WriteLog("output : " + output + ", length = " + output.length());
        return output;
    }
    
    public static String level2(String input) {
    	//Logger.WriteLog("input : " + input);
    	String output = input;
    	
    	String filter = "abcdefghijklmnopqrstuvwxyz0123456789-_.";
    	char[] arFilter = filter.toCharArray();
    	
    	char[] arInput = input.toCharArray();
    	char[] arOutput = new char[arInput.length];
    	int index = 0;
    	for(var inputItem : arInput) {
    		boolean bDetected = false;
    		
    	    for(var filterItem : arFilter) {
    		  if(inputItem == filterItem) {
        		  bDetected = true;
        		  break;
    		  }
    	    }
    	    
    	    if (!bDetected) {
    	    	//index++;
    	    	continue;
    	    }
    	    
        	//Logger.WriteLog("index : " + index + ", add : " + inputItem);
    	    arOutput[index] = inputItem;
    	    index++;
    	}
    	
    	output = new String(arOutput);
    	output = output.trim();
    	Logger.WriteLog("output : " + output + ", length = " + output.length());
    	
    	return output;
    }

    public static String level3(String input) {
    	//Logger.WriteLog("input : " + input);
    	String output = input;
    	
    	char[] arInput = input.toCharArray();
    	char[] arOutput = new char[arInput.length];
    			
		boolean isPreviousItemDot = false;
		int index = 0;
    	for(var inputItem : arInput) {
    		if (inputItem == '.') {
    			if(isPreviousItemDot) {
        			isPreviousItemDot = true;
    				continue;
    			}
    			isPreviousItemDot = true;
    		}else {
    			isPreviousItemDot = false;
    		}
    		
    		arOutput[index++] = inputItem;
    	}
    	
    	output = new String(arOutput);
        output = output.trim();
    	Logger.WriteLog("output : " + output + ", length = " + output.length());
    	return output;
    }

    public static String level4(String input) {
    	String output = input;
    	
    	if (input.length() == 0) {
    		return "";
    	}

    	var a = input.charAt(0);
    	if (input.length() == 1) {
    		if (a == '.') {
    			return "";
    		}
    		else {
    			return output;
    		}
    	}
    	
    	if (a == '.') {
    		output = input.substring(1);
    	}

    	var b = input.charAt(input.length()-1);
    	if (output.length() == 1) {
    		if (b == '.') {
    			return "";
    		}
    		else {
    			return output;
    		}
    	}
    	
    	if (b == '.') {
    		output = output.substring(0, output.length() - 1);
    	}

    	Logger.WriteLog("output : " + output + ", length = " + output.length());
    	return output;
    }

    public static String level5(String input) {
    	String output = input;

    	if (input.length() == 0) {
    		output = "a";
    	}
    	
    	Logger.WriteLog("output : " + output + ", length = " + output.length());
    	return output;
    }

    public static String level6(String input) {
    	String output = input;
    	
    	if (input.length() >= 16) {
    		output = input.substring(0, 15);
    	}
    	
    	output = level4(output);

    	Logger.WriteLog("output : " + output + ", length = " + output.length());
    	return output;
    }
    
    public static String level7(String input) {
    	String output = input;
    	
    	if (input.length() <= 2) {
    		while (output.length() <= 2) {
    			output = output + input.charAt(input.length() - 1);
    		}
    	}

    	Logger.WriteLog("output : " + output + ", length = " + output.length());
    	return output;
    }
}