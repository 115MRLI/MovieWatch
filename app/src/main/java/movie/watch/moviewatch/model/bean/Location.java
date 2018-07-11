package movie.watch.moviewatch.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * 地区信息
 */
public class Location {

    @SerializedName("p")
    private List<PBean> p;

    public List<PBean> getP() {
        return p;
    }

    public void setP(List<PBean> p) {
        this.p = p;
    }

    public static class PBean {
        /**
         * count : 310
         * id : 292
         * n : 上海
         * pinyinFull : Shanghai
         * pinyinShort : sh
         */

        @SerializedName("count")
        private int count;
        @SerializedName("id")
        private int id;
        @SerializedName("n")
        private String n;
        @SerializedName("pinyinFull")
        private String pinyinFull;
        @SerializedName("pinyinShort")
        private String pinyinShort;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public String getPinyinFull() {
            return pinyinFull;
        }

        public void setPinyinFull(String pinyinFull) {
            this.pinyinFull = pinyinFull;
        }

        public String getPinyinShort() {
            return pinyinShort;
        }

        public void setPinyinShort(String pinyinShort) {
            this.pinyinShort = pinyinShort;
        }

        @Override
        public String toString() {
            return "PBean{" +
                    "count=" + count +
                    ", id=" + id +
                    ", n='" + n + '\'' +
                    ", pinyinFull='" + pinyinFull + '\'' +
                    ", pinyinShort='" + pinyinShort + '\'' +
                    '}';
        }
    }
}
