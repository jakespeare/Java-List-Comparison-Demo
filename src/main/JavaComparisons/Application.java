package JavaComparisons;

import JavaComparisons.dto.OpPowerlifterDto;
import JavaComparisons.dto.UsaplPowerlifterDto;

import static JavaComparisons.processor.PowerliftingProcessor.*;

public class Application {

    /**
     * To change the number of records used, change RECORDS or LIST_RECORDS in the PowerliftingService.
     */

    public static void main(String[] args) {
        UsaplPowerlifterDto usaplPowerlifterDto = new UsaplPowerlifterDto();
        OpPowerlifterDto opPowerlifterDto = new OpPowerlifterDto();


        System.out.println("RUNNING WITH BAD LISTS");
        //    runWithDifferentObjectsLists();

        System.out.println("RUNNING WITH MAP");
        //    runWithSameObjectsSets();
        System.out.println("RUNNING WITH GOOD LISTS");
        //    runWithSameObjectsLists();
        System.out.println("RUNNING WITH LISTS AND HASHMAP IMPL");
        runWithSameObjectsHashMapComparison();

    }
}