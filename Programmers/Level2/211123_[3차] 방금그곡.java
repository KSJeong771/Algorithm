//https://programmers.co.kr/learn/courses/30/lessons/17683#

class Solution {
    public String solution(String m, String[] musicinfos) {
        String maxTitle = "";
        int maxTime = -1;
        
        m = removeSharp(m);
        
        int index = -1;
        for(var musicinfo : musicinfos){
            index++;
            var parsedMusicinfo = musicinfo.split(",");
            int runningTime = timeToMinute(parsedMusicinfo[1]) - timeToMinute(parsedMusicinfo[0]);
            String title = parsedMusicinfo[2];
            String lyrics = removeSharp(parsedMusicinfo[3]);
            
            String runningLyrics = "";
            for(int i=0; i<runningTime; i++){
                runningLyrics += lyrics.substring(i % lyrics.length(), i % lyrics.length() + 1);
            }
            
            if(!runningLyrics.contains(m))
                continue;
            
            if(maxTime >= runningTime)
                continue;
            
            maxTime = runningTime;
            maxTitle = title;
            //System.out.println(title + " " + runningLyrics);
        }
        
        if(maxTime == -1)
            maxTitle = "(None)";
        
        return maxTitle;
    }
    
    
    public int timeToMinute(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return (hour * 60) + minute;
    }
    
    public String removeSharp(String lyrics){
        lyrics = lyrics.replace("C#", "H");
        lyrics = lyrics.replace("D#", "I");
        lyrics = lyrics.replace("F#", "J");
        lyrics = lyrics.replace("G#", "K");
        lyrics = lyrics.replace("A#", "L");
        return lyrics;
    }
    
}