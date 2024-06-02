package filesystem;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Directory {
    private final String id;
    private String name;

    private Map<String, File> files;

    private Map<String, Directory> directories;

    public Directory(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.files = new ConcurrentHashMap<>();
        this.directories = new ConcurrentHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addDirectory(Directory directory) {
        directories.putIfAbsent(directory.name, directory);
        System.out.println("Directory added: " + directory.getName());
    }

    public void addFile(File file) {
        files.putIfAbsent(file.getId(), file);
        System.out.println("File added: " + file.getName());
    }

    public File getFile(String id) {
        return files.get(id);
    }

    public Directory getDirectory(String id) {
        return directories.get(id);
    }
}
