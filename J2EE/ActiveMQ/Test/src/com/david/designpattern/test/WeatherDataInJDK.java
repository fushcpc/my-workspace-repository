package com.david.designpattern.test;

public class WeatherDataInJDK {
    void setChanged() {
        changed = true;
    }

    void notifyObservers(Object arg){
        if(changed){
            for every observer on the list{
                call update(this, arg);
            }
            changed = false;
        }
    }

    void measurementsChanged() {
        setChanged();
        notifyObservers(null);
    }
}
