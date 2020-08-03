import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static List<SingleFrameScore> scoreBoard = new ArrayList<>();

    public static Integer currentFrame = 0;

    // current frame is spare or none
    public void calculateScore(int firstThrow, int secondThrow) {
        SingleFrameScore singleFrameScore = new SingleFrameScore();
        singleFrameScore.setFirstThrow(firstThrow);
        singleFrameScore.setSecondThrow(secondThrow);
        singleFrameScore.setFrameScore(firstThrow+secondThrow);
        scoreBoard.add(singleFrameScore);
        currentFrame++;
        checkPreviousFrame();
    }

    // current frame is strike
    public void calculateScore(int firstThrow) {
        SingleFrameScore singleFrameScore = new SingleFrameScore();
        singleFrameScore.setFirstThrow(firstThrow);
        singleFrameScore.setStrike(true);
        singleFrameScore.setFrameScore(firstThrow);
        scoreBoard.add(singleFrameScore);
        currentFrame++;
        checkPreviousFrame();
    }

    // check previous frame is strike or spare
    public void checkPreviousFrame() {
        if (currentFrame > 1) {
            if (scoreBoard.get(currentFrame - 2).getStrike() == true) {
                SingleFrameScore currentFrameScore = scoreBoard.get(currentFrame - 1);
                SingleFrameScore previousFrameScore = scoreBoard.get(currentFrame - 2);
                previousFrameScore.setFrameScore(previousFrameScore.getFrameScore() + currentFrameScore.getFrameScore());
                scoreBoard.set(currentFrame - 2, previousFrameScore);
            }
        }
    }
}
