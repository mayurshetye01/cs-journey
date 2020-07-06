package ch16.s1;

import model.Activity;
import services.ActivitySelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IterativeGreedyActivitySelector implements ActivitySelector {
    @Override
    public List<Activity> select(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparing(Activity::getEndTime));

        List<Activity> result = new ArrayList<>();
        //Make the greedy choice, so that there is maximum space/time for other activities to be selected
        Activity latest = activities.get(0);
        result.add(latest);
        for(int i = 1; i < activities.size(); i++){
            Activity current = activities.get(i);
            if(current.startsAfter(latest)){
                result.add(current);
                latest = current;
            }
        }
        return result;
    }
}
