package baseball.service.user.input;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

class GuessNumberRequestServiceTest {

    NumberFormatException numberFormatException = new NumberFormatException();
    @Test
    void requestNumber() {
        GuessNumberRequestService guessNumberRequestService = new GuessNumberRequestService();

        // 중복테스트
        try {
            String input = "133";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            guessNumberRequestService.requestNumber();
            fail("");
        } catch (NoSuchElementException e) {
            // pass
        }

        // 길이 테스트
        try {
            String input = "1333";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            guessNumberRequestService.requestNumber();
            fail("");
        } catch (NoSuchElementException e) {
            // pass
        }

        // 문자테스트
        try {
            String input = "ㅁㄴㅇㅁ";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            guessNumberRequestService.requestNumber();
            fail("");
        } catch (NoSuchElementException e) {
            // pass
        }

        // 0테스트
        try {
            String input = "101";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            guessNumberRequestService.requestNumber();
            fail("");
        } catch (NoSuchElementException e) {
            // pass
        }

        //정상테스트
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(123, guessNumberRequestService.requestNumber());

    }


}