package common;

import model.Activity;
import org.junit.jupiter.api.Test;
import services.ActivitySelector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class ActivitySelectorTest {
    protected abstract ActivitySelector getActivitySelector();

    @Test
    void testActivitySelector() {
        final ActivitySelector activitySelector = getActivitySelector();

        List<Activity> activities = getActivities();
        List<Activity> selectedActivities = activitySelector.select(activities);
        List<Integer> result = new ArrayList<>();
        selectedActivities.forEach(activity -> result.add(activity.getId()));
        List<Integer> expected = Arrays.asList(1, 4, 8, 11);

        assertEquals(expected.size(), result.size());
        assertTrue(expected.containsAll(result));
    }

    private List<Activity> getActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 1, 4));
        activities.add(new Activity(2, 3, 5));
        activities.add(new Activity(3, 0, 6));
        activities.add(new Activity(4, 5, 7));
        activities.add(new Activity(5, 3, 9));
        activities.add(new Activity(6, 5, 9));
        activities.add(new Activity(7, 6, 10));
        activities.add(new Activity(8, 8, 11));
        activities.add(new Activity(9, 8, 12));
        activities.add(new Activity(10, 2, 14));
        activities.add(new Activity(11, 12, 16));
        return activities;
    }
}
