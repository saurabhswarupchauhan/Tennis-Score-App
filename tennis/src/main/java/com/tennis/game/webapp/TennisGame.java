package com.tennis.game.webapp;

public class TennisGame {


    public GamePojo winPoint(GamePojo pojo,String playerPoint) {
        String player1Score=pojo.getPlayer1().getScore();
        String player2Score=pojo.getPlayer2().getScore();

        if (playerPoint.equals("PLAYER1")) {
            if (player1Score.equals("LOVE")) {
                pojo.getPlayer1().setScore("FIFTEEN");
            } else if (player1Score.equals("FIFTEEN")) {
                pojo.getPlayer1().setScore("THIRTY");
            } else if (player1Score.equals("THIRTY")) {
                pojo.getPlayer1().setScore("FOURTY");
            }else
                pojo=checkforAdvantage(pojo,playerPoint);

        } else {
            if (player2Score.equals("LOVE")) {
                pojo.getPlayer2().setScore("FIFTEEN");
            } else if (player2Score.equals("FIFTEEN")) {
                pojo.getPlayer2().setScore("THIRTY");
            } else if (player2Score.equals("THIRTY")) {
                pojo.getPlayer2().setScore("FOURTY");
            }else
                pojo=checkforAdvantage(pojo,playerPoint);
        }
        if(pojo.getPlayer1().getScore().equals("FOURTY") && pojo.getPlayer2().getScore().equals("FOURTY")){
            pojo.getPlayer1().setScore("DEUCE");
            pojo.getPlayer2().setScore("DEUCE");
        }


        return pojo;
    }

    private GamePojo checkforAdvantage(GamePojo pojo, String playerPoint) {
        if(((pojo.getPlayer1().getScore().equals("FOURTY")&& ! pojo.getPlayer2().getScore().equals("Advantage player2")) || (pojo.getPlayer2().getScore().equals("FOURTY")
            && ! pojo.getPlayer1().getScore().equals("Advantage player1")))){
            if((pojo.getPlayer1().getScore().equals(pojo.getPlayer2().getScore()))){
                if(playerPoint.equals("PLAYER1")){
                    pojo.getPlayer1().setScore("Advantage player1");
                }else{
                    pojo.getPlayer2().setScore("Advantage player2");
                }
            }else if(playerPoint.equals("PLAYER1")&& pojo.getPlayer1().getScore().equals("FOURTY")
                    && ! pojo.getPlayer2().getScore().equals("Advantage player2")){
                    pojo.getPlayer1().setScore("WIN");
            }else if(playerPoint.equals("PLAYER2")&& pojo.getPlayer2().getScore().equals("FOURTY")
                    && ! pojo.getPlayer1().getScore().equals("Advantage player1")){
                pojo.getPlayer2().setScore("WIN");
            }
        } else if((pojo.getPlayer1().getScore().equals("Advantage player1"))){
            if(playerPoint.equals("PLAYER1")) {
                pojo.getPlayer1().setScore("WIN");
            }else{
                pojo.getPlayer1().setScore("DEUCE");
                pojo.getPlayer2().setScore("DEUCE");
            }
        }
        else if((pojo.getPlayer2().getScore().equals("Advantage player2"))){
            if(playerPoint.equals("PLAYER2")) {
                pojo.getPlayer2().setScore("WIN");
            }else{
                pojo.getPlayer1().setScore("DEUCE");
                pojo.getPlayer2().setScore("DEUCE");
            }
        }
        else if(((pojo.getPlayer1().getScore().equals("DEUCE") && !pojo.getPlayer2().getScore().equals("WIN"))
                ||(!pojo.getPlayer1().getScore().equals("WIN") && pojo.getPlayer2().getScore().equals("DEUCE")))){
            if(playerPoint.equals("PLAYER1")){
                pojo.getPlayer1().setScore("Advantage player1");
                pojo.getPlayer2().setScore("FOURTY");
            }else{
                pojo.getPlayer2().setScore("Advantage player2");
                pojo.getPlayer1().setScore("FOURTY");
            }
        }
        return pojo;
    }

}
