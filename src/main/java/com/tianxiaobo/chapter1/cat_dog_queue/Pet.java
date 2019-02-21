package com.tianxiaobo.chapter1.cat_dog_queue;

/**
 * Pet
 *
 * @author Tian ZhongBo
 * @date 2019-02-21 20:39:45
 */
public class Pet {

    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pet{" +
            "type='" + type + '\'' +
            '}';
    }
}
