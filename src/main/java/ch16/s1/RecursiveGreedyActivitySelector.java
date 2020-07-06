package ch16.s1;

import model.Activity;
import services.ActivitySelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RecursiveGreedyActivitySelector implements ActivitySelector {
    @Override
    public List<Activity> select(List<Activity> activities) {
        //Add fictitious activity a0 with finish time 0
        activities.add(new Activity(0, 0, 0));
        Collections.sort(activities, Comparator.comparing(Activity::getEndTime));
        //Make the greedy choice, so that there is maximum space/time for other activities to be selected
        return select(activities, 0);
    }

    private List<Activity> select(List<Activity> activities, int latestActivityIndex) {
        List<Activity> result = new ArrayList<>();
        int numberOfActivities = activities.size();
        int currIndex = latestActivityIndex + 1;
        Activity latest = activities.get(latestActivityIndex);
        while (currIndex < numberOfActivities && !activities.get(currIndex).startsAfter(latest)) {
            currIndex++;
        }
        if (currIndex < numberOfActivities) {
            result.add(activities.get(currIndex));
            result.addAll(select(activities, currIndex));
        }
        return result;
    }
}
