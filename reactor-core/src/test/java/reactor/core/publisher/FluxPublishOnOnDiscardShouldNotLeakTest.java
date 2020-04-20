package reactor.core.publisher;

import org.reactivestreams.Publisher;
import reactor.core.scheduler.Schedulers;
import reactor.test.publisher.TestPublisher;

public class FluxPublishOnOnDiscardShouldNotLeakTest extends AbstractOnDiscardShouldNotLeakTest {

    public FluxPublishOnOnDiscardShouldNotLeakTest(boolean conditional, boolean fused) {
        super(conditional, fused);
    }

    @Override
    protected Publisher<Tracked<?>> transform(TestPublisher<Tracked<?>> main, TestPublisher<Tracked<?>>... additional) {
        return main
                .flux()
                .publishOn(Schedulers.immediate());
    }
}
