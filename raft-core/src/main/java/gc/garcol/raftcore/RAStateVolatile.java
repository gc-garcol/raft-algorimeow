package gc.garcol.raftcore;

import lombok.Data;

/**
 * Volatile state on all servers
 *
 * @author thaivc
 * @since 2024
 */
@Data
public class RAStateVolatile implements RAState {

    /**
     * index of highest log entry known to be committed
     * (initialized to 0, increases monotonically)
     */
    private long commitIndex;

    /**
     * index of highest log entry applied to state
     * machine (initialized to 0, increases
     * monotonically)
     */
    private long lastApplied;

}
