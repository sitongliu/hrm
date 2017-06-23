package com.hrm.mapper;

import com.hrm.model.Dept;
import com.hrm.model.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DeptMapper {
    @SelectProvider(type=DeptSqlProvider.class, method="countByExample")
    int countByExample(DeptExample example);

    @DeleteProvider(type=DeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(DeptExample example);

    @Delete({
        "delete from dept_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into dept_inf (ID, NAME, ",
        "REMARK)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(Dept record);

    @InsertProvider(type=DeptSqlProvider.class, method="insertSelective")
    int insertSelective(Dept record);

    @SelectProvider(type=DeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<Dept> selectByExample(DeptExample example);

    @Select({
        "select",
        "ID, NAME, REMARK",
        "from dept_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Dept selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    @UpdateProvider(type=DeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    @UpdateProvider(type=DeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dept record);

    @Update({
        "update dept_inf",
        "set NAME = #{name,jdbcType=VARCHAR},",
          "REMARK = #{remark,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Dept record);
}