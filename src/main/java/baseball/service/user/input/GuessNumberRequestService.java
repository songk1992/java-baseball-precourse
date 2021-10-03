package baseball.service.user.input;

import nextstep.utils.Console;

import java.util.NoSuchElementException;

public class GuessNumberRequestService implements RequestNumberService{

    @Override
    public int requestNumber() {
        System.out.print("숫자를입력해주세요: ");
        try {
            int retVal = Integer.parseInt(Console.readLine());
            isOutOfBound(retVal);
            hasDuplicate(retVal);
            hasZero(retVal);

            return retVal;
        } catch (NumberFormatException e) {
            return requestNumber();
        }
    }

    private void isOutOfBound(int retVal)
    {
        if(retVal >999 || retVal < 100){
            throw new NoSuchElementException();
        }
    }

    private void hasDuplicate(int retVal)
    {
        int digit3 = retVal % 10;
        retVal /= 10;
        int digit2 = retVal % 10;
        retVal /= 10;
        int digit1 = retVal % 10;

        if((digit3 == digit2) || (digit3 == digit1) || (digit2 == digit1))
        {
            throw new NoSuchElementException();
        }
    }

    private void hasZero(int retVal)
    {
        int digit3 = retVal % 10;
        retVal /= 10;
        int digit2 = retVal % 10;
        retVal /= 10;
        int digit1 = retVal % 10;

        if((digit3 == 0) || (digit1 == 0) || (digit2 == 0))
        {
            throw new NoSuchElementException();
        }
    }
}
