package io.github.thatkawaiisam.queue.api;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class QueueEntry implements Comparable<QueueEntry> {

    private UUID uuid;
    private long insertionTime, offlineSince = -1;
    private QueuePriority priority;

    @Override
    public int compareTo(QueueEntry otherPlayer) {
        if (this.priority.getAmount() - otherPlayer.getPriority().getAmount() == 0) {
            return insertionTime < otherPlayer.getInsertionTime() ? -1 : 1;
        }

        return 0;
    }

    /**
     * Checks whether the player is online based on their offline since time.
     *
     * @return if the player is online.
     */
    public boolean isOnline() {
        return offlineSince == -1;
    }
}
