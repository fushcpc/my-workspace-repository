package com.j2se.Interview.howmanycowsin20years;

import java.util.Collection;
import java.util.HashSet;

/**
 * 农场一头小母牛
 * 每年生头小母牛
 * 母牛五岁产母牛
 * 二十年上多少牛
 * @author Administrator
 *
 */
public class HowManyCowsIn20Years {

    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.getCows().add(new Cow(0));
        for (int i = 0; i < 20; i++) {
            Collection<Cow> newBornCows = new HashSet<Cow>();
            for (Cow cow : farm.getCows()) {
                if (cow.isBornable()) {
                    newBornCows.add(cow.lay());
                }
                cow.grow();
            }
            farm.addCows(newBornCows);
            System.out.println("第" + (i + 1) + "年共有" + farm.getCows().size() + "头牛:" + farm);
        }
        System.out.println("\nTotal cow in farm after 20 years are : " + farm.getCows().size());
    }

}
