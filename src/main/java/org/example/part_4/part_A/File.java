package org.example.part_4.part_A;

import java.io.IOException;
import java.util.Objects;

public abstract class File {
    protected String name;
    protected Directory directory;

    public File(String name, Directory directory) {
        this.name = name;
        this.directory = directory;
    }

    public abstract void create() throws IOException;

    public abstract void rename(String newName) throws IOException;

    public abstract void display() throws IOException;

    public abstract void append(String content) throws IOException;

    public abstract void delete() throws IOException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return Objects.equals(name, file.name) && Objects.equals(directory, file.directory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, directory);
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", directory=" + directory +
                '}';
    }
}
