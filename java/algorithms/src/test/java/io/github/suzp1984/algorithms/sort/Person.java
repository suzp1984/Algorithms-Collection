package io.github.suzp1984.algorithms.sort;

import com.sun.istack.internal.NotNull;

/**
 * Created by jacobsu on 9/17/16.
 */
public class Person implements Comparable<Person> {

    private int mAge;

    public Person(int age) {
        this.mAge = age;
    }

    public int getAge() {
        return mAge;
    }

    @Override
    public int compareTo(@NotNull Person o) {
        if (o == null) {
            throw new NullPointerException("Person parameter can not be null.");
        }

        return this.mAge - o.mAge;
    }
}
