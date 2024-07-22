package gc.garcol.raftcore;

import lombok.Data;

/**
 * Invoked by candidates to gather votes (§5.2).
 *
 * @author thaivc
 * @since 2024
 * @paper-link https://raft.github.io/raft.pdf
 * @page 4
 */
public interface RARequestVoteRPC {

    /**
     * <ol>
     *     <li>Reply false if term < currentTerm (§5.1)</li>
     *     <li>If votedFor is null or candidateId, and candidate’s log is at
     * least as up-to-date as receiver’s log, grant vote (§5.2, §5.4)</li>
     * </ol>
     */
    Result requestVote(Request request);

    @Data
    class Request {

        /**
         * candidate’s term
         */
        long term;

        /**
         * candidate requesting vote
         */
        long candidateId;

        /**
         * index of candidate’s last log entry (§5.4)
         */
        long lastLogIndex;

        /**
         * term of candidate’s last log entry (§5.4)
         */
        long lastLogTerm;
    }

    @Data
    class Result {

        /**
         * Reply false if term < currentTerm (§5.1)
         */
        private long term;

        /**
         * If votedFor is null or candidateId, and candidate’s log is at
         * least as up-to-date as receiver’s log, grant vote (§5.2, §5.4)
         */
        private boolean voteGranted;
    }
}
