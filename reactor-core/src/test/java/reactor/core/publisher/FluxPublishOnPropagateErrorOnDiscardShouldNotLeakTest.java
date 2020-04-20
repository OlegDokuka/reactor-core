package reactor.core.publisher;

import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

public class FluxPublishOnPropagateErrorOnDiscardShouldNotLeakTest extends AbstractOnDiscardShouldNotLeakTest {

    public FluxPublishOnPropagateErrorOnDiscardShouldNotLeakTest(boolean conditional, boolean fused) {
        super(conditional, fused);
    }

    @Override
    Flux<Tracked<?>> transform(Flux<Tracked<?>> upstream) {
        return upstream
                .publishOn(Schedulers.immediate(), false, Queues.SMALL_BUFFER_SIZE);
    }
}
