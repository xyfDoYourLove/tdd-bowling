import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static List<SingleFrameScore> scoreBoard = new ArrayList<>();

    public static Integer currentFrame = 0;

    // current frame is strike
    public void throwInSingleFrame(int firstThrow) {
        SingleFrameScore singleFrameScore = new SingleFrameScore();
        singleFrameScore.setFirstThrow(firstThrow);
        singleFrameScore.setStrike(true);
        singleFrameScore.setFrameScore(firstThrow);

        addSingleFrameScore(singleFrameScore);
    }

    // current frame is spare or none
    public void throwInSingleFrame(int firstThrow, int secondThrow) {
        SingleFrameScore singleFrameScore = new SingleFrameScore();
        singleFrameScore.setFirstThrow(firstThrow);
        singleFrameScore.setSecondThrow(secondThrow);
        singleFrameScore.setFrameScore(firstThrow+secondThrow);
        if (firstThrow + secondThrow == 10) {
            singleFrameScore.setSpare(true);
        }

        addSingleFrameScore(singleFrameScore);
    }

    // last frame
    public void throwInSingleFrame(int firstThrow, int secondThrow, int threeThrow) {
        SingleFrameScore singleFrameScore = new SingleFrameScore();
        singleFrameScore.setFirstThrow(firstThrow);
        singleFrameScore.setSecondThrow(secondThrow);
        singleFrameScore.setThreeThrow(threeThrow);

        if (firstThrow == 10) {
            // strike
            singleFrameScore.setStrike(true);
            singleFrameScore.setFrameScore(firstThrow + secondThrow + threeThrow);
        }else if (firstThrow + secondThrow == 10) {
            // spare
            singleFrameScore.setSpare(true);
            singleFrameScore.setFrameScore(firstThrow + secondThrow + threeThrow);
        }else {
            singleFrameScore.setFrameScore(firstThrow + secondThrow);
        }
        addSingleFrameScore(singleFrameScore);
    }

    public void addSingleFrameScore(SingleFrameScore singleFrameScore) {
        scoreBoard.add(singleFrameScore);
        currentFrame++;
        checkPreviousFrame();
    }

    // check previous frame is strike or spare
    public void checkPreviousFrame() {
        if (currentFrame > 1) {
            if (scoreBoard.get(currentFrame - 2).getStrike()) {
                SingleFrameScore currentFrameScore = scoreBoard.get(currentFrame - 1);
                SingleFrameScore previousFrameScore = scoreBoard.get(currentFrame - 2);
                previousFrameScore.setFrameScore(previousFrameScore.getFrameScore() + currentFrameScore.getFirstThrow() + currentFrameScore.getSecondThrow());
                scoreBoard.set(currentFrame - 2, previousFrameScore);
            }
            if (scoreBoard.get(currentFrame - 2).getSpare()) {
                SingleFrameScore currentFrameScore = scoreBoard.get(currentFrame - 1);
                SingleFrameScore previousFrameScore = scoreBoard.get(currentFrame - 2);
                previousFrameScore.setFrameScore(previousFrameScore.getFrameScore() + currentFrameScore.getFirstThrow());
                scoreBoard.set(currentFrame - 2, previousFrameScore);
            }
        }
    }
}
