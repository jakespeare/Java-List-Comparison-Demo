import dto.OpPowerlifterDto;
import dto.UsaplPowerlifterDto;


import static processor.PowerliftingProcessor.runWithDifferentObjectsLists;
import static processor.PowerliftingProcessor.runWithSameObjectsLists;
import static processor.PowerliftingProcessor.runWithSameObjectsSets;

public class Application {

    /**
     * To change the number of records used,
     *
     */

    public static void main(String[] args) {
        UsaplPowerlifterDto usaplPowerlifterDto = new UsaplPowerlifterDto();
        OpPowerlifterDto opPowerlifterDto = new OpPowerlifterDto();


        System.out.println("RUNNING WITH BAD LISTS");
        runWithDifferentObjectsLists();

        System.out.println("RUNNING WITH MAP");
        runWithSameObjectsSets();
        System.out.println("RUNNING WITH GOOD LISTS");
        runWithSameObjectsLists();


        double endTime = System.nanoTime() / 1_000_000_000.0;

        //     System.out.println(PowercreateOpPowerlifter("20").equals(createUsaplPowerlifter(20)));
        //      Assert.assertTrue(createOpPowerlifter("20").equals(createUsaplPowerlifter(20)));
        //      Assert.assertEquals(createOpPowerlifter("20"), createUsaplPowerlifter(20));
    }


}
