package gc.garcol.raftcore.commandlog;

/**
 * @author thaivc
 * @since 2024
 */
public interface Command extends Compressible {
    CommandHeader header();
    CommandData data();

    byte[] rawHeader();
    byte[] rawData();
    byte[] rawCommand();
}
