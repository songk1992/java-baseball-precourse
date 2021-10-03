package baseball.service.game;

import baseball.model.BaseballNumber;
import nextstep.utils.Randoms;

public class GameService {


    public BaseballNumber generateBaseballNumber(BaseballNumber baseballNumber)
    {
        baseballNumber.setHiddenNumber(generateRandomNum());
        System.out.println(baseballNumber.getHiddenNumber());
        return baseballNumber;
    }

    public int generateRandomNum()
    {
        int retVal =Randoms.pickNumberInRange(100,999);
        int tempVal = retVal;
        int digit3 = tempVal % 10;
        tempVal /= 10;
        int digit2 = tempVal % 10;
        tempVal /= 10;
        int digit1 = tempVal % 10;

        if((digit3 == digit2) || (digit3 == digit1) || (digit2 == digit1))
        {
            retVal = generateRandomNum();
        }
        return retVal;
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
        if(strikeCnt == 0 && ballCnt == 0)
        {
            tempStr += "낫싱";
        }
        System.out.println(tempStr);
    }


    public boolean checkGameEnd(int endLineCmd)
    {
        boolean retVal = false;
        if(endLineCmd == 1) {retVal = true;}
        return  retVal;
    }

}
