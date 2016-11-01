package com.prashant.filesystem.entity.file;
import com.prashant.filesystem.entity.file.fileTypes.*;


/**
 * Created by PPandey on 8/18/2016.
 */
public enum Extension {
    TXT{
        @Override
        public File getFile(String name) {
            return new TextFile(name);
        }
    },
    XLS{
        @Override
        public File getFile(String name) {return new XlsFile(name);}
    },
    XML{
        @Override
        public File getFile(String name) {
            return new XmlFile(name);
        }
    },
    DOC{
        @Override
        public File getFile(String name) {
            return new DocFile(name);
        }
    };

    public abstract File getFile(String name);
}
