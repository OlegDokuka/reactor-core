package reactor.core.publisher;

import org.reactivestreams.Publisher;
import reactor.test.publisher.TestPublisher;

public class FluxFlatMapInnerOnDiscardShouldNotLeakTest extends AbstractOnDiscardShouldNotLeakTest {

    public FluxFlatMapInnerOnDiscardShouldNotLeakTest(boolean conditional, boolean fused) {
        super(conditional, fused);
    }

    @Override
    protected Publisher<Tracked<?>> transform(TestPublisher<Tracked<?>> main, TestPublisher<Tracked<?>>... additional) {
        return Flux.just(1)
                .flatMap(f -> main.flux());
    }
}
