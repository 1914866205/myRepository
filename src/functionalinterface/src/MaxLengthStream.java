package functionalinterface.src;

import java.util.List;
@FunctionalInterface
public interface MaxLengthStream {
    List<String> getMaxLengthWords(List<String> list);
}
