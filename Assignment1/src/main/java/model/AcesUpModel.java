package model;

/**
 * Created by Taylor on 1/22/2016.
 */
    public class AcesUpModel {
        int[] deck = new int[51];

        public void buildDeck(){
            for(int i = 0; i<52; i++){
                deck[i] = i;
                System.out.print(deck[i]);
            }
        }

}

