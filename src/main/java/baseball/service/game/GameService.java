package baseball.service.game;

import baseball.model.BaseballNumber;
import nextstep.utils.Randoms;

public class GameService {


    public BaseballNumber generateBaseballNumber(BaseballNumber baseballNumber)
    {
        baseballNumber.setHiddenNumber(generateRandomNum());
        return baseballNumber;
    }

    public int generateRandomNum()
    {
        /* 임의 값의 숫자 생성 */
        int digit1 = Randoms.pickNumberInRange(1,9);
        int digit2 = Randoms.pickNumberInRange(1,9);
        int digit3 = Randoms.pickNumberInRange(1,9);

        if(digit2 == digit1 || digit2 == 0){digit2 = (digit2+1)%10;}
        if(digit2 == digit1 || digit2 == 0){digit2 = (digit2+1)%10;}

        if (digit3 == digit2 || digit3 == digit1 || digit3 == 0){digit3 = (digit3 + 1) % 10;}
        if (digit3 == digit2 || digit3 == digit1 || digit3 == 0){digit3 = (digit3 + 1) % 10;}
        if (digit3 == digit2 || digit3 == digit1 || digit3 == 0){digit3 = (digit3 + 1) % 10;}

        return (digit1 * 100 + digit2 * 10 + digit3);
    }

    public BaseballNumber guessBaseballNumber(BaseballNumber baseballNumber)
    {
        final String hiddenNum = String.valueOf(baseballNumber.getHiddenNumber());
        final String guessNum = String.valueOf(baseballNumber.getGuessNumber());
        int strikeCnt = 0;
        int ballCnt = 0;

        for(int i=0;i<3;i++){
            for(int j=0; j<3; j++){
                if(hiddenNum.charAt(i) == guessNum.charAt(j)){
                    if(i == j){strikeCnt++;}
                    if(i != j){ballCnt++;}
                }
            }
        }

        baseballNumber.setStrikeCnt(strikeCnt);
        baseballNumber.setBallCnt(ballCnt);
        return baseballNumber;

    }

    public void printStrikeBall(BaseballNumber baseballNumber)
    {
        int strikeCnt = baseballNumber.getStrikeCnt();
        int ballCnt = baseballNumber.getBallCnt();

        String tempStr = "";
        if(strikeCnt > 0){tempStr += strikeCnt + "스트라이크";}
        if(strikeCnt > 0 && ballCnt > 0){tempStr += " ";}
        if(ballCnt > 0){tempStr += ballCnt + "볼";}
        if(strikeCnt == 0 && ballCnt == 0){tempStr += "낫싱";}
        System.out.print(tempStr + "\n");
    }


    public boolean checkGameEnd(int endLineCmd)
    {
        return  (endLineCmd == 1);
    }

}
