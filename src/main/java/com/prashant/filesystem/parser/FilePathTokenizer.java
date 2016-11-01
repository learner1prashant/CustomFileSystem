package com.prashant.filesystem.parser;
import com.prashant.filesystem.exception.InValidFilePathException;
import java.util.StringTokenizer;


// Singleton pattern utilise to reuse the same FilePathTokenizer for every request
public class FilePathTokenizer extends StringTokenizer {
    static String delimit = "/";
    static PathParser pathParser= null;

    private FilePathTokenizer(String str, String delim) {
        super(str,delim);
        pathParser = new PathParser();
    }

    public static FilePathTokenizer getInstance(String path) throws InValidFilePathException {
        if(pathParser.isUnValidPath(path))
            throw new InValidFilePathException();

        return new FilePathTokenizer(path,delimit);
    }



}
