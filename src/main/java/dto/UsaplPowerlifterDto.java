package dto;

import java.time.LocalDate;
import java.util.Objects;

public class UsaplPowerlifterDto {
    private Double total;
    private Double squatTotal;
    private Double benchTotal;
    private Double deadliftTotal;
    private String weightClass;
    private String sex;
    private Integer age;
    private String name;
    private LocalDate heaviestTotalDate;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSquatTotal() {
        return squatTotal;
    }

    public void setSquatTotal(Double squatTotal) {
        this.squatTotal = squatTotal;
    }

    public Double getBenchTotal() {
        return benchTotal;
    }

    public void setBenchTotal(Double benchTotal) {
        this.benchTotal = benchTotal;
    }

    public Double getDeadliftTotal() {
        return deadliftTotal;
    }

    public void setDeadliftTotal(Double deadliftTotal) {
        this.deadliftTotal = deadliftTotal;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
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

    public LocalDate getHeaviestTotalDate() {
        return heaviestTotalDate;
    }

    public void setHeaviestTotalDate(LocalDate heaviestTotalDate) {
        this.heaviestTotalDate = heaviestTotalDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpPowerlifterDto)) return false;

        return  Objects.equals(this.total, ((OpPowerlifterDto) o).getTotals().peek())
                && Objects.equals(this.age, ((OpPowerlifterDto) o).getAge())
                &&  Objects.equals(this.name, ((OpPowerlifterDto) o).getName())
                &&  Objects.equals(this.weightClass, String.valueOf(((OpPowerlifterDto) o).getWeightClass()))
                &&  Objects.equals(this.sex, ((OpPowerlifterDto) o).getSex());
    }
}
