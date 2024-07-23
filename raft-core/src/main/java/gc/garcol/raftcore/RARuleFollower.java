package gc.garcol.raftcore;

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
    RAExecutable replyRPC();

    /**
     * If election timeout elapses without receiving AppendEntries
     * RPC from current leader or granting vote to candidate:
     * convert to candidate
     *
     * @rule 2
     */
    RAExecutable onConditionConvertToCandidate();

}
