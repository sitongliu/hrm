package com.hrm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.hrm.model.Notice;
import com.hrm.model.NoticeExample.Criteria;
import com.hrm.model.NoticeExample.Criterion;
import com.hrm.model.NoticeExample;
import java.util.List;
import java.util.Map;

public class NoticeSqlProvider {

    public String countByExample(NoticeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("notice_inf");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(NoticeExample example) {
        BEGIN();
        DELETE_FROM("notice_inf");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Notice record) {
        BEGIN();
        INSERT_INTO("notice_inf");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("TITLE", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("CREATE_DATE", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            VALUES("USER_ID", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            VALUES("CONTENT", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(NoticeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("TITLE");
        SELECT("CREATE_DATE");
        SELECT("USER_ID");
        SELECT("CONTENT");
        FROM("notice_inf");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(NoticeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("TITLE");
        SELECT("CREATE_DATE");
        SELECT("USER_ID");
        FROM("notice_inf");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Notice record = (Notice) parameter.get("record");
        NoticeExample example = (NoticeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("notice_inf");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("TITLE = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("CREATE_DATE = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            SET("CONTENT = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("notice_inf");
        
        SET("ID = #{record.id,jdbcType=INTEGER}");
        SET("TITLE = #{record.title,jdbcType=VARCHAR}");
        SET("CREATE_DATE = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("USER_ID = #{record.userId,jdbcType=INTEGER}");
        SET("CONTENT = #{record.content,jdbcType=LONGVARCHAR}");
        
        NoticeExample example = (NoticeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("notice_inf");
        
        SET("ID = #{record.id,jdbcType=INTEGER}");
        SET("TITLE = #{record.title,jdbcType=VARCHAR}");
        SET("CREATE_DATE = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("USER_ID = #{record.userId,jdbcType=INTEGER}");
        
        NoticeExample example = (NoticeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Notice record) {
        BEGIN();
        UPDATE("notice_inf");
        
        if (record.getTitle() != null) {
            SET("TITLE = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("CREATE_DATE = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserId() != null) {
            SET("USER_ID = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            SET("CONTENT = #{content,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(NoticeExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}