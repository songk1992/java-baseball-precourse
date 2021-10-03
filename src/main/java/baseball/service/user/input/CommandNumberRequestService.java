package baseball.service.user.input;

import nextstep.utils.Console;

public class CommandNumberRequestService implements RequestNumberService{

    @Override
    public int requestNumber() {
        System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
        try {
            int retVal = Integer.parseInt(Console.readLine());
            if(retVal != 2 && retVal != 1){
                throw new NumberFormatException();
            }
            return retVal;
        } catch (NumberFormatException e) {
            return requestNumber();
        }
    }

}
