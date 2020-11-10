package dto;

import java.time.ZonedDateTime;
import java.util.Stack;
/**
    Pretend We Don't Control This
 */
public class OpPowerlifterDto {
    private Stack<Double> totals;
    private Stack<Double> squatTotals;
    private Stack<Double> benchTotals;
    private Stack<Double> deadliftTotals;
    private Integer weightClass;
    private String sex;
    private Integer age;
    private String name;
    private ZonedDateTime heaviestTotalDate;

    public Stack<Double> getTotals() {
        return totals;
    }

    public void setTotals(Stack<Double> totals) {
        this.totals = totals;
    }

    public Integer getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(Integer weightClass) {
        this.weightClass = weightClass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getHeaviestTotalDate() {
        return heaviestTotalDate;
    }

    public void setHeaviestTotalDate(ZonedDateTime heaviestTotalDate) {
        this.heaviestTotalDate = heaviestTotalDate;
    }

    public Stack<Double> getSquatTotals() {
        return squatTotals;
    }

    public void setSquatTotals(Stack<Double> squatTotals) {
        this.squatTotals = squatTotals;
    }

    public Stack<Double> getBenchTotals() {
        return benchTotals;
    }

    public void setBenchTotals(Stack<Double> benchTotals) {
        this.benchTotals = benchTotals;
    }

    public Stack<Double> getDeadliftTotals() {
        return deadliftTotals;
    }

    public void setDeadliftTotals(Stack<Double> deadliftTotals) {
        this.deadliftTotals = deadliftTotals;
    }
}
