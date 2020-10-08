package io.github.thatkawaiisam.queue.api;

import java.util.List;
import java.util.UUID;

public abstract class QueueAPI {

    private static QueueAPI apiInstance;

    /**
     * Queue API.
     */
    public QueueAPI() {
        apiInstance = this;
        System.out.println("[Queue] API has now been loaded.");
    }

    public static QueueAPI INSTANCE() {
        if (apiInstance == null) {
            throw new QueueAPIException("API is currently not loaded!");
        }
        return apiInstance;
    }

    /**
     * Check if a player is in a Queue.
     *
     * @param uuid of player.
     * @return whether the player is in a queue or not.
     */
    public boolean isInQueue(UUID uuid) {
        return getQueueByPlayerUUID(uuid) != null;
    }

    /**
     * Get the position of a player in a Queue.
     *
     * @param uuid of player.
     * @return the position of the player in a queue. Note: Will return -1 if player is not in a queue.
     */
    public int getPositionInQueue(UUID uuid) {
        Queue queue = getQueueByPlayerUUID(uuid);
        if (queue == null) {
            return -1;
        }
        return queue.getPosition(uuid);
    }

    /**
     * Get the total amount of people in a Queue.
     *
     * @param queue to calculate players.
     * @return amount of players. Note: Will return -1 if queue doesn't exist.
     */
    public int getTotalInQueue(Queue queue) {
        if (queue == null) {
            return -1;
        }
        return queue.getTotal();
    }

    /**
     * Gets the total in Queue of Player.
     *
     * @param uuid of Player
     * @return total in Queue. Note: Will return -1 if Queue doesn't exist.
     */
    public int getTotalInQueue(UUID uuid) {
        Queue queue = getQueueByPlayerUUID(uuid);
        if (queue == null) {
            return -1;
        }
        return queue.getPosition(uuid);
    }

    /**
     * Get's Queue by it's ID.
     *
     * @param id of Queue.
     * @return Queue if it exists.
     */
    public abstract Queue getQueueByID(String id);

    /**
     * Get's Queue by Player UUID.
     *
     * @param uuid of player.
     * @return Queue if player is in one.
     */
    public abstract Queue getQueueByPlayerUUID(UUID uuid);

    /**
     * Get a list of Queues in the local cache.
     *
     * @return list of Queues.
     */
    public abstract List<Queue> getQueues();

}
