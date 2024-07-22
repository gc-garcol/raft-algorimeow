package gc.garcol.raftcore;

import lombok.Data;

/**
 * Volatile state on leaders
 * (Reinitialized after election)
 *
 * @author thaivc
 * @since 2024
 */
@Data
public class RAStateVolatileLeader implements RAState {

    /**
     * For each server, index of the next log entry
     * to send to that server (initialized to leader
     * last log index + 1)
     */
    private long[] nextIndex;

    /**
     * for each server, index of highest log entry
     * known to be replicated on server
     * (initialized to 0, increases monotonically)
     */
    private long[] matchIndex;

}
