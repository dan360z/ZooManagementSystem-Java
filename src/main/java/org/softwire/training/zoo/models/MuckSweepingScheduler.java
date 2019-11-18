package org.softwire.training.zoo.models;

import java.util.List;

public class MuckSweepingScheduler implements Scheduler {
    private static MuckSweepingScheduler instance;

    private MuckSweepingScheduler() {
    }

    public static MuckSweepingScheduler getInstance() {
        if (instance == null) {
            instance = new MuckSweepingScheduler();
        }
        return instance;
    }

    public void assignJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
            if (animal instanceof CanHaveMuckSweptOut) {
                keeper.sweepMuck((CanHaveMuckSweptOut) animal);
            }
        }));
    }

}
