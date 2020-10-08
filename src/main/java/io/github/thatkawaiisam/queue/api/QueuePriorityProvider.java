package io.github.thatkawaiisam.queue.api;

import java.util.UUID;

public interface QueuePriorityProvider {

    /**
     * Get QueuePriority of player.
     *
     * @param uuid of player.
     * @return QueuePriority object of player.
     */
    QueuePriority getPriority(UUID uuid);

}
