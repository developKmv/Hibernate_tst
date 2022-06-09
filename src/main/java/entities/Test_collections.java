package entities;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.CompositeType;
import types.Obj;
import types.ObjType;

import javax.persistence.*;

//@TypeDef(name = "obj", typeClass = types.ObjType.class, defaultForType = Obj.class)

@Entity
@Table(name = "test_collections")
public class Test_collections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long t_id;

    @Column(name = "obj.name")
    private String name;
    @Column(name = "obj.\"sum\"")
    private Integer sum;
    @Column(name = "obj.cur")
    private Integer cur;

    /*@Columns(columns = { @Column(name = "NAME"),@Column(name = "sum"), @Column(name = "cur") })
    @Type(type = "types.ObjType")
    private Obj obj;*/

    public Test_collections() {
    };

    public Test_collections(Long t_id, String name, Integer sum, Integer cur) {
        this.t_id = t_id;
        this.name = name;
        this.sum = sum;
        this.cur = cur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getCur() {
        return cur;
    }

    public void setCur(Integer cur) {
        this.cur = cur;
    }

    public Long getT_id() {
        return t_id;
    }

    public void setT_id(Long t_id) {
        this.t_id = t_id;
    }


}
