package services;

import model.Activity;
import java.util.List;

/*
Select the max number of mutually exclusive activities which can be accommodated from the given list
 */
public interface ActivitySelector {
    List<Activity> select(List<Activity> activities);
}
