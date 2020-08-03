import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {

    @Test
    void should_retrun_sum_when_convert_given_no_strike_and_no_spare() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(5, 3);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 1).getFrameScore(), 8);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

    @Test
    void should_retrun_sum_after_twice_score_and_10_when_convert_given_strike() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(5, 3);
        bowlingGame.throwInSingleFrame(5, 5, 5);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 3).getFrameScore(), 18);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

    @Test
    void should_retrun_sum_after_twice_score_and_10_when_convert_given_all_strike() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10, 10, 10);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 3).getFrameScore(), 30);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

    @Test
    void should_retrun_sum_after_once_score_and_10_when_convert_given_spare() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(5, 5);
        bowlingGame.throwInSingleFrame(4, 6, 10);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 2).getFrameScore(), 14);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

    @Test
    void should_retrun_sum_first_and_second_when_convert_given_no_strike_and_no_spare_and_last_frame() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(5, 5, 10);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 1).getFrameScore(), 20);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

    @Test
    void should_retrun_sum_all_when_convert_given_strike_and_last_frame() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(10, 10, 10);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 1).getFrameScore(), 30);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

    @Test
    void should_retrun_sum_all_when_convert_given_spare_and_last_frame() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(5, 5, 10);
        assertEquals((int)BowlingGame.scoreBoard.get(BowlingGame.currentFrame - 1).getFrameScore(), 20);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

    @Test
    void should_retrun_total_score_when_convert_given_list() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(5, 5);
        bowlingGame.throwInSingleFrame(5, 5);
        bowlingGame.throwInSingleFrame(3, 1);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(9, 1);
        bowlingGame.throwInSingleFrame(8, 1);
        bowlingGame.throwInSingleFrame(7, 2);
        bowlingGame.throwInSingleFrame(1, 5);
        bowlingGame.throwInSingleFrame(10, 10, 10);
        int totalScore = bowlingGame.calculateTotalScore();
        assertEquals(totalScore, 144);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

    @Test
    void should_retrun_total_score_when_convert_given_continuous_strike() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10);
        bowlingGame.throwInSingleFrame(10, 10, 10);
        int totalScore = bowlingGame.calculateTotalScore();
        assertEquals(totalScore, 300);
        BowlingGame.scoreBoard.clear();
        BowlingGame.currentFrame = 0;
    }

}
