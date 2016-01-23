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
    public void testDeckCreate(){
       /*     System.out.println("yay");
        int[] deck = new int[52];
        for(int i = 0; i<52; i++) {
            deck[i] = i;
            System.out.print(deck[i]);

        }*/
    }
<<<<<<< HEAD
    
=======

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

>>>>>>> refs/remotes/cs361-W16/master
}