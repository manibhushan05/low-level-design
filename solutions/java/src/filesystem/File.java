package filesystem;

import java.util.UUID;

public class File {
    private final String id;
    private final String name;
    private String content;
    private boolean isOpen;

    public File(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.content = null;
        this.isOpen = false;
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("File Opened " + name);
        } else {
            System.out.println("File is already open: " + name);
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("File closed:- " + name);
        } else {
            System.out.println("File is already closed" + name);
        }
    }

    public void write(String content) {
        if (isOpen) {
            this.content = content;
            System.out.println("Content is written  to file " + name);
        } else {
            System.out.println("File is not open: " + name);
        }
    }

    public String read() {
        if (isOpen) {
            System.out.println("Reading content of file " + name);
            return content;
        } else {
            System.out.println("File is not opened" + name);
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
