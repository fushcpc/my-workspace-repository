package com.j2se.Interview.howmanycowsin20years;

import java.util.Collection;
import java.util.HashSet;

public class Farm {
    private Collection<Cow> cows = new HashSet<Cow>();

    public Collection<Cow> getCows() {
        return cows;
    }

    public void addCows(Collection<Cow> newCows) {
        cows.addAll(newCows);
    }

    @Override
    public String toString() {
        return "Farm [cows=" + cows + "]";
    }

}
