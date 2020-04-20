package reactor.core.publisher;

import org.reactivestreams.Publisher;
import reactor.test.publisher.TestPublisher;

public class FluxOnBackpressureBufferOnDiscardShouldNotLeakTest extends AbstractOnDiscardShouldNotLeakTest {

    public FluxOnBackpressureBufferOnDiscardShouldNotLeakTest(boolean conditional, boolean fused) {
        super(conditional, fused);
    }

    @Override
    protected Publisher<Tracked<?>> transform(TestPublisher<Tracked<?>> main, TestPublisher<Tracked<?>>... additional) {
        return main
                .flux()
                .onBackpressureBuffer();
    }
}
