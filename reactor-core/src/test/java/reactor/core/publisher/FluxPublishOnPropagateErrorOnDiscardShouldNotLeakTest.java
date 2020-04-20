package reactor.core.publisher;

import org.reactivestreams.Publisher;
import reactor.core.scheduler.Schedulers;
import reactor.test.publisher.TestPublisher;
import reactor.util.concurrent.Queues;

public class FluxPublishOnPropagateErrorOnDiscardShouldNotLeakTest extends AbstractOnDiscardShouldNotLeakTest {

    public FluxPublishOnPropagateErrorOnDiscardShouldNotLeakTest(boolean conditional, boolean fused) {
        super(conditional, fused);
    }

    @Override
    protected Publisher<Tracked<?>> transform(TestPublisher<Tracked<?>> main, TestPublisher<Tracked<?>>... additional) {
        return main
                .flux()
                .publishOn(Schedulers.immediate(), false, Queues.SMALL_BUFFER_SIZE);
    }
}
