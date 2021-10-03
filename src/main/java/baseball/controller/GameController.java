package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.service.game.GameService;
import baseball.service.user.input.CommandNumberRequestService;
import baseball.service.user.input.GuessNumberRequestService;

public class GameController {

    CommandNumberRequestService commandNumberRequestService;
    GuessNumberRequestService guessNumberRequestService;
    BaseballNumber baseballNumber;
    GameService gameService;

    public GameController() {
        commandNumberRequestService = new CommandNumberRequestService();
        guessNumberRequestService = new GuessNumberRequestService();
        baseballNumber = new BaseballNumber();
        gameService = new GameService();
    }

    public void startGame()
    {
        generateBaseballNumber();
        guessBaseballNumber();
        checkEndGame();
    }

    /* 숫자야구 3자리의 추측할 숫자 생성 */
    public void generateBaseballNumber()
    {
        baseballNumber = gameService.generateBaseballNumber(baseballNumber);
    }

    /* 숫자야구 3자리의 추측할 숫자 추측 */
    public void guessBaseballNumber()
    {
        baseballNumber.setGuessNumber(guessNumberRequestService.requestNumber());
        baseballNumber = gameService.guessBaseballNumber(baseballNumber);
        gameService.printStrikeBall(baseballNumber);
        if(baseballNumber.getStrikeCnt() != 3)
        {
            guessBaseballNumber();
        }
    }

    /* 숫자야구 종료 선택 */
    public void checkEndGame()
    {
        System.out.println("3개의숫자를모두맞히셨습니다!게임끝");
        if(gameService.checkGameEnd(commandNumberRequestService.requestNumber()) == true)
        {
            startGame();
        };
    }

}
