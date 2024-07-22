package gc.garcol.raftcore.commandlog;

import java.util.List;

/**
 * @author thaivc
 * @since 2024
 */
public interface SegmentData {
    List<Command> commands();
    byte[] commandsAsBytes();
}
