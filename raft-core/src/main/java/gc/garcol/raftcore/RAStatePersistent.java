package gc.garcol.raftcore;

import gc.garcol.raftcore.commandlog.LogEntry;
import lombok.Data;

/**
 * Persistent state on all servers
 * (Updated on stable storage before responding to RPCs)
 *
 * @author thaivc
 * @since 2024
 */
@Data
public class RAStatePersistent implements RAState {

    /**
     * Latest term server has seen (initialized to 0 on first boot, increases monotonically)
     */
    private long currentTerm;

    /**
     * CandidateId that received vote in current term (or null if none)
     */
    private int votedFor;

    /**
     * Log entries; each entry contains command for state machine,
     * and term when entry was received by leader (first index is 1)
     */
    private LogEntry[] log;
}
