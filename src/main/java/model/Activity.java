package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Activity {
    private Integer id;
    private Integer startTime;
    private Integer endTime;

    public boolean startsAfter(Activity that){
        return this.getStartTime() >= that.getEndTime();
    }
}
