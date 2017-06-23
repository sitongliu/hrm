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

import com.hrm.model.Employee;
import com.hrm.model.EmployeeExample.Criteria;
import com.hrm.model.EmployeeExample.Criterion;
import com.hrm.model.EmployeeExample;
import java.util.List;
import java.util.Map;

public class EmployeeSqlProvider {

    public String countByExample(EmployeeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("employee_inf");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(EmployeeExample example) {
        BEGIN();
        DELETE_FROM("employee_inf");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Employee record) {
        BEGIN();
        INSERT_INTO("employee_inf");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDeptId() != null) {
            VALUES("DEPT_ID", "#{deptId,jdbcType=INTEGER}");
        }
        
        if (record.getJobId() != null) {
            VALUES("JOB_ID", "#{jobId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("NAME", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCardId() != null) {
            VALUES("CARD_ID", "#{cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("ADDRESS", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getPostCode() != null) {
            VALUES("POST_CODE", "#{postCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            VALUES("TEL", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("PHONE", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getQqNum() != null) {
            VALUES("QQ_NUM", "#{qqNum,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("EMAIL", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            VALUES("SEX", "#{sex,jdbcType=INTEGER}");
        }
        
        if (record.getParty() != null) {
            VALUES("PARTY", "#{party,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("BIRTHDAY", "#{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRace() != null) {
            VALUES("RACE", "#{race,jdbcType=VARCHAR}");
        }
        
        if (record.getEducation() != null) {
            VALUES("EDUCATION", "#{education,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeciality() != null) {
            VALUES("SPECIALITY", "#{speciality,jdbcType=VARCHAR}");
        }
        
        if (record.getHobby() != null) {
            VALUES("HOBBY", "#{hobby,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("REMARK", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("CREATE_DATE", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(EmployeeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("DEPT_ID");
        SELECT("JOB_ID");
        SELECT("NAME");
        SELECT("CARD_ID");
        SELECT("ADDRESS");
        SELECT("POST_CODE");
        SELECT("TEL");
        SELECT("PHONE");
        SELECT("QQ_NUM");
        SELECT("EMAIL");
        SELECT("SEX");
        SELECT("PARTY");
        SELECT("BIRTHDAY");
        SELECT("RACE");
        SELECT("EDUCATION");
        SELECT("SPECIALITY");
        SELECT("HOBBY");
        SELECT("REMARK");
        SELECT("CREATE_DATE");
        FROM("employee_inf");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Employee record = (Employee) parameter.get("record");
        EmployeeExample example = (EmployeeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("employee_inf");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getDeptId() != null) {
            SET("DEPT_ID = #{record.deptId,jdbcType=INTEGER}");
        }
        
        if (record.getJobId() != null) {
            SET("JOB_ID = #{record.jobId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("NAME = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getCardId() != null) {
            SET("CARD_ID = #{record.cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("ADDRESS = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getPostCode() != null) {
            SET("POST_CODE = #{record.postCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            SET("TEL = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("PHONE = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getQqNum() != null) {
            SET("QQ_NUM = #{record.qqNum,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("EMAIL = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("SEX = #{record.sex,jdbcType=INTEGER}");
        }
        
        if (record.getParty() != null) {
            SET("PARTY = #{record.party,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("BIRTHDAY = #{record.birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRace() != null) {
            SET("RACE = #{record.race,jdbcType=VARCHAR}");
        }
        
        if (record.getEducation() != null) {
            SET("EDUCATION = #{record.education,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeciality() != null) {
            SET("SPECIALITY = #{record.speciality,jdbcType=VARCHAR}");
        }
        
        if (record.getHobby() != null) {
            SET("HOBBY = #{record.hobby,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("CREATE_DATE = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("employee_inf");
        
        SET("ID = #{record.id,jdbcType=INTEGER}");
        SET("DEPT_ID = #{record.deptId,jdbcType=INTEGER}");
        SET("JOB_ID = #{record.jobId,jdbcType=INTEGER}");
        SET("NAME = #{record.name,jdbcType=VARCHAR}");
        SET("CARD_ID = #{record.cardId,jdbcType=VARCHAR}");
        SET("ADDRESS = #{record.address,jdbcType=VARCHAR}");
        SET("POST_CODE = #{record.postCode,jdbcType=VARCHAR}");
        SET("TEL = #{record.tel,jdbcType=VARCHAR}");
        SET("PHONE = #{record.phone,jdbcType=VARCHAR}");
        SET("QQ_NUM = #{record.qqNum,jdbcType=VARCHAR}");
        SET("EMAIL = #{record.email,jdbcType=VARCHAR}");
        SET("SEX = #{record.sex,jdbcType=INTEGER}");
        SET("PARTY = #{record.party,jdbcType=VARCHAR}");
        SET("BIRTHDAY = #{record.birthday,jdbcType=TIMESTAMP}");
        SET("RACE = #{record.race,jdbcType=VARCHAR}");
        SET("EDUCATION = #{record.education,jdbcType=VARCHAR}");
        SET("SPECIALITY = #{record.speciality,jdbcType=VARCHAR}");
        SET("HOBBY = #{record.hobby,jdbcType=VARCHAR}");
        SET("REMARK = #{record.remark,jdbcType=VARCHAR}");
        SET("CREATE_DATE = #{record.createDate,jdbcType=TIMESTAMP}");
        
        EmployeeExample example = (EmployeeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Employee record) {
        BEGIN();
        UPDATE("employee_inf");
        
        if (record.getDeptId() != null) {
            SET("DEPT_ID = #{deptId,jdbcType=INTEGER}");
        }
        
        if (record.getJobId() != null) {
            SET("JOB_ID = #{jobId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("NAME = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCardId() != null) {
            SET("CARD_ID = #{cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("ADDRESS = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getPostCode() != null) {
            SET("POST_CODE = #{postCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            SET("TEL = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("PHONE = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getQqNum() != null) {
            SET("QQ_NUM = #{qqNum,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("EMAIL = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("SEX = #{sex,jdbcType=INTEGER}");
        }
        
        if (record.getParty() != null) {
            SET("PARTY = #{party,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("BIRTHDAY = #{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRace() != null) {
            SET("RACE = #{race,jdbcType=VARCHAR}");
        }
        
        if (record.getEducation() != null) {
            SET("EDUCATION = #{education,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeciality() != null) {
            SET("SPECIALITY = #{speciality,jdbcType=VARCHAR}");
        }
        
        if (record.getHobby() != null) {
            SET("HOBBY = #{hobby,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("REMARK = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("CREATE_DATE = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ID = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(EmployeeExample example, boolean includeExamplePhrase) {
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