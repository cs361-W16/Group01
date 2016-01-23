package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Card;

/**
 * Created by Rynn on 1/22/2016.
 */
public class GameState implements Serializable {

    public java.util.List<java.util.List<Card>> columns;
    public Deck deck;

    public boolean compareCard(int colA, int colB){
        java.util.List <Card> tarColA = columns.get(colA); //get the card on top
        java.util.List <Card> tarColB = columns.get(colB);

        Card card1 = tarColA.get(tarColA.size()-1); //get the size of column
        Card card2 = tarColB.get(tarColB.size()-1);

        if(card1.getVal() > card2.getVal()){
            return true;
        }
        return false;
    }

    //Compare two suits
    public boolean compareSuit(int colA, int colB) {
        //boolean result = false;
        java.util.List <Card> tarColA = columns.get(colA); //get the card on top
        java.util.List <Card> tarColB = columns.get(colB);

        Card card1 = tarColA.get(tarColA.size()-1); //get the size of column
        Card card2 = tarColB.get(tarColB.size()-1);

        if (card1.getSuit() == card2.getSuit()) {
            //result = compareCard(colA, colB);
          return true;
        }
        else {

            return false;
        }
    }

    public GameState (){
        deck= new Deck ();
        columns = new ArrayList<List<Card>>();
        java.util.List<Card> temp;
        int pos=0;
        while (pos<4){
            temp = new ArrayList<Card>();
            columns.add(temp);
            pos++;
        }

    }

}
