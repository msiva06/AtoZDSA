package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Maximum activities
public class Problem_02 {
     public static int maximumActivities(List<Integer> start, List<Integer> end) {
        List<Pair> activities = new ArrayList<>();
        for(int i = 0; i < start.size(); i++){
            activities.add(new Pair(start.get(i),end.get(i)));
        }
        Collections.sort(activities,(a,b) -> a.end - b.end);
        int activity = 1;
        int e = activities.get(0).end;
        for(int i = 1; i < activities.size();i++){
            if(activities.get(i).start >= e){
                activity++;
                e = activities.get(i).end;
            }
        }
        return activity;
    }
}
