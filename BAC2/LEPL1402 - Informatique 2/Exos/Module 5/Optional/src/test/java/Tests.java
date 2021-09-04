import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.*;

public class Tests {

    private OptionalTest test = new OptionalTest();

    @Test
    public void basicTestCreateOptionalTeamLeader() {
        Optional<TeamLeader> optionalTeamLeaderEmpty = test.createOptionalTeamLeader(null);
        Optional<TeamLeader> optionalTeamLeaderPaul = test.createOptionalTeamLeader(new TeamLeader("Paul", 50));
        assertEquals(optionalTeamLeaderEmpty, Optional.empty());
        assertTrue(optionalTeamLeaderPaul instanceof Optional);
    }

    // Add more tests here.
}