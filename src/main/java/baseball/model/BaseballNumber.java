package baseball.model;

public class BaseballNumber {
    private int hiddenNumber;
    private int guessNumber;
    int strikeCnt;
    int ballCnt;

    public int getHiddenNumber() {
        return hiddenNumber;
    }

    public void setHiddenNumber(int hiddenNumber) {
        this.hiddenNumber = hiddenNumber;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public void setStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void setBallCnt(int ballCnt) {
        this.ballCnt = ballCnt;
    }
}
