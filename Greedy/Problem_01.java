package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair{
    int start;
    int end;
    public Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}

// Maxmimum meetings
public class Problem_01 {
    public static int maximumMeetings(int []start, int []end) {
        List<Pair> meeting = new ArrayList<Pair>();
        for(int i = 0; i < start.length; i++){
            meeting.add(new Pair(start[i],end[i]));
        }
        Collections.sort(meeting,(a,b) -> a.end - b.end);
        int e = meeting.get(0).end;
        int maxMeetings = 1;
        for(int i = 1; i < meeting.size(); i++){
            if(meeting.get(i).start > e){
                maxMeetings++;
                e = meeting.get(i).end;
            }
        }
        return maxMeetings;
    }
}
