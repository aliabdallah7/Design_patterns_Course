// Abstract File class
abstract class File
{
    abstract void open(String fileLocation);
    abstract void delete();
}

// PDFFile class
class PDFFile extends File {
    @Override
    void open(String fileLocation)
    {
        // Implement PDF file opening logic
        System.out.println("Opening PDF file: " + fileLocation);
        // Your PDF-specific logic here
    }

    @Override
    void delete()
    {
        // Implement PDF file deletion logic
        System.out.println("Deleting PDF file");
        // Your PDF-specific deletion logic here
    }
}

// WordFile class
class WordFile extends File {
    @Override
    void open(String fileLocation)
    {
        // Implement Word file opening logic
        System.out.println("Opening Word file: " + fileLocation);
        // Your Word-specific logic here
    }

    @Override
    void delete()
    {
        // Implement Word file deletion logic
        System.out.println("Deleting Word file");
        // Your Word-specific deletion logic here
    }
}

// FileFactory class
class FileFactory {
    public static File createFile(String fileType)
    {
        if (fileType.equalsIgnoreCase("PDF"))
        {
            return new PDFFile();
        }
        else if (fileType.equalsIgnoreCase("Word"))
        {
            return new WordFile();
        }
        else
        {
            throw new IllegalArgumentException("Invalid file type: " + fileType);
        }
    }
}

public class Lab4_HandsOn1 {
    public static void main(String[] args)
    {
        // Creating files using the FileFactory
        File pdfFile = FileFactory.createFile("PDF");
        pdfFile.open("/path/to/pdf_file.pdf");
        pdfFile.delete();

        File wordFile = FileFactory.createFile("Word");
        wordFile.open("/path/to/word_file.docx");
        wordFile.delete();
    }
}