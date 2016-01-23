package model;

/**
 * Created by Rynn on 1/22/2016.
 */
public class Card {

    public int value;
    public char suit;
    public boolean used;

    public Card (int Val, char Suit) {
        value = Val;
        suit = Suit;
        used = false;
    }

    public Card(){
        value = 0;
        suit = 'B';
        used = true;
    }

    public int getVal(){
        return value;
    }
    public void setVal(int input){value = input;}

    public char getSuit(){return suit;}
    public void setSuit(char input){suit = input;}

    public boolean getUsed() { return used;}
    public void setAsUsed(){used = true;}
}