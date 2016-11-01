package com.prashant.filesystem.entity.file;
import com.prashant.filesystem.DataBearable;
import com.prashant.filesystem.entity.detail.FileEntity;


// Interface segregation principle so that each subtype has to give required implementation and prevent request bequest
public class File extends FileEntity implements DataBearable {


    public File(String name) {
        super(name);
    }

    @Override
    public String getData() {
        return null;
    }

    @Override
    public String getExtension() {
        return null;
    }
}
