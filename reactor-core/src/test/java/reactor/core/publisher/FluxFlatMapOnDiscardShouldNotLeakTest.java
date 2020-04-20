package reactor.core.publisher;

import org.reactivestreams.Publisher;
import reactor.test.publisher.TestPublisher;

public class FluxFlatMapOnDiscardShouldNotLeakTest extends AbstractOnDiscardShouldNotLeakTest {

    public FluxFlatMapOnDiscardShouldNotLeakTest(boolean conditional, boolean fused) {
        super(conditional, fused);
    }

    @Override
    protected Publisher<Tracked<?>> transform(TestPublisher<Tracked<?>> main, TestPublisher<Tracked<?>>... additional) {
        return main
                .flux()
                .flatMap(f -> Mono.just(f).hide().flux());
    }
}
