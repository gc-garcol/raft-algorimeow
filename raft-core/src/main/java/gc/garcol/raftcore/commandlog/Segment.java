package gc.garcol.raftcore.commandlog;

/**
 * @author thaivc
 * @since 2024
 */
public interface Segment extends Compressible {
    SegmentHeader header();
    SegmentData data();

    byte[] rawHeader();
    byte[] rawData();
    byte[] rawSegment();
}
