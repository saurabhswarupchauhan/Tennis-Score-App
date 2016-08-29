package com.tennis.game;

import com.tennis.game.webapp.GamePojo;
import com.tennis.game.webapp.TennisAppController;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


public class TennisGameTest {
    GamePojo game;
    ModelAndView modelAndView;
    TennisAppController appController;
    @Before
    public void init(){
        game=new GamePojo();
        appController=new TennisAppController();
    }

    @Test
    public void loveAll(){
       modelAndView=appController.display();
        Assert.assertEquals("LOVE",modelAndView.getModel().get("player1Score"));
        Assert.assertEquals("LOVE",modelAndView.getModel().get("player2Score"));
    }

    @Test
    public void onePointForPlayer1(){
        modelAndView=appController.wonPoint("PLAYER1", "LOVE", "LOVE");
        Assert.assertEquals("FIFTEEN",modelAndView.getModel().get("player1Score"));
        Assert.assertEquals("LOVE",modelAndView.getModel().get("player2Score"));
    }

    @Test
    public void onePointForPlayer2(){
        modelAndView=appController.wonPoint("PLAYER2","LOVE","LOVE");
        Assert.assertEquals("LOVE",modelAndView.getModel().get("player1Score"));
        Assert.assertEquals("FIFTEEN",modelAndView.getModel().get("player2Score"));
    }

    @Test
    public void deuceCheck(){
        modelAndView=appController.wonPoint("PLAYER2","FOURTY","THIRTY");
        Assert.assertEquals("DEUCE",modelAndView.getModel().get("player1Score"));
        Assert.assertEquals("DEUCE",modelAndView.getModel().get("player2Score"));
    }

    @Test
    public void advantageCheck(){
        modelAndView=appController.wonPoint("PLAYER2","DEUCE","DEUCE");
        Assert.assertEquals("FOURTY",modelAndView.getModel().get("player1Score"));
        Assert.assertEquals("Advantage player2",modelAndView.getModel().get("player2Score"));
    }

    @Test
    public void dueceCheckAfterAdvantage(){
        modelAndView=appController.wonPoint("PLAYER1","FOURTY","Advantage player2");
        Assert.assertEquals("DEUCE",modelAndView.getModel().get("player1Score"));
        Assert.assertEquals("DEUCE",modelAndView.getModel().get("player2Score"));
    }
}
