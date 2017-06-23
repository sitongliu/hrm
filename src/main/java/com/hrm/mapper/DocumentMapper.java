package com.hrm.mapper;

import com.hrm.model.Document;
import com.hrm.model.DocumentExample;
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

public interface DocumentMapper {
    @SelectProvider(type=DocumentSqlProvider.class, method="countByExample")
    int countByExample(DocumentExample example);

    @DeleteProvider(type=DocumentSqlProvider.class, method="deleteByExample")
    int deleteByExample(DocumentExample example);

    @Delete({
        "delete from document_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into document_inf (ID, TITLE, ",
        "FILENAME, REMARK, ",
        "CREATE_DATE, USER_ID)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{filename,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER})"
    })
    int insert(Document record);

    @InsertProvider(type=DocumentSqlProvider.class, method="insertSelective")
    int insertSelective(Document record);

    @SelectProvider(type=DocumentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="FILENAME", property="filename", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<Document> selectByExample(DocumentExample example);

    @Select({
        "select",
        "ID, TITLE, FILENAME, REMARK, CREATE_DATE, USER_ID",
        "from document_inf",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="FILENAME", property="filename", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER)
    })
    Document selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DocumentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    @UpdateProvider(type=DocumentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    @UpdateProvider(type=DocumentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Document record);

    @Update({
        "update document_inf",
        "set TITLE = #{title,jdbcType=VARCHAR},",
          "FILENAME = #{filename,jdbcType=VARCHAR},",
          "REMARK = #{remark,jdbcType=VARCHAR},",
          "CREATE_DATE = #{createDate,jdbcType=TIMESTAMP},",
          "USER_ID = #{userId,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Document record);
}