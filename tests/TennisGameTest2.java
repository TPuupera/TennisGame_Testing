import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest2 {

	@Test
	public void testPlayer10PointsAndPlayer20To3Points() throws TennisGameException  {
		TennisGame game = new TennisGame();			
		assertEquals("love - love", game.getScore());	
		game.player2Scored();
		assertEquals("love - 15", game.getScore());
		game.player2Scored();
		assertEquals("love - 30", game.getScore());
		game.player2Scored();
		assertEquals("love - 40", game.getScore());
	}
	
	@Test
	public void testPlayer20PointsAndPlayer10To3Points() throws TennisGameException  {
		TennisGame game = new TennisGame();
		assertEquals("love - love", game.getScore());	
		game.player1Scored();
		assertEquals("15 - love", game.getScore());
		game.player1Scored();
		assertEquals("30 - love", game.getScore());
		game.player1Scored();
		assertEquals("40 - love", game.getScore());
	}
	
	@Test
	public void testPlayersSamePointsTo3Points() throws TennisGameException  {
		TennisGame game = new TennisGame();
		assertEquals("love - love", game.getScore());			
		game.player1Scored();
		game.player2Scored();
				
		assertEquals("15 - 15", game.getScore());
		game.player1Scored();
		game.player2Scored();
		
		assertEquals("30 - 30", game.getScore());
		game.player1Scored();
		game.player2Scored();
		
		assertEquals("deuce", game.getScore());
	}
			
	@Test
	public void testPlayer1Advantage() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		assertEquals("player1 has advantage", game.getScore());	
	}
	
	@Test
	public void testPlayer2Advantage() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		assertEquals("player2 has advantage", game.getScore());	
	}
	
	@Test
	public void testPlayer1Wins() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		assertEquals("player1 wins", game.getScore());	
	}
	
	@Test
	public void testPlayer2Wins() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		assertEquals("player2 wins", game.getScore());	
	}
	
	@Test
	public void testPlayer1WinsAfterAdvantage() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		assertEquals("player1 wins", game.getScore());	
	}
	
	@Test
	public void testPlayer2WinsAfterAdvantage() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		assertEquals("player2 wins", game.getScore());	
	}
	
	@Test
	public void testPlayer2WinsAfterTwoAdvantages() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		assertEquals("player2 wins", game.getScore());	
	}

	@Test
	public void testPlayer1WinsAfterTwoAdvantages() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		assertEquals("player1 wins", game.getScore());	
	}
	
	@Test (expected = TennisGameException.class)
	public void testExceptionWhenScoredAfterGameEnded() throws TennisGameException  {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
	}
}
