package com.tianxiaobo.chapter1.cat_dog_queue;

/**
 * PetCounter
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 22:57:17
 */
public class PetCounter {

    private Pet pet;

    private int count;

    public PetCounter(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }
}
