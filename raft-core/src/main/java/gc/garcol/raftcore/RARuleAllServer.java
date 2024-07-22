package gc.garcol.raftcore;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author thaivc
 * @since 2024
 */
public interface RARuleAllServer extends RARule {

    /**
     * If commitIndex > lastApplied:
     *  <br>- increment lastApplied, apply
     *  <br>- log[lastApplied] to state machine (§5.3)
     *
     * @rule 1
     */
    <T extends Input> Consumer<T> applyNewAvailableSafeLogs();

    default Predicate<RAStateVolatile> hasAvailableSafeLogs() {
        return state -> state.getCommitIndex() > state.getLastApplied();
    }

    /**
     * If RPC request or response contains term T > currentTerm:
     * set currentTerm = T, convert to follower (§5.1)
     *
     * @rule 2
     */
    <T extends Input> Consumer<T> updateTermAndBecomeFollower();

}
