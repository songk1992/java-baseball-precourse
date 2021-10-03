package baseball.service.game;

import baseball.Application;
import baseball.model.BaseballNumber;
import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest extends NSTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void beforeEach() {
        super.setUp();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @AfterEach
    void tearDown() {
        outputStandard();
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("숫자야구 숫자 생성 테스트")
    @Test
    void generateBaseballNumber() {
        final GameService gameService = new GameService();
        final BaseballNumber baseballNumber = new BaseballNumber();

        gameService.generateBaseballNumber(baseballNumber);
        int testValue = baseballNumber.getHiddenNumber();
        String testStr = String.valueOf(testValue);

        // 범위가 3자리 인지 테스트
        assertEquals(3, testStr.length());
        
        // 각 자리수가 다른지 테스트
        assertTrue(        (testStr.charAt(0) != testStr.charAt(1))&&
                (testStr.charAt(0) != testStr.charAt(2))&&
                (testStr.charAt(1) != testStr.charAt(2)));
    }

    @Test
    void generateRandomNum() {
        final GameService gameService = new GameService();

        int testValue = gameService.generateRandomNum();
        String testStr = String.valueOf(testValue);

        // 범위가 3자리 인지 테스트
        assertEquals(3, testStr.length());

        // 각 자리수가 다른지 테스트
        assertTrue(        (testStr.charAt(0) != testStr.charAt(1))&&
                (testStr.charAt(0) != testStr.charAt(2))&&
                (testStr.charAt(1) != testStr.charAt(2)));
    }

    @Test
    void guessBaseballNumber() {
        final BaseballNumber baseballNumber = new BaseballNumber();
        final GameService gameService = new GameService();

        // 하나도 일치 하지 않는 경우
        baseballNumber.setHiddenNumber(123);
        baseballNumber.setGuessNumber(456);
        gameService.guessBaseballNumber(baseballNumber);
        assertEquals(0, baseballNumber.getStrikeCnt());
        assertEquals(0, baseballNumber.getBallCnt());

        // 전부 스트라이크
        baseballNumber.setHiddenNumber(123);
        baseballNumber.setGuessNumber(123);
        gameService.guessBaseballNumber(baseballNumber);
        assertEquals(3, baseballNumber.getStrikeCnt());
        assertEquals(0, baseballNumber.getBallCnt());

        // 전부 볼
        baseballNumber.setHiddenNumber(312);
        baseballNumber.setGuessNumber(123);
        gameService.guessBaseballNumber(baseballNumber);
        assertEquals(0, baseballNumber.getStrikeCnt());
        assertEquals(3, baseballNumber.getBallCnt());
    }

    @Test
    void printStrikeBall() {
        final BaseballNumber baseballNumber = new BaseballNumber();
        final GameService gameService = new GameService();

        // 하나도 일치 하지 않는 경우
        baseballNumber.setHiddenNumber(123);
        baseballNumber.setGuessNumber(456);
        gameService.guessBaseballNumber(baseballNumber);
        gameService.printStrikeBall(baseballNumber);
        assertEquals("낫싱\n", outContent.toString());
    }

    @Test
    void printStrikeBall2() {
        final BaseballNumber baseballNumber = new BaseballNumber();
        final GameService gameService = new GameService();

        // 전부 스트라이크
        baseballNumber.setHiddenNumber(123);
        baseballNumber.setGuessNumber(123);
        gameService.guessBaseballNumber(baseballNumber);
        gameService.printStrikeBall(baseballNumber);
        assertEquals("3스트라이크\n", outContent.toString());
    }
    @Test
    void printStrikeBall3() {
        final BaseballNumber baseballNumber = new BaseballNumber();
        final GameService gameService = new GameService();

        // 전부 볼
        baseballNumber.setHiddenNumber(312);
        baseballNumber.setGuessNumber(123);
        gameService.guessBaseballNumber(baseballNumber);
        gameService.printStrikeBall(baseballNumber);
        assertEquals("3볼\n", outContent.toString());
    }






    @Test
    void checkGameEnd() {
        final GameService gameService = new GameService();

        // 1이면 참 / 참이면 게임 다시시작
        assertTrue(gameService.checkGameEnd(1));
        // 0이면 거짓 / 거짓이면 종료
        assertFalse(gameService.checkGameEnd(0));
    }
}