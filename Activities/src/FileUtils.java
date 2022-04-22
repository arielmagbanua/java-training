import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    public static ArrayList<File> listFiles(String source, String[] extensions) {
        // prepare the list of files
        ArrayList<File> files = new ArrayList<>();

        // create the source file from source
        File sourceFile = new File(source);

        if (!sourceFile.exists()) {
            // the source file does not exist so return immediately the files list
            return files;
        }

        if (sourceFile.isDirectory()) {
            // get the files of the source directory
            File[] sourceFiles = sourceFile.listFiles();

            if (sourceFiles != null) {
                // convert the extensions to list
                List<String> extensionList = Arrays.asList(extensions);

                // check each file if their extension is one of the specified to filter
                for (File file : sourceFiles) {
                    // get the file path
                    String path = file.getPath();

                    if (file.isDirectory()) {
                        // call the method recursively to get all the files from this directory
                        ArrayList<File> directoryFiles = listFiles(path, extensions);
                        files.addAll(directoryFiles);
                    } else {
                        // get the extension
                        String extension = path.substring(path.lastIndexOf(".") + 1);

                        if (extensionList.contains(extension)) {
                            // the extension of the file is one of the specified extension list so add it
                            files.add(file);
                        }
                    }
                }
            }
        }

        // return the files
        return files;
    }

    public static void main(String[] args) {
        ArrayList<File> files = FileUtils.listFiles("c:\\projects", new String[] {"cpp", "java"});
        System.out.println(files);
    }
}
