package gc.garcol.raftcore;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author thaivc
 * @since 2024
 */
public interface RARuleFollower extends RARule {

    /**
     * Respond to RPCs from candidates and leaders
     *
     * @rule 1
     */
    <T extends Input> Consumer<T> replyRPC();

    /**
     * If election timeout elapses without receiving AppendEntries
     * RPC from current leader or granting vote to candidate:
     * convert to candidate
     *
     * @rule 2
     */
    <T extends Input> Consumer<T> onConditionConvertToCandidate();

}
