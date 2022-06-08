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



    @Columns(columns = { @Column(name = "NAME"),@Column(name = "sum"), @Column(name = "cur") })
    @Type(type = "types.ObjType")
    private Obj obj;

    public Test_collections() {
    };

    public Test_collections(Long t_id, Obj obj) {
        this.t_id = t_id;
        this.obj = obj;
    };

    public Long getT_id() {
        return t_id;
    }

    public void setT_id(Long t_id) {
        this.t_id = t_id;
    }

    public Obj getObj() {
        return obj;
    }

    public void setObj(Obj obj) {
        this.obj = obj;
    }
}
