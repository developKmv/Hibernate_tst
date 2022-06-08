package types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.*;
import org.hibernate.usertype.CompositeUserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

public class ObjType implements CompositeUserType
{

    @Override
    public String[] getPropertyNames() {
        return new String[]{"name","sum","cur"};
    }

    @Override
    public Type[] getPropertyTypes() {
        return new Type[]{StringType.INSTANCE, IntegerType.INSTANCE,IntegerType.INSTANCE};
        //return new Type[]{StandardBasicTypes.STRING,StandardBasicTypes.INTEGER,StandardBasicTypes.INTEGER};
    }

    @Override
    public Object getPropertyValue(Object o, int i) throws HibernateException {

        Obj obj = (Obj) o;

        switch (i){
            case 0:
                return obj.getName();
            case 1:
                return obj.getSum();
            case 2:
                return obj.getCur();
        }

        throw new IllegalArgumentException(o +
                " is an invalid property index for class type " +
                obj.getClass().getName());
    }

    @Override
    public void setPropertyValue(Object o, int i, Object o1) throws HibernateException {
        Obj obj = (Obj) o;

        switch (i){
            case 0:
                obj.setName((String) o1);
            case 1:
                obj.setSum((Integer) o1);
            case 2:
                obj.setCur((Integer) o1);

        throw new IllegalArgumentException(o + "is a invalid property for class type " +
                obj.getClass().getName());

        }
    }

    @Override
    public Class returnedClass() {
        return Obj.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {

        if(o == o1) return true;
        if(Objects.isNull(o) || Objects.isNull(o1)) return false;
        return o.equals(o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {

        if(resultSet.wasNull()) return null;

        Obj obj = new Obj();
        obj.setName(resultSet.getString(strings[0]));
        obj.setSum(resultSet.getInt(strings[1]));
        obj.setCur(resultSet.getInt(strings[2]));

        return obj;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if(Objects.isNull(o)){
            preparedStatement.setNull(i, Types.VARCHAR);
        }else{
            Obj obj = (Obj) o;
            preparedStatement.setString(i,obj.getName());
            preparedStatement.setInt(i+1,obj.getSum());
            preparedStatement.setInt(i+2,obj.getCur());
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {

        if(Objects.isNull(o)) return null;

        Obj obj = (Obj)o;
        Obj objForCopy = new Obj(obj.getName(),obj.getSum(), obj.getSum());

        return objForCopy;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object o, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException {
        return (Serializable) deepCopy(o);
    }

    @Override
    public Object assemble(Serializable serializable, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return deepCopy(serializable);
    }

    @Override
    public Object replace(Object o, Object o1, SharedSessionContractImplementor sharedSessionContractImplementor, Object o2) throws HibernateException {
        return o;
    }
}