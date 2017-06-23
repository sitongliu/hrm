package com.hrm.mapper;

import com.hrm.model.Notice;
import com.hrm.model.NoticeExample;
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

public interface NoticeMapper {
    @SelectProvider(type=NoticeSqlProvider.class, method="countByExample")
    int countByExample(NoticeExample example);

    @DeleteProvider(type=NoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(NoticeExample example);

    @Delete({
        "delete from notice_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into notice_inf (ID, TITLE, ",
        "CREATE_DATE, USER_ID, ",
        "CONTENT)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Notice record);

    @InsertProvider(type=NoticeSqlProvider.class, method="insertSelective")
    int insertSelective(Notice record);

    @SelectProvider(type=NoticeSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Notice> selectByExampleWithBLOBs(NoticeExample example);

    @SelectProvider(type=NoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<Notice> selectByExample(NoticeExample example);

    @Select({
        "select",
        "ID, TITLE, CREATE_DATE, USER_ID, CONTENT",
        "from notice_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Notice selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    @UpdateProvider(type=NoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Notice record);

    @Update({
        "update notice_inf",
        "set TITLE = #{title,jdbcType=VARCHAR},",
          "CREATE_DATE = #{createDate,jdbcType=TIMESTAMP},",
          "USER_ID = #{userId,jdbcType=INTEGER},",
          "CONTENT = #{content,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Notice record);

    @Update({
        "update notice_inf",
        "set TITLE = #{title,jdbcType=VARCHAR},",
          "CREATE_DATE = #{createDate,jdbcType=TIMESTAMP},",
          "USER_ID = #{userId,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Notice record);
}