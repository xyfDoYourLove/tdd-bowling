public class SingleFrameScore {

    Integer firstThrow;

    Integer secondThrow;

    Integer threeThrow;

    Integer frameScore;

    Boolean isStrike = false;

    Boolean isSpare = false;

    Boolean isLastFrame = false;

    public Integer getFirstThrow() {
        return firstThrow;
    }

    public void setFirstThrow(Integer firstThrow) {
        this.firstThrow = firstThrow;
    }

    public Integer getSecondThrow() {
        return secondThrow;
    }

    public void setSecondThrow(Integer secondThrow) {
        this.secondThrow = secondThrow;
    }

    public Integer getThreeThrow() {
        return threeThrow;
    }

    public void setThreeThrow(Integer threeThrow) {
        this.threeThrow = threeThrow;
    }

    public Integer getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(Integer frameScore) {
        this.frameScore = frameScore;
    }

    public Boolean getStrike() {
        return isStrike;
    }

    public void setStrike(Boolean strike) {
        isStrike = strike;
    }

    public Boolean getSpare() {
        return isSpare;
    }

    public void setSpare(Boolean spare) {
        isSpare = spare;
    }

    public Boolean getLastFrame() {
        return isLastFrame;
    }

    public void setLastFrame(Boolean lastFrame) {
        isLastFrame = lastFrame;
    }
}
