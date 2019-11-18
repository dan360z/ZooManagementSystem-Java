package org.softwire.training.zoo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Keeper<T extends Animal> {
    private List<T> animals;

    public Keeper(List<T> animals) {
        this.animals = new ArrayList<>(animals);
    }

    public List<T> getResponsibleAnimals() {
        return new ArrayList<>(animals);
    }

    public void startLookingAfter(T animal) {
        this.animals.add(animal);
    }

    public void groom(CanBeGroomed animal) {
        animal.groom();
    }

    public void feed(Animal animal) {
        animal.feed();
    }

    public void sweepMuck(CanHaveMuckSweptOut animal) {
        System.out.println("Muck sweeping in progress...");
        animal.sweepMuck();
    }

    public void checkEnclosureForweaknesses(EnclosureHasToBeCheckedForWeaknesses animal) {
        System.out.println("Enclosure check in Progress...");
        animal.checkEnclosureForWeaknesses();
    }



}
