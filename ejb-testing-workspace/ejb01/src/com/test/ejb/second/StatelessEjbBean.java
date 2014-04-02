package com.test.ejb.second;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
@Stateless
public class StatelessEjbBean implements StatelessEjb {
    
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
