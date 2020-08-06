package dto;

import java.time.LocalDate;

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



   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerlifterDiscrepancyDto)) return false;

        PowerlifterDiscrepancyDto that = (PowerlifterDiscrepancyDto) o;
        //Replace the field comparisons with the hashCode.
        return this.hashCode() == that.hashCode();
    }
*/

    /*
        Generated by IntelliJ
     */
    @Override
    public int hashCode() {
        int result = total != null ? total.hashCode() : 0;
        result = 31 * result + (weightClass != null ? weightClass.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (heaviestTotalDate != null ? heaviestTotalDate.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
