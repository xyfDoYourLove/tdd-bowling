import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {

    @Test
    void should_retrun_sum_when_convert_given_no_strike_and_no_spare() {
        BowlingGame bowlingGame = new BowlingGame();
        int score = bowlingGame.calculateScore(5, 3);
        assertEquals(score, 8);
    }

}
