package tororo1066.musiccreateplugin.Utils.MySQL;

import java.util.ArrayList;
import java.util.function.Consumer;

public class SyncedMySQLRequest {
    public Consumer<Boolean> executeCallback;
    public Consumer<ArrayList<MySQLCachedResultSet>> queryCallback;
    public String query;

    public boolean isQuery(){
        return queryCallback != null;
    }
}
