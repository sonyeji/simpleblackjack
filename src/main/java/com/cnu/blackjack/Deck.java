package com.cnu.blackjack;

import com.cnu.blackjack.Exceptions.NoMoreCardExeption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private int numberOfDeck;
    private List<Card> cardList = new ArrayList<Card>();

    public Deck (int numberOfDeck){
        this.numberOfDeck = numberOfDeck;
        this.cardList = new ArrayList<Card>();
        createCard(numberOfDeck);
        Collections.shuffle(cardList);
    }

    private void createCard(int numberOfDeck) {
        for (int j = 0; j < numberOfDeck; j++) {
            for (int i = 1; i < 14; i++) {
                for (Suit suit : Suit.values()) {
                    Card card = new Card(i, suit);
                    cardList.add(card);
                }
            }
        }
    }

    public int getTotalCardCount() {
        return cardList.size();
    }

    public Card drawCard() {
        if(cardList.size() == 0){
            throw new NoMoreCardExeption();
        }
        return cardList.remove(0);
    }
}
