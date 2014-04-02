package com.test.ejb.second;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Remote
@Stateful
public class StatefullEjbBean implements StatefullEjb {
    
    private int state;

    @Override
    public void compute(int i) {
        state += i;
    }

    @Override
    public int getResults() {
        return state;
    }

}
