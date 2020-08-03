import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {

    @Test
    void should_retrun_sum_when_convert_given_no_strike_and_no_spare() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(5, 3);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 1).getFrameScore(), 8);
    }

    @Test
    void should_retrun_sum_after_twice_score_and_10_when_convert_given_strike() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(5, 3);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 2).getFrameScore(), 18);
    }

    @Test
    void should_retrun_sum_after_once_score_and_10_when_convert_given_spare() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(5, 5);
        bowlingGame.throwInSingleFrame(4, 6);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 2).getFrameScore(), 14);
    }

}
