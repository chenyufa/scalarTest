/**
 * Created by CYF
 * on 2019/10/9.
 */
public final  class Metric {


    public final Long count;


    private Metric( Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "[count=" + count + "]";
    }

}
