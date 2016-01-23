package model;

/**
 * Created by Rynn on 1/22/2016.
 */
public class Card {

    public int value;
    public char suit;

    public Card (int Val, char Suit) {
        value = Val;
        suit = Suit;
    }

   public int getVal(){
       return value;
   }

    public char getSuit(){
        return suit;
    }

}