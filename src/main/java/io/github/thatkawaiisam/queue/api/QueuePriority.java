package io.github.thatkawaiisam.queue.api;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QueuePriority implements Comparable<QueuePriority> {

    private String name;
    private int amount;

    @Override
    public int compareTo(QueuePriority priority) {
        return this.amount - priority.amount;
    }
}
