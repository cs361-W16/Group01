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
        Card card1 = getTop(colA); //get the size of column
        Card card2 = getTop(colB);

        if(card1.getVal() > card2.getVal()){
            return true;
        }
        return false;
    }

    //Compare two suits
    public boolean compareSuit(int colA, int colB) {
        //boolean result = false;
        Card card1 = getTop(colA); //get the size of column
        Card card2 = getTop(colB);

        if (card1.getSuit() == card2.getSuit()) {
            //result = compareCard(colA, colB);
          return true;
        }
        else {

            return false;
        }
    }

    public boolean add(int col, Card card){
        if(card == null || col<0 || col>3){
            return false;
        }
        columns.get(col).add(card);
        return true;
    }

    public boolean remove(int col){
        if(col<0 || col>3 || columns.get(col).isEmpty()){
            return false;
        }
        columns.get(col).remove(columns.get(col).size()-1);
        return true;
    }

    public Card getTop(int col){
        if(col<0 || col>3 || columns.get(col).isEmpty()){
            return null;
        }
        return columns.get(col).get(columns.get(col).size()-1);
    }

    public void discard (int col){
        if(columns.get(col)== null || columns.get(col).isEmpty()){
            return;
        }
        int pos=0;
        while(pos<4){
            if( !columns.get(pos).isEmpty() && compareSuit(col,pos) && compareCard(pos,col)){
                remove(col);
                return;
            }
            pos++;
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
