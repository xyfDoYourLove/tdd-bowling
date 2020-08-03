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
        singleFrameScore.setLastFrame(true);

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
        checkAllFrameScore();
    }

    public void addSingleFrameScore(SingleFrameScore singleFrameScore) {
        scoreBoard.add(singleFrameScore);
        currentFrame++;
    }

    public int calculateTotalScore() {
        Integer sumTotal = 0;
        for (int i = 0; i < scoreBoard.size(); i++) {
            sumTotal += scoreBoard.get(i).getFrameScore();
        }
        return sumTotal;
    }

    public void checkAllFrameScore() {
        for (int i = scoreBoard.size() - 2; i >= 0; i--) {
            if (scoreBoard.get(i).getStrike()) {
                dealWithStrike(scoreBoard.get(i), scoreBoard.get(i + 1), i);
            }
            if (scoreBoard.get(i).getSpare()) {
                dealWithSpare(scoreBoard.get(i), scoreBoard.get(i + 1), i);
            }
        }
    }

    private void dealWithSpare(SingleFrameScore currFrameScore, SingleFrameScore lastOneFrameScore, int index) {
        currFrameScore.setFrameScore(currFrameScore.getFrameScore() + lastOneFrameScore.getFirstThrow());
        scoreBoard.set(index, currFrameScore);
    }

    public void dealWithStrike(SingleFrameScore currFrameScore, SingleFrameScore lastOneFrameScore, int index) {
        if (lastOneFrameScore.getStrike() && !lastOneFrameScore.getLastFrame()) {
            SingleFrameScore lastTwoFrameScore = scoreBoard.get(index + 2);
            currFrameScore.setFrameScore(currFrameScore.getFrameScore() + lastOneFrameScore.getFirstThrow() + lastTwoFrameScore.getFirstThrow());
        }else {
            currFrameScore.setFrameScore(currFrameScore.getFrameScore() + lastOneFrameScore.getFirstThrow() + lastOneFrameScore.getSecondThrow());
        }
        scoreBoard.set(index, currFrameScore);
    }
}
