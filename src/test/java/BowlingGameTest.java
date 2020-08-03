import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {

    @Test
    void should_retrun_sum_when_convert_given_no_strike_and_no_spare() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.calculateScore(5, 3);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 1).getFrameScore(), 8);
    }

    @Test
    void should_retrun_sum_after_twice_score_and_10_when_convert_given_strike() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.calculateScore(10);
        bowlingGame.calculateScore(5, 3);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 2).getFrameScore(), 18);
    }

}
