package com.hrm.mapper;

import com.hrm.model.Job;
import com.hrm.model.JobExample;
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

public interface JobMapper {
    @SelectProvider(type=JobSqlProvider.class, method="countByExample")
    int countByExample(JobExample example);

    @DeleteProvider(type=JobSqlProvider.class, method="deleteByExample")
    int deleteByExample(JobExample example);

    @Delete({
        "delete from job_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into job_inf (ID, NAME, ",
        "REMARK)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(Job record);

    @InsertProvider(type=JobSqlProvider.class, method="insertSelective")
    int insertSelective(Job record);

    @SelectProvider(type=JobSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<Job> selectByExample(JobExample example);

    @Select({
        "select",
        "ID, NAME, REMARK",
        "from job_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Job selectByPrimaryKey(Integer id);

    @UpdateProvider(type=JobSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Job record, @Param("example") JobExample example);

    @UpdateProvider(type=JobSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Job record, @Param("example") JobExample example);

    @UpdateProvider(type=JobSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Job record);

    @Update({
        "update job_inf",
        "set NAME = #{name,jdbcType=VARCHAR},",
          "REMARK = #{remark,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Job record);
}