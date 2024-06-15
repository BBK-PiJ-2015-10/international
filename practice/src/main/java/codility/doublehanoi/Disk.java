package codility.doublehanoi;

import java.util.Objects;

public class Disk {

    public int size;

    public Disk(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Disk{" +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disk disk = (Disk) o;
        return size == disk.size;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }
}
