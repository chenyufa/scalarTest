

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by CYF
 * on 2019/10/9.
 */
public class JDBCConnectOperation {


    public static void main(String[] args) {
        ConnectByNativeJDBC();
        //ConnectByJDBC();
        //ConnectByClickhouse4j();
    }


    //第三方的clickhouse-native-jdbc
    public  static void  ConnectByNativeJDBC(){
        String address = "jdbc:clickhouse://192.168.1.187:8123/test_db";
        String ClassForName = "com.github.housepower.jdbc.ClickHouseDriver";

        String sqlDB = "show databases";//查询数据库
        String sqlTab = "show tables";//查看表
        String sqlCount = "select count(*) count from test_db.tb_lieyou_total_consume ";//查询ontime数据量

        exeSql(address,ClassForName,sqlDB);
        exeSql(address,ClassForName,sqlTab);
        exeSql(address,ClassForName,sqlCount);

    }

    //官方的clickhouse-jdbc方式
    public static void ConnectByJDBC(){
        String address = "jdbc:clickhouse://192.168.1.187:8123/test_db";
        String ClassForName = "ru.yandex.clickhouse.ClickHouseDriver";

        String sqlDB = "show databases";//查询数据库
        String sqlTab = "show tables";//查看表
        String sqlCount = "select count(*) count from test_db.tb_lieyou_total_consume ";//查询ontime数据量

        exeSql(address,ClassForName,sqlDB);
        exeSql(address,ClassForName,sqlTab);
        exeSql(address,ClassForName,sqlCount);

    }

    //第三方的 clickhouse4j
    public static void ConnectByClickhouse4j(){

        String address = "jdbc:clickhouse://192.168.1.187:8123/test_db";
        String ClassForName = "cc.blynk.clickhouse.ClickHouseDriver";

        String sqlDB = "show databases";//查询数据库
        String sqlTab = "show tables";//查看表
        String sqlCount = "select count(*) count from test_db.tb_lieyou_total_consume ";//查询ontime数据量

        exeSql(address,ClassForName,sqlDB);
        exeSql(address,ClassForName,sqlTab);
        exeSql(address,ClassForName,sqlCount);

    }

    public static void exeSql(String address,String ClassForName,String sql){

        String userName = "ck";
        String passWord = "ap_ck";
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        try {
            Class.forName(ClassForName);
            connection = DriverManager.getConnection(address,userName,passWord);
            statement = connection.createStatement();
            long begin = System.currentTimeMillis();
            results = statement.executeQuery(sql);
            long end = System.currentTimeMillis();
            System.out.println("执行（"+sql+"）耗时："+(end-begin)+"ms");
            ResultSetMetaData rsmd = results.getMetaData();
            List<Map> list = new ArrayList();
            while(results.next()){
                Map map = new HashMap();
                for(int i = 1;i<=rsmd.getColumnCount();i++){
                    map.put(rsmd.getColumnName(i),results.getString(rsmd.getColumnName(i)));
                }
                list.add(map);
            }
            for(Map map : list){
                System.err.println(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {//关闭连接
            try {
                if(results!=null){
                    results.close();
                }
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
