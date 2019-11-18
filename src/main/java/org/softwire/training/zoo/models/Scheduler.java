package org.softwire.training.zoo.models;

import java.util.List;

public interface Scheduler {
    void assignJobs(List<Keeper<? extends Animal>> keepers);
}
