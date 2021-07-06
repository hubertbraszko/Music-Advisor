import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;

import java.util.List;

public class MusicAdvisorTest extends StageTest {

    @Override
    public List<TestCase> generate() {
        return List.of(
            new TestCase()
                .setInput(
                    "new\n" +
                    "featured\n" +
                    "categories\n" +
                    "playlists Mood\n" +
                    "exit")
        );
    }

    @Override
    public CheckResult check(String reply, Object clue) {
        return new CheckResult(
            reply.contains("---NEW RELEASES---")
            && reply.contains("---FEATURED---")
            && reply.contains("---CATEGORIES---")
            && reply.contains("---GOODBYE!---")
            && reply.contains("PLAYLISTS---"));
    }
}
