package gc.garcol.raftcore.commandlog;

/**
 * @author thaivc
 * @since 2024
 */
public interface DataMarshaller {
    <T> byte[] serialize(T data);
}
