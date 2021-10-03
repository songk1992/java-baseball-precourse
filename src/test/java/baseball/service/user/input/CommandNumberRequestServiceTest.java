package baseball.service.user.input;

import baseball.Application;
import baseball.model.BaseballNumber;
import baseball.service.game.GameService;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CommandNumberRequestServiceTest extends NSTest {



    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    // 입력값 출력 테스트
    @Test
    void CommandNumberRequestService() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            run("0", "1", "597", "589", "abc");
            verify("게임을새로시작하려면1,종료하려면2를입력하세요.",
                    "게임을새로시작하려면1,종료하려면2를입력하세요.",
                    "[ERROR] 다시 입력해주세요",
                    "[ERROR] 다시 입력해주세요",
                    "[ERROR] 다시 입력해주세요");
        }
    }

    @Override
    public void runMain() {
        CommandNumberRequestService commandNumberRequestService = new CommandNumberRequestService();
        commandNumberRequestService.requestNumber();
    }
}