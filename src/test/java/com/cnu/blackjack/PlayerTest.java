package com.cnu.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest {

    Hand hand;

    @Before
    public void setUp(){
        hand = new Hand(new Deck(1));
    }

    @Test
    public void 플레이어는_시드머니를_가지고_생성할수있다(){
        Player player = new Player(5000, hand);
        assertThat(player.getBalance(), is(5000));
    }

    @Test
    public void 플레이어는_배팅을_할수있다(){
        Player player = new Player(5000, hand);
        player.placeBet(3000);
        int balance = player.getBalance();
        assertTrue(balance == 2000);
    }

    @Test(expected = Exception.class)
    public void 플레이어는_가진돈보다_많이_배팅할수없다(){
        Player player = new Player(5000, hand);
        player.placeBet(10000);
    }

    @Test
    public void 플레이어는_카드를_HIT_할수_있어야한다(){
        Player player = new Player(5000, hand);
        assertThat(player.hitCard(), notNullValue());
    }
}
