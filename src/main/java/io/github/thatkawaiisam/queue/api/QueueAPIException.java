package io.github.thatkawaiisam.queue.api;

public class QueueAPIException extends UnsupportedOperationException {

    /**
     * Queue API Exception.
     *
     * @param message to be attached.
     */
    public QueueAPIException(String message) {
        super(message);
    }
}
