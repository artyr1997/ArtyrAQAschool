package rozetca.objects;

import java.util.Random;

public class MyRandom {

    private static Random rand = new Random();
    public static int index_hard = rand.nextInt(9999) + 1;

}
