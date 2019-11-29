package org.softwire.training.zoo.services;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Keeper;

import java.util.List;

public interface Scheduler {
    void assignJobs(List<Keeper<? extends Animal>> keepers);
}
