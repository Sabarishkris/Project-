package sudukosolver.datalayer;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database database;
    private List<String> indexlist=new ArrayList<>();
    public static Database getInstance(){
        if(database==null){
            database=new Database();
        }
        return database;
    }

    public void addIndex(int row, int column) {
        String index=""+row+column;
        indexlist.add(index);
    }

    public boolean isIndexAvailable(int row, int column) {
        String index=""+row+column;
        return indexlist.contains(index);
    }
}
