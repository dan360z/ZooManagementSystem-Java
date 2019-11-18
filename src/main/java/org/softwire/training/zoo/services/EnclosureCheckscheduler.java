package org.softwire.training.zoo.services;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.EnclosureHasToBeCheckedForWeaknesses;
import org.softwire.training.zoo.models.Keeper;
import org.softwire.training.zoo.models.Scheduler;

import java.util.List;

public class EnclosureCheckscheduler implements Scheduler {
    private static EnclosureCheckscheduler instance;

    private EnclosureCheckscheduler() {
    }

    public static EnclosureCheckscheduler getInstance() {
        if (instance == null) {
            instance = new EnclosureCheckscheduler();
        }
        return instance;
    }

    public void assignJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
            if (animal instanceof EnclosureHasToBeCheckedForWeaknesses) {
                keeper.checkEnclosureForweaknesses((EnclosureHasToBeCheckedForWeaknesses) animal);
            }
        }));
    }
}
