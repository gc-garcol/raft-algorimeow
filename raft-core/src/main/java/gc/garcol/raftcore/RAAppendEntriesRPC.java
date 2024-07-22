package gc.garcol.raftcore;

import gc.garcol.raftcore.commandlog.LogEntry;
import lombok.Data;

/**
 * Invoked by leader to replicate log entries (§5.3); also used as heartbeat (§5.2).
 *
 * @author thaivc
 * @since 2024
 * @paper-link https://raft.github.io/raft.pdf
 * @page 4
 */
public interface RAAppendEntriesRPC {

    /**
     * <p>Receiver implementation:</p>
     * <ol>
     *     <li>Reply false if term < currentTerm (§5.1)</li>
     *     <li>Respond false if log doesn’t contain an entry at prevLogIndex whose term matches prevLogTerm (§5.3)</li>
     *     <li>If an existing entry conflicts with a new one (same index but different terms), delete the existing entry and all that follow it (§5.3)</li>
     *     <li>Append any new entries not already in the log</li>
     *     <li>If leaderCommit > commitIndex, set commitIndex = min(leaderCommit, index of last new entry)</li>
     * </ol>
     */
    Result appendEntries(Request request);

    @Data
    class Request {
        /**
         * leader’s term
         */
        private long term;

        /**
         * so follower can redirect clients
         */
        private int leaderId;

        /**
         * index of log entry immediately preceding new ones
         */
        private long prevLogIndex;

        /**
         * term of prevLogIndex entry
         */
        private long prevLogTerm;

        /**
         * log entries to store (empty for heartbeat;
         * may send more than one for efficiency)
         */
        private LogEntry[] entries;

        /**
         * leader’s commitIndex
         */
        private long leaderCommit;
    }

    @Data
    class Result {
        /**
         * currentTerm, for leader to update itself
         */
        private long term;

        /**
         * true if follower contained entry matching
         * prevLogIndex and prevLogTerm
         */
        private boolean success;
    }
}
