package gc.garcol.raftcore.commandlog;

/**
 * @author thaivc
 * @since 2024
 */
public interface DataUnmarshaller {
    <T> T deserialize(byte[] bytes);
}
