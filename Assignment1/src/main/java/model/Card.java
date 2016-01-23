package model;

import java.io.Serializable;

/**
 * Created by Chase on 1/22/2016.
 */
public class Card implements Serializable{
    //Class member variables for the card
    public int value;
    public char suit;
    boolean used;

    //Constructor for the card class
    public Card(int value, char suit){
        this.value = value;
        this.suit = suit;
        used = false;
    }

    //Accessors for the card class
    public int getCardValue() {return value;}
    public char getSuitValue() {return suit;}
    public boolean getUsed() {return used;}

    //Mutators for the card class
    public void setCardValue(int val) {this.value = val;}
    public void setSuitValue(char val) {this.suit = val;}
    public void setAsUsed() {this.used = true;}

}
