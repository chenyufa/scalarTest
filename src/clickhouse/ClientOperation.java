import com.virtusai.clickhouseclient.ClickHouseClient;



/**
 * Created by CYF
 * on 2019/10/9.
 */
public class ClientOperation {

    public static void main(String[] args) {

        ClickHouseClient client = new ClickHouseClient("http://192.168.1.187:8123", "ck", "ap_ck");

        client.get("select count(distinct dt) count from test_db.tb_lieyou_total_consume;",Metric.class)
                .thenAccept(res -> System.out.println(res));



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(client != null){
            client.close();
        }

    }


}
