import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FolderWordCount {

    public static void main(String[] args) {
        // 确保命令行参数长度正确，否则提供使用说明
        if (args.length != 1) {
            System.out.println("Usage: java FolderWordCount /Users/biancheng/Downloads/H");
            System.exit(1);
        }

        // 获取文件夹路径
        String directoryPath = args[0];
        File directory = new File(directoryPath);

        // 检查是否为目录
        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory.");
            System.exit(1);
        }

        // 获取目录中的所有文件
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null) {
            System.out.println("Error listing files in directory.");
            System.exit(1);
        }

        // 遍历文件
        for (File file : files) {
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                int c;
                // 读取每个字符，直到文件结束
                while ((c = reader.read()) != -1) {
                    char character = (char) c;
                    // 简单判断字符是否为汉字或其他字符
                    if (Character.toString(character).matches("\\S")) {
                        charCount++;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file '" + file.getName() + "': " + e.getMessage());
                continue;
            }

            // 输出文件名和对应的字数
            System.out.println("File: " + file.getName() + " - Characters: " + charCount);
        }
    }
}
