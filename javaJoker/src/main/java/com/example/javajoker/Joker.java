package com.example.javajoker;

import java.util.Random;

public class Joker {

    private String[] joke = {"Q: What do you call the age of a pilgrim?\n" +
            "\n" +
            "A: Pilgrimage.\n"
            ,"Q: What was the turkey suspected of?\n" +
            "\n" +
            "A: Fowl play.\n","Q: What is a pumpkin's favorite sport?\n" +
            "\n" +
            "A: Squash\n"
            ,"Knock Knock.\n" +
            "\n" +
            "Who There?\n" +
            "\n" +
            "Thanksgiving!\n" +
            "\n" +
            "Thanksgiving for what?\n" +
            "\n" +
            "Thanks giving us this turkey."
            ,"Q. Our wedding was so beautiful ...\n" +
            "\n" +
            "A. Even the cake was in tiers.\n"
            ,"Q: What do you call a holiday dinner without the parents?\n" +
            "\n" +
            "A: Friendsgiving.\n"
            ,"Q: How do Rednecks celebrate Thanksgiving?\n" +
            "\n" +
            "A: Pump kin!!"};

        public String getJoke(){
            Random random=new Random();
            String joke_random = joke[random.nextInt(joke.length)];
            return joke_random;
        }

}
