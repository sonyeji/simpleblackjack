package com.cnu.blackjack;

import com.cnu.blackjack.Exceptions.NotEnoughBalanceException;
import lombok.Data;

@Data
public class Player {

    private int balance;
    private int currentBet;
    private Hand hand;

    public Player(int balance, Hand hand) {
        this.balance = balance;
        this.hand = hand;
    }

    public void placeBet(int bet) {
        if(bet > balance){
            throw new NotEnoughBalanceException();
        }
        balance -= bet;
        this.currentBet = bet;
    }

    public Object hitCard() {
        return hand.drawCard();
    }
}
