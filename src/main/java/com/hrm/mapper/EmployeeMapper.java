package com.hrm.mapper;

import com.hrm.model.Employee;
import com.hrm.model.EmployeeExample;
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

public interface EmployeeMapper {
    @SelectProvider(type=EmployeeSqlProvider.class, method="countByExample")
    int countByExample(EmployeeExample example);

    @DeleteProvider(type=EmployeeSqlProvider.class, method="deleteByExample")
    int deleteByExample(EmployeeExample example);

    @Delete({
        "delete from employee_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employee_inf (ID, DEPT_ID, ",
        "JOB_ID, NAME, CARD_ID, ",
        "ADDRESS, POST_CODE, ",
        "TEL, PHONE, QQ_NUM, ",
        "EMAIL, SEX, PARTY, ",
        "BIRTHDAY, RACE, ",
        "EDUCATION, SPECIALITY, ",
        "HOBBY, REMARK, CREATE_DATE)",
        "values (#{id,jdbcType=INTEGER}, #{deptId,jdbcType=INTEGER}, ",
        "#{jobId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{cardId,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{postCode,jdbcType=VARCHAR}, ",
        "#{tel,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{qqNum,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{sex,jdbcType=INTEGER}, #{party,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=TIMESTAMP}, #{race,jdbcType=VARCHAR}, ",
        "#{education,jdbcType=VARCHAR}, #{speciality,jdbcType=VARCHAR}, ",
        "#{hobby,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(Employee record);

    @InsertProvider(type=EmployeeSqlProvider.class, method="insertSelective")
    int insertSelective(Employee record);

    @SelectProvider(type=EmployeeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="DEPT_ID", property="deptId", jdbcType=JdbcType.INTEGER),
        @Result(column="JOB_ID", property="jobId", jdbcType=JdbcType.INTEGER),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="CARD_ID", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="POST_CODE", property="postCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEL", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="QQ_NUM", property="qqNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="PARTY", property="party", jdbcType=JdbcType.VARCHAR),
        @Result(column="BIRTHDAY", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RACE", property="race", jdbcType=JdbcType.VARCHAR),
        @Result(column="EDUCATION", property="education", jdbcType=JdbcType.VARCHAR),
        @Result(column="SPECIALITY", property="speciality", jdbcType=JdbcType.VARCHAR),
        @Result(column="HOBBY", property="hobby", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Employee> selectByExample(EmployeeExample example);

    @Select({
        "select",
        "ID, DEPT_ID, JOB_ID, NAME, CARD_ID, ADDRESS, POST_CODE, TEL, PHONE, QQ_NUM, ",
        "EMAIL, SEX, PARTY, BIRTHDAY, RACE, EDUCATION, SPECIALITY, HOBBY, REMARK, CREATE_DATE",
        "from employee_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="DEPT_ID", property="deptId", jdbcType=JdbcType.INTEGER),
        @Result(column="JOB_ID", property="jobId", jdbcType=JdbcType.INTEGER),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="CARD_ID", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="POST_CODE", property="postCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEL", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="QQ_NUM", property="qqNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="PARTY", property="party", jdbcType=JdbcType.VARCHAR),
        @Result(column="BIRTHDAY", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RACE", property="race", jdbcType=JdbcType.VARCHAR),
        @Result(column="EDUCATION", property="education", jdbcType=JdbcType.VARCHAR),
        @Result(column="SPECIALITY", property="speciality", jdbcType=JdbcType.VARCHAR),
        @Result(column="HOBBY", property="hobby", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    Employee selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Employee record);

    @Update({
        "update employee_inf",
        "set DEPT_ID = #{deptId,jdbcType=INTEGER},",
          "JOB_ID = #{jobId,jdbcType=INTEGER},",
          "NAME = #{name,jdbcType=VARCHAR},",
          "CARD_ID = #{cardId,jdbcType=VARCHAR},",
          "ADDRESS = #{address,jdbcType=VARCHAR},",
          "POST_CODE = #{postCode,jdbcType=VARCHAR},",
          "TEL = #{tel,jdbcType=VARCHAR},",
          "PHONE = #{phone,jdbcType=VARCHAR},",
          "QQ_NUM = #{qqNum,jdbcType=VARCHAR},",
          "EMAIL = #{email,jdbcType=VARCHAR},",
          "SEX = #{sex,jdbcType=INTEGER},",
          "PARTY = #{party,jdbcType=VARCHAR},",
          "BIRTHDAY = #{birthday,jdbcType=TIMESTAMP},",
          "RACE = #{race,jdbcType=VARCHAR},",
          "EDUCATION = #{education,jdbcType=VARCHAR},",
          "SPECIALITY = #{speciality,jdbcType=VARCHAR},",
          "HOBBY = #{hobby,jdbcType=VARCHAR},",
          "REMARK = #{remark,jdbcType=VARCHAR},",
          "CREATE_DATE = #{createDate,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Employee record);
}