package com.tennis.game.webapp;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TennisAppController {


	@RequestMapping(value = "/tennisController", method = RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("player1Score", "LOVE");
		modelView.addObject("player2Score", "LOVE");
		modelView.setViewName("welcome");

		return modelView;
	}

	@RequestMapping(value = "/wonPoint", method = RequestMethod.GET)
	public ModelAndView wonPoint(@RequestParam("player") String player,@RequestParam("player1Score") String player1Score,
								 @RequestParam("player2Score") String player2Score) {
		GamePojo pojo =new GamePojo();
		Player player1=new Player("PLAYER1",player1Score);
		Player player2=new Player("PLAYER1",player2Score);
		pojo.setPlayer1(player1);
		pojo.setPlayer2(player2);
		TennisGame game=new TennisGame();
		System.out.println("Player:"+player+" and Player1 Score is:"+player1Score +" Player 2 Score:"+player2Score);

		ModelAndView modelView = new ModelAndView();

		pojo=game.winPoint(pojo, player);
		modelView.addObject("player1Score",pojo.getPlayer1().getScore());
		modelView.addObject("player2Score",pojo.getPlayer2().getScore());
		modelView.setViewName("welcome");
		return modelView;
	}
}
