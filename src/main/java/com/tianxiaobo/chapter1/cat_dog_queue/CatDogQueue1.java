package com.tianxiaobo.chapter1.cat_dog_queue;

import java.util.Arrays;

/**
 * Queue: 猫狗队列
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 20:41:42
 */
public class CatDogQueue1 {

    private PetNode header, tail;
    private PetNode dogHeader, dogTail;
    private PetNode catHeader, catTail;

    private int size;

    public CatDogQueue1() {
        init();
    }

    private void init() {
        header = tail = null;
        dogHeader = dogTail = null;
        catHeader = catTail = null;
        size = 0;
    }

    public void add(Pet pet) {
        if (pet == null) {
            return;
        }

        if (!((pet instanceof Dog) || (pet instanceof Cat))) {
            throw new IllegalArgumentException("illegal type");
        }

        size++;
        PetNode node = new PetNode(pet);

        if (header == null) {
            header = tail = node;
            if (isDog(pet)) {
                dogHeader = dogTail = node;
            } else {
                catHeader = catTail = node;
            }

            return;
        }

        tail.next = node;
        tail = node;
        if (isDog(pet)) {
            if (dogHeader == null) {
                dogHeader = dogTail = node;
            } else {
                dogTail.nextDog = node;
                dogTail = node;
            }
        } else {
            if (catHeader == null) {
                catHeader = catTail = node;
            } else {
                catTail.nextCat = node;
                catTail = node;
            }
        }
    }

    public Pet[] pollAll() {
        if (isEmpty()) {
            throw new RuntimeException("there is no more pets");
        }

        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = header.pet;
            header = header.next;
        }

        init();

        return pets;
    }

    public Dog pollDog() {
        if (dogHeader == null) {
            throw new RuntimeException("there is no more dogs");
        }

        Dog dog = (Dog) dogHeader.pet;
        if (dogHeader != dogTail) {
            dogHeader = dogHeader.nextDog;
        } else {
            dogHeader = dogTail = null;
        }

        if (--size == 0) {
            init();
        }

        return dog;
    }

    public Cat pollCat() {
        if (catHeader == null) {
            throw new RuntimeException("there is no more cats");
        }

        Cat cat = (Cat) catHeader.pet;
        if (catHeader != catTail) {
            catHeader = catHeader.nextCat;
        } else {
            catHeader = catTail = null;
        }

        if (--size == 0) {
            init();
        }

        return cat;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isDogEmpty() {
        return dogHeader == null;
    }

    public boolean isCatEmpty() {
        return catHeader == null;
    }

    private boolean isDog(Pet pet) {
        return pet instanceof Dog;
    }

    private class PetNode {
        Pet pet;
        PetNode next;
        PetNode nextDog;
        PetNode nextCat;

        PetNode(Pet pet) {
            this.pet = pet;
        }

        @Override
        public String toString() {
            return "PetNode{" +
                "pet=" + pet +
                '}';
        }
    }

    public static void main(String[] args) {
        CatDogQueue1 queue = new CatDogQueue1();
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
