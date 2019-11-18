package org.softwire.training.zoo.models;

import java.time.LocalDate;

public class Lion extends AbstractAnimal implements LargeAnimal, CanHaveMuckSweptOut {
    public Lion(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void sweepMuck() {
        System.out.println("Lion paddock muck sweeping done.");
    }
}
