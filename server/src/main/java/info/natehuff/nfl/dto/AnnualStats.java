package info.natehuff.nfl.dto;

public class AnnualStats {

    private Record record;
    private double annualProfit;

    public AnnualStats(Record record, double annualProfit) {
        this.record = record;
        this.annualProfit = annualProfit;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public double getAnnualProfit() {
        return annualProfit;
    }

    public void setAnnualProfit(double annualProfit) {
        this.annualProfit = annualProfit;
    }
}
