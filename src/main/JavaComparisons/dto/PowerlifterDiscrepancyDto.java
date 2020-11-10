package JavaComparisons.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class that you would convert the other 2 DTOs into
 */
public class PowerlifterDiscrepancyDto {
    private Double total;
    private String weightClass;
    private String sex;
    private Integer age;
    private String name;
    private LocalDate heaviestTotalDate;

    public PowerlifterDiscrepancyDto(Double total, String weightClass, String sex, Integer age, String name, LocalDate heaviestTotalDate) {
        this.total = total;
        this.weightClass = weightClass;
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.heaviestTotalDate = heaviestTotalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerlifterDiscrepancyDto)) return false;

        PowerlifterDiscrepancyDto that = (PowerlifterDiscrepancyDto) o;
        //Replace the field comparisons with the hashCode.
        return this.hashCode() == that.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, weightClass, sex, age, name);
    }
}
