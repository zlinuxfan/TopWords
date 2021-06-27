import java.util.Objects;

public class Status {
    private int counter;

    public Status() {
        this.counter = 1;
    }

    public Status increment() {
        this.counter++;
        return this;
    }

    public int getCounter() {
        return this.counter;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Status status = (Status) o;
        return counter == status.counter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter);
    }
}
