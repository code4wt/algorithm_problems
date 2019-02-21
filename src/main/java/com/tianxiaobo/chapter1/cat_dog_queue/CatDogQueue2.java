package com.tianxiaobo.chapter1.cat_dog_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue: 猫狗队列
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 20:41:42
 */
public class CatDogQueue2 {

    private Queue<PetCounter> dogs = new LinkedList<>();
    private Queue<PetCounter> cats = new LinkedList<>();

    private int count;

    public void add(Pet pet) {
        if (pet == null) {
            return;
        }

        if (!((pet instanceof Dog) || (pet instanceof Cat))) {
            throw new IllegalArgumentException("illegal type");
        }

        PetCounter pc = new PetCounter(pet, count++);
        if (isDog(pet)) {
            dogs.add(pc);
        } else {
            cats.add(pc);
        }
    }

    public Pet[] pollAll() {
        if (isEmpty()) {
            throw new RuntimeException("No Pet instance in the queue");
        }

        int size = cats.size() + dogs.size();
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            if (cats.isEmpty()) {
                pets[i] = dogs.poll().getPet();
                continue;
            }
            if (dogs.isEmpty()) {
                pets[i] = cats.poll().getPet();
                continue;
            }

            PetCounter cat = cats.peek();
            PetCounter dog = dogs.peek();
            pets[i] = cat.getCount() > dog.getCount() ? dogs.poll().getPet() : cats.poll().getPet();
        }

        return pets;
    }

    public Dog pollDog() {
        if (isDogEmpty()) {
            throw new RuntimeException("No Dog instance in the queue");
        }
        return (Dog) dogs.poll().getPet();
    }

    public Cat pollCat() {
        if (isCatEmpty()) {
            throw new RuntimeException("No Cat instance in the queue");
        }
        return (Cat) cats.poll().getPet();
    }

    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogs.isEmpty();
    }

    public boolean isCatEmpty() {
        return cats.isEmpty();
    }

    private boolean isDog(Pet pet) {
        return pet instanceof Dog;
    }

    public static void main(String[] args) {
        CatDogQueue2 queue = new CatDogQueue2();
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Cat());
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Dog());

        System.out.println(queue.pollCat());
        System.out.println(queue.pollCat());
        System.out.println(queue.pollCat());
        System.out.println(queue.isCatEmpty());
        queue.add(new Cat());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isDogEmpty());
        System.out.println(queue.pollDog());
        System.out.println(queue.pollDog());
        System.out.println(queue.pollDog());
        System.out.println(queue.isDogEmpty());
        System.out.println(queue.pollCat());
        queue.add(new Dog());
        queue.add(new Cat());
        queue.add(new Dog());
        System.out.println(Arrays.toString(queue.pollAll()));
        queue.add(new Cat());
        System.out.println(Arrays.toString(queue.pollAll()));
        queue.add(new Dog());
        queue.add(new Dog());
        queue.add(new Cat());
        System.out.println(Arrays.toString(queue.pollAll()));
    }
}
