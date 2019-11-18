package org.softwire.training.zoo.models;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class TRex extends AbstractAnimal implements LargeAnimal, CanBeGroomed, EnclosureHasToBeCheckedForWeaknesses, CanHaveMuckSweptOut {
    private LocalDateTime lastGroomed;

    public TRex(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void feed() {
        System.out.println("Chomp!");
        super.feed();
    }

    @Override
    public void groom() {
        lastGroomed = LocalDateTime.now();
    }

    @Override
    public void sweepMuck() {
        System.out.println("T-Rex enclosure muck sweeping done.");
    }

    public static int getRandom(int max){
        return (int) (Math.random()*max);
    }

    @Override
    public void checkEnclosureForWeaknesses() {
        if(getRandom(10) == 1) {
            System.out.println("⚠︎ T-Rex escaped and ate everyone!!! ⚠︎");
        } else {
            System.out.println("T-Rex enclosure checked and is safe.");
        }
    }
}
