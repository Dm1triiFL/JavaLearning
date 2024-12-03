package org.example.part_4.part_A;

import java.io.File;

public class Directory {
    private String path;

    public Directory(String path) {
        this.path = path;
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs(); // Создает директорию, если не существует
        }
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Directory)) return false;
        Directory directory = (Directory) o;
        return path.equals(directory.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }

    @Override
    public String toString() {
        return "Directory{" +
                "path='" + path + '\'' +
                '}';
    }
}

