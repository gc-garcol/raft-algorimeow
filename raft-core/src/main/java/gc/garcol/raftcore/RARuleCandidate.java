package gc.garcol.raftcore;

/**
 * @author thaivc
 * @since 2024
 */
public interface RARuleCandidate extends RARule {

    /**
     * On conversion to candidate, start election
     *
     * <ol>
     *     <li>Increment currentTerm</li>
     *     <li>Vote for self</li>
     *     <li>Reset election timer</li>
     *     <li>Send RequestVote RPCs to all other servers</li>
     * </ol>
     *
     * @rule 1
     */
    RAExecutable electOnConversionToCandidate();

    /**
     * If votes received from the majority of servers: become leader
     *
     * @rule 2
     */
    RAExecutable receiveMajorityVotes();

    /**
     * If AppendEntries RPC received from new leader: convert to
     * follower
     *
     * @rule 3
     */
    RAExecutable receiveAppendEntriesRPCFromNewLeader();

    /**
     * If election timeout elapses: start new election
     *
     * @rule 4
     */
    RAExecutable electionTimeoutElapse();

}
