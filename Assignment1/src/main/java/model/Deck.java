package model;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Chase on 1/22/2016.
 */
public class Deck implements Serializable {
    //Class member variables for the deck, including 52 cards
    int deckSize;
    Card[] cards;
    //Constructor for deck
    public Deck (){
        deckSize = 52;
        cards = new Card[51];
    }

    //Accessor functions for deck class
    public int getDeckSize() {return deckSize;}
    public Card getACard (int cardNum){return cards[cardNum];}

    //Function to build deck by setting all the cards to value 2-15 and given suits
    public void buildDeck(){
        for (int i = 0; i<= 12; i++) {
            cards[i] = new Card(i+2, 'H'); //hearts
            cards[i+13] = new Card(i+2, 'D'); //diamonds
            cards[i+26] = new Card(i+2, 'S'); //spades
            cards[i+39] = new Card(i+2, 'C'); //clubs
        }
    }

    //Function to return random integer from 0 - 51 for the deck array of card objects
    public int getRandomNumber(){
       return (int)(Math.random() * 51);
    }

    //Function to get a single card from the deck array
    public Card getNewCard(){
        boolean success = false;
        if(deckSize != 0){return null;}
        Card newCard = cards[getRandomNumber()];
        while (!success){
            if (!newCard.getUsed()){
                success = true;
                newCard.setAsUsed();
                deckSize--;
            }
            newCard = cards[getRandomNumber()];
        }
        return newCard;
    }
}