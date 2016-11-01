package com.prashant.filesystem.entity.file;

public class FileFactory {

    public static File getFileInstance(Extension extension,String name){
        for (Extension extn : Extension.values()) {
           if(extension.equals(extn))
               return extension.getFile(name);
        }
        return null;
    }


}
