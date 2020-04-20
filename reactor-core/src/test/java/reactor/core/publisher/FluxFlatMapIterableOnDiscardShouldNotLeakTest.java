package reactor.core.publisher;

import org.reactivestreams.Publisher;
import reactor.test.publisher.TestPublisher;

import java.util.Arrays;

public class FluxFlatMapIterableOnDiscardShouldNotLeakTest extends AbstractOnDiscardShouldNotLeakTest {

    public FluxFlatMapIterableOnDiscardShouldNotLeakTest(boolean conditional, boolean fused) {
        super(conditional, fused);
    }

    @Override
    protected Publisher<Tracked<?>> transform(TestPublisher<Tracked<?>> main, TestPublisher<Tracked<?>>... additional) {
        return main
                .flux()
                .flatMapIterable(Arrays::asList);
    }
}
