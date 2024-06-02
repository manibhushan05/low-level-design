package filesystem;

import java.io.IOException;

public class FileSystem {
    private Directory root;

    public FileSystem() {
        root = new Directory("root");
    }

    public Directory getRoot() {
        return root;
    }

    public void createFile(String path, String fileName) {
        Directory directory = getDirectory(path);
        if (directory != null) {
            File file = new File(fileName);
            directory.addFile(file);
        } else {
            System.out.println("Invalid path: " + path);
        }
    }

    public void createDirectory(String path, String dirName) {
        Directory directory = getDirectory(path);
        if (directory != null) {
            Directory newDir = new Directory(dirName);
            directory.addDirectory(newDir);
        } else {
            System.out.println("Invalid path: " + path);
        }
    }

    public void openFile(String path, String fileName) {
        File file = getFile(path, fileName);
        if (file != null) {
            file.open();
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    public void closeFile(String path, String fileName) {
        File file = getFile(path, fileName);
        if (file != null) {
            file.close();
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    public void writeFile(String path, String fileName, String content) throws IOException {
        File file = getFile(path, fileName);
        if (file != null) {
            file.write(content);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    public void readFile(String path, String fileName) throws IOException {
        File file = getFile(path, fileName);
        if (file != null) {
            System.out.println(file.read());
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    private Directory getDirectory(String path) {
        String[] dirs = path.split("/");
        Directory current = root;
        for (String dir : dirs) {
            if (!dir.isEmpty()) {
                current = current.getDirectory(dir);
                if (current == null) {
                    return null;
                }
            }
        }
        return current;
    }

    private File getFile(String path, String fileName) {
        Directory directory = getDirectory(path);
        if (directory != null) {
            return directory.getFile(fileName);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        FileSystem fs = new FileSystem();

        fs.createDirectory("/root", "docs");
        fs.createFile("/root/docs", "file1.txt");

        fs.openFile("/root/docs", "file1.txt");
        fs.writeFile("/root/docs", "file1.txt", "Hello, World!");
        fs.readFile("/root/docs", "file1.txt");
        fs.closeFile("/root/docs", "file1.txt");
    }
}
