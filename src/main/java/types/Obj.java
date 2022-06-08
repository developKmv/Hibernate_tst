package types;

import java.io.Serializable;

public class Obj implements Serializable {
    private String name;
    private Integer sum;
    private Integer cur;

    public Obj(){};

    public Obj(String name,int sum,int cur){
      this.name = name;
      this.sum = sum;
      this.cur = cur;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCur() {
        return cur;
    }

    public void setCur(Integer cur) {
        this.cur = cur;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
