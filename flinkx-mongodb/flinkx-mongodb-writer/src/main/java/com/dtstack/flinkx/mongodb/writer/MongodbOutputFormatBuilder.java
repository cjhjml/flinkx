package com.dtstack.flinkx.mongodb.writer;

import com.dtstack.flinkx.outputformat.RichOutputFormatBuilder;

import java.util.List;

/**
 * @author jiangbo
 * @date 2018/6/5 21:17
 */
public class MongodbOutputFormatBuilder extends RichOutputFormatBuilder {

    private MongodbOutputFormat format;

    protected List<String> filterColumns;

    protected List<String> updateColumns;

    public MongodbOutputFormatBuilder() {
        super.format = format = new MongodbOutputFormat();
    }

    public void setHostPorts(String hostPorts){
        format.hostPorts = hostPorts;
    }

    public void setUsername(String username){
        format.username = username;
    }

    public void setPassword(String password){
        format.password = password;
    }

    public void setDatabase(String database){
        format.database = database;
    }

    public void setCollection(String collection){
        format.collectionName = collection;
    }

    public void setColumnNames(List<String> names){
        format.columnNames = names;
    }

    public void setColumnTypes(List<String> types){
        format.columnTypes = types;
    }

    public void setMode(String mode){
        format.mode = mode;
    }

    public void setFilterColumns(List<String> filterColumns) {
        this.format.filterColumns = filterColumns;
    }

    public void setUpdateColumns(List<String> updateColumns) {
        this.format.updateColumns = updateColumns;
    }

    @Override
    protected void checkFormat() {
        if(format.hostPorts == null){
            throw new IllegalArgumentException("No host supplied");
        }

        if(format.database == null){
            throw new IllegalArgumentException("No database supplied");
        }

        if(format.collectionName == null){
            throw new IllegalArgumentException("No collection supplied");
        }
    }
}