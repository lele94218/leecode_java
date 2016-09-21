package com.terryx.effective.java;

import com.terryx.effective.java.buildpattern.NutritionFacts;

/**
 * @author taoranxue on 9/20/16 3:57 PM.
 */
public class Item2 {
    public static void main(String args[]) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(10, 240)
                .calories(10).carbohydrate(10).fat(10).sodium(10).build();
    }
}
