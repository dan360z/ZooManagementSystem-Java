package org.softwire.training.zoo;

import org.softwire.training.zoo.models.*;
import org.softwire.training.zoo.services.EnclosureCheckscheduler;
import org.softwire.training.zoo.services.FeedingScheduler;
import org.softwire.training.zoo.services.GroomingScheduler;
import org.softwire.training.zoo.services.Scheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<LargeAnimal> largeAnimals = Arrays.asList(
                new Lion(LocalDate.of(2010, 4, 28)),
                new Lion(LocalDate.of(2012, 5, 11)),
                new Zebra(LocalDate.of(2008, 12, 1)),
                new TRex(LocalDate.of(2001, 12, 1))
        );
        List<SmallAnimal> smallAnimals = Collections.singletonList(
                new Rabbit(LocalDate.of(2014, 1, 1))
        );
        List<Animal> animals = new ArrayList<>();
        animals.addAll(largeAnimals);
        animals.addAll(smallAnimals);

        Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
        Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);

        List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);

        Rabbit babyRabbit = new Rabbit(LocalDate.now());
        smallAnimalKeeper.startLookingAfter(babyRabbit);


        List<Scheduler> schedulers = new ArrayList<>();

        schedulers.add(FeedingScheduler.getInstance());
        schedulers.add(GroomingScheduler.getInstance());
        schedulers.add(MuckSweepingScheduler.getInstance());
        schedulers.add(EnclosureCheckscheduler.getInstance());

        for (Scheduler scheduler: schedulers) {
           scheduler.assignJobs(keepers);
        }

        animals.forEach(System.out::println);
    }
}
