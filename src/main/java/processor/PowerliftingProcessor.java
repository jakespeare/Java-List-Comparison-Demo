package processor;

import dto.OpPowerlifterDto;
import dto.PowerlifterDiscrepancyDto;
import dto.UsaplPowerlifterDto;
import service.PowerliftingService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class PowerliftingProcessor {

    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void runWithDifferentObjectsLists() {
        System.out.println("Beginning run with the not fun lists!");
        System.out.println("Initial Memory Usage:");

        calculateMemory();

        System.out.println("Creating OpPowerlifter List ...");


        double startTime = System.nanoTime() / 1_000_000_000.0;
        List<OpPowerlifterDto> opPowerlifters = PowerliftingService.getOpPowerliftersForList();
        double endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds.\n");
        calculateMemory();

        System.out.println("Creating UsaplPowerlifter List...\n");


        startTime = System.nanoTime() / 1_000_000_000.0;
        List<UsaplPowerlifterDto> usaplPowerlifters = PowerliftingService.getUsaplPowerliftersForList();
        endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds");
        calculateMemory();

        System.out.println("Comparing the two lists with custom comparison method and recording discrepancies...");

        startTime = System.nanoTime() / 1_000_000_000.0;

        List<UsaplPowerlifterDto> discrepancies = compareListsComparisonMethod(usaplPowerlifters, opPowerlifters);

        endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds");
        calculateMemory();


        System.out.println("Comparing the two lists and recording discrepancies...");

        startTime = System.nanoTime() / 1_000_000_000.0;

        discrepancies = compareBadLists(usaplPowerlifters, opPowerlifters);

        endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds");
        calculateMemory();



        System.out.println("Finished Running with Lists & Dissimilar Objects");
    }

    public static void runWithSameObjectsLists() {
        System.out.println("Beginning run with Lists of PowerlifterDiscrepancyDtos!");
        System.out.println("Initial Memory Usage:");

        calculateMemory();

        System.out.println("Creating OpPowerlifter List and mapping to our dto...\n");

        double startTime = System.nanoTime() / 1_000_000_000.0;
        List<PowerlifterDiscrepancyDto> opPowerlifters = PowerliftingService.getOpPowerliftersForList().stream()
                .map(opPowerlifter -> new PowerlifterDiscrepancyDto(
                        opPowerlifter.getTotals() == null ? 0.0 : opPowerlifter.getTotals().peek(),
                        String.valueOf(opPowerlifter.getWeightClass()),
                        opPowerlifter.getSex(),
                        opPowerlifter.getAge(),
                        opPowerlifter.getName(),
                        opPowerlifter.getHeaviestTotalDate() == null ? LocalDate.MIN : opPowerlifter.getHeaviestTotalDate().toLocalDate()))
                .collect(Collectors.toList());
        double endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds.\n");

        calculateMemory();

        System.out.println("Creating UsaplPowerlifter List and mapping to our dto into a set...\n");

        startTime = System.nanoTime() / 1_000_000_000.0;

        List<PowerlifterDiscrepancyDto> usaplPowerlifters = PowerliftingService.getUsaplPowerliftersForList().stream()
                .map(usaplPowerlifter -> new PowerlifterDiscrepancyDto(
                        usaplPowerlifter.getTotal(),
                        usaplPowerlifter.getWeightClass(),
                        usaplPowerlifter.getSex(),
                        usaplPowerlifter.getAge(),
                        usaplPowerlifter.getName(),
                        usaplPowerlifter.getHeaviestTotalDate())).collect(Collectors.toList());

        endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds");
        calculateMemory();

        System.out.println("Comparing the two lists and recording discrepancies...\n");

        startTime = System.nanoTime() / 1_000_000_000.0;

        List<PowerlifterDiscrepancyDto> discrepancies = compareLists(usaplPowerlifters, opPowerlifters);

        endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds");
        calculateMemory();

        System.out.println("Finished Running with Lists & Similar Objects");


    }

    public static void runWithSameObjectsSets() {
        System.out.println("Beginning run with Sets of PowerlifterDiscrepancyDtos!");
        System.out.println("Initial Memory Usage:");

        calculateMemory();

        System.out.println("Creating UsaplPowerlifter List and mapping to our dto...\n");

        double startTime = System.nanoTime() / 1_000_000_000.0;
        Set<PowerlifterDiscrepancyDto> opPowerlifters = PowerliftingService.getOpPowerlifters().stream()
                .map(usaplPowerlifter -> new PowerlifterDiscrepancyDto(
                        usaplPowerlifter.getTotals() == null ? 0.0 : usaplPowerlifter.getTotals().peek(),
                        String.valueOf(usaplPowerlifter.getWeightClass()),
                        usaplPowerlifter.getSex(),
                        usaplPowerlifter.getAge(),
                        usaplPowerlifter.getName(),
                        usaplPowerlifter.getHeaviestTotalDate() == null ? LocalDate.MIN : usaplPowerlifter.getHeaviestTotalDate().toLocalDate()))
                .collect(Collectors.toCollection(HashSet::new));
        double endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds.\n");

        calculateMemory();

        System.out.println("Creating OpPowerlifter List and mapping to our dto into a set...\n");

        startTime = System.nanoTime() / 1_000_000_000.0;

        Set<PowerlifterDiscrepancyDto> usaplPowerlifters = PowerliftingService.getUsaplPowerlifters().stream()
                .map(opPowerlifter -> new PowerlifterDiscrepancyDto(
                        opPowerlifter.getTotal(),
                        opPowerlifter.getWeightClass(),
                        opPowerlifter.getSex(),
                        opPowerlifter.getAge(),
                        opPowerlifter.getName(),
                        opPowerlifter.getHeaviestTotalDate())).collect(Collectors.toCollection(HashSet::new));

        endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds");
        calculateMemory();

        System.out.println("Comparing the two sets and recording discrepancies...\n");

        startTime = System.nanoTime() / 1_000_000_000.0;

        List<PowerlifterDiscrepancyDto> discrepancies = compareSets(usaplPowerlifters, opPowerlifters);

        endTime = System.nanoTime() / 1_000_000_000.0;
        System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds");
        calculateMemory();

        System.out.println(discrepancies.size());

        System.out.println("Finished Running with Sets & Similar Objects");
    }


    public static void calculateMemory() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));

    }

    public static List<PowerlifterDiscrepancyDto> compareSets(Set<PowerlifterDiscrepancyDto> usaplPowerlifters,
                                                              Set<PowerlifterDiscrepancyDto> opPowerlifters) {
        List<PowerlifterDiscrepancyDto> discrepancies = new ArrayList<>();
        usaplPowerlifters.forEach(usaplPowerlifter -> {
            if (!opPowerlifters.contains(usaplPowerlifter)) {
                discrepancies.add(usaplPowerlifter);
            }
        });
        return discrepancies;
    }

    public static List<PowerlifterDiscrepancyDto> compareLists(List<PowerlifterDiscrepancyDto> usaplPowerlifters, List<PowerlifterDiscrepancyDto> opPowerlifters) {
        List<PowerlifterDiscrepancyDto> discrepancies = new ArrayList<>();
        usaplPowerlifters.forEach(usaplPowerlifter -> {
            double startTime = System.nanoTime() / 1_000_000_000.0;

            if (!opPowerlifters.contains(usaplPowerlifter)) {
                discrepancies.add(usaplPowerlifter);
            }
            double endTime = System.nanoTime() / 1_000_000_000.0;
            System.out.println("Took " + String.format("%.2f", (endTime - startTime)) + " seconds");
        });
        return discrepancies;
    }

    /*
        Comparing with different objects but overriden equals method
     */
    public static List<UsaplPowerlifterDto> compareBadLists(List<UsaplPowerlifterDto> usaplPowerlifters, List<OpPowerlifterDto> opPowerlifters) {
        List<UsaplPowerlifterDto> discrepancies = new ArrayList<>();
        AtomicBoolean found = new AtomicBoolean(false);
        //Can't write own contains Method because we do not own OpPowerlifterDto
        //So this is essentially a hack contains method!
        usaplPowerlifters.forEach(usaplPowerlifter -> {
            opPowerlifters.forEach(opPowerlifter -> {
                if (usaplPowerlifter.equals(opPowerlifter)) {
                    found.set(true);
                }
            });
            if (!found.get()) {
                discrepancies.add(usaplPowerlifter);
            }
            found.set(false);
        });
        return discrepancies;
    }

    /*
        Comparing with different objects but compare() method.
     */
    public static List<UsaplPowerlifterDto> compareListsComparisonMethod(List<UsaplPowerlifterDto> usaplPowerlifters, List<OpPowerlifterDto> opPowerlifters) {
        List<UsaplPowerlifterDto> discrepancies = new ArrayList<>();

        //Can't write own contains Method because we do not own OpPowerlifterDto
        //So this is essentially a hack contains method!
        AtomicBoolean found = new AtomicBoolean(false);

        usaplPowerlifters.forEach(usaplPowerlifter -> {
            opPowerlifters.forEach(opPowerlifter -> {
                if (compareLifters(usaplPowerlifter,opPowerlifter)) {
                    found.set(true);
                }
            });
            if (!found.get()) {
                discrepancies.add(usaplPowerlifter);
            }
            found.set(false);
        });
        return discrepancies;
    }

    public static boolean compareLifters(UsaplPowerlifterDto usaplPowerlifter, OpPowerlifterDto opPowerlifter) {
        return Objects.equals(usaplPowerlifter.getTotal(), opPowerlifter.getTotals().peek())
                && Objects.equals(usaplPowerlifter.getAge(), opPowerlifter.getAge())
                && Objects.equals(usaplPowerlifter.getName(), opPowerlifter.getName())
                && Objects.equals(usaplPowerlifter.getWeightClass(), String.valueOf(opPowerlifter.getWeightClass()))
                && Objects.equals(usaplPowerlifter.getSex(), opPowerlifter.getSex());
    }


}
