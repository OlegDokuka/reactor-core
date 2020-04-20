package reactor.core.publisher;

import org.reactivestreams.Publisher;
import reactor.test.publisher.TestPublisher;
import reactor.util.concurrent.Queues;

public class FluxMergeOnDiscardShouldNotLeakTest extends AbstractOnDiscardShouldNotLeakTest {

    public FluxMergeOnDiscardShouldNotLeakTest(boolean conditional, boolean fused) {
        super(conditional, fused);
    }

    @Override
    protected Publisher<Tracked<?>> transform(TestPublisher<Tracked<?>> main, TestPublisher<Tracked<?>>... additional) {
        Flux<Tracked<?>>[] inners = new Flux[subscriptionsNumber()];
        inners[0] = main.flux();
        for (int i = 1; i < subscriptionsNumber(); i++) {
            inners[i] = additional[i - 1].flux();
        }
        return Flux.merge(inners);
    }

    @Override
    int subscriptionsNumber() {
        return Queues.XS_BUFFER_SIZE;
    }
}
