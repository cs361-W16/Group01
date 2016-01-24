/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package model;


import ninja.NinjaDocTester;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.junit.Test;
import model.Card;
import model.GameState;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class ModelTest {

    @Test
    public void AddTest(){

        GameState gs = new GameState();
        Card card1= new Card(2,'D');
        Card card2= new Card(6,'C');
        Card card3= new Card(12,'H');
        Card card4= new Card(10,'S');

        gs.add(0,card1);
        gs.add(0,card2);
        gs.add(1,card3);
        gs.add(3,card4);

        assert(gs.columns.get(0).size()==2);
        assert(gs.columns.get(0).get(0)==card1);
        assert(gs.columns.get(0).get(1)==card2);
        assert(gs.columns.get(1).size()==1);
        assert(gs.columns.get(1).get(0)==card3);
        assert(gs.columns.get(2).size()==0);
        assert(gs.columns.get(3).size()==1);
        assert(gs.columns.get(3).get(0)==card4);

    }

    @Test
    public void RemoveTest(){
        GameState gs = new GameState();
        Card card1= new Card(2,'D');
        Card card2= new Card(6,'C');
        Card card3= new Card(12,'H');
        Card card4= new Card(10,'S');

        gs.add(0,card1);
        gs.add(0,card2);
        gs.add(1,card3);
        gs.add(3,card4);

        gs.remove(0);
        assert(gs.columns.get(0).size()==1);
        assert(gs.columns.get(0).get(0)==card1);

        gs.remove(1);
        assert(gs.columns.get(1).size()==0);

        gs.remove(2);

    }

    @Test
    public void GetTopTest(){
        GameState gs = new GameState();
        Card card1= new Card(2,'D');
        Card card2= new Card(6,'C');
        Card card3= new Card(12,'H');
        Card card4= new Card(10,'S');

        gs.add(0,card1);
        gs.add(0,card2);
        gs.add(1,card3);
        gs.add(3,card4);

        assert(gs.getTop(0)==card2);
        assert(gs.getTop(1)==card3);
        assert(gs.getTop(2)==null);
        assert(gs.getTop(3)==card4);

    }

    @Test
    public void discardTest(){
        GameState gs = new GameState();
        Card card1= new Card(2,'D');
        Card card2= new Card(6,'C');
        Card card3= new Card(12,'H');
        Card card4= new Card(10,'S');
        Card card5= new Card(10,'C');

        gs.add(0,card1);
        gs.add(0,card2);
        gs.add(1,card3);
        gs.add(3,card4);

        gs.discard(0);
        assert(gs.columns.get(0).size()==2);
        gs.add(3,card5);
        gs.discard(0);
        assert(gs.columns.get(0).size()==1);

    }



    @Test
    public void sameValues(){

        Card card1 = new Card(2,'C');
        Card card2 = new Card(3,'C');
        Card card3 = new Card(4,'C');
        Card card4 = new Card(5,'C');

        GameState game = new GameState();
        game.columns.get(1).add(card1);
        game.columns.get(2).add(card2);
        game.columns.get(3).add(card3);
        game.columns.get(0).add(card4);

        assert(false == game.compareCard(1,2)); //false if 2 is greater than 1
        assert(true == game.compareCard(0,3));
    }

    @Test
    public void sameSuits(){
        Card card1 = new Card(4,'C');
        Card card2 = new Card(7,'C');
        Card card3 = new Card(4,'H');
        Card card4 = new Card(5,'C');

        GameState game = new GameState();
        game.columns.get(1).add(card1);
        game.columns.get(2).add(card2);
        game.columns.get(3).add(card3);
        game.columns.get(0).add(card4);

        assert(true == game.compareSuit(1, 2)); //return true if two suits are the same
        assert(false == game.compareSuit(0, 3));
    }

    @Test
    public void testCard1(){
        Deck deck = new Deck();
        deck.buildDeck();
        assert(deck != null);
        Card card = new Card();
        card.setVal(3);
        card.setSuit('S');
        assert(card.getVal()>0);
        assert(card.getSuit() == 'S');
    }

    @Test
    public void testDrawCard(){
        Deck deck = new Deck();
        deck.buildDeck();
        Card card = deck.getNewCard();
        assert(card != null);
    }

    @Test
    public void testDrawWholeDeck(){
        Deck deck = new Deck();
        deck.buildDeck();
        Card card = new Card();
        for(int i=0; i<=51; i++){
            card = deck.getNewCard();
            //assert(card.getUsed());
        }
    }
    @Test
    public void testDeckSize(){
        Deck deck = new Deck();
        deck.buildDeck();
        int v = deck.getDeckSize();
        assert(v>0);
    }

    @Test
    public void testGetNewCard(){
        Deck deck = new Deck();
        deck.buildDeck();
        Card card = new Card();
        card = deck.getACard(4);
        assert(card.getVal() > 0);
    }

    @Test
    public void MoveTest(){
        int input = 2;
        GameState gs = new GameState();
        assert(input < 3 || input > 0);
        int counter = 0;
        for(int i = 0; i <= 3; i++){
            if(gs.columns.get(i).isEmpty())
                counter ++;
            assert(counter <= 3);
            //assert will fail before the cards are dealt
        }
    }

}