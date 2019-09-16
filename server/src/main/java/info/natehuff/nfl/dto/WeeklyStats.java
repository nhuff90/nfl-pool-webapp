package info.natehuff.nfl.dto;

import info.natehuff.nfl.data.mysql.model.WeeklyRecord;

public class WeeklyStats {

    private WeeklyRecord weeklyRecord;
    private double weeklyProfit;

    public WeeklyStats(WeeklyRecord weeklyRecord, double weeklyProfit) {
        this.weeklyRecord = weeklyRecord;
        this.weeklyProfit = weeklyProfit;
    }

    public WeeklyRecord getWeeklyRecord() {
        return weeklyRecord;
    }

    public void setWeeklyRecord(WeeklyRecord weeklyRecord) {
        this.weeklyRecord = weeklyRecord;
    }

    public double getWeeklyProfit() {
        return weeklyProfit;
    }

    public void setWeeklyProfit(double weeklyProfit) {
        this.weeklyProfit = weeklyProfit;
    }
}
