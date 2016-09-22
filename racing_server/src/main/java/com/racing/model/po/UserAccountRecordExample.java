package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAccountRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAccountRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsIsNull() {
            addCriterion("operation_total_points is null");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsIsNotNull() {
            addCriterion("operation_total_points is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsEqualTo(BigDecimal value) {
            addCriterion("operation_total_points =", value, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsNotEqualTo(BigDecimal value) {
            addCriterion("operation_total_points <>", value, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsGreaterThan(BigDecimal value) {
            addCriterion("operation_total_points >", value, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operation_total_points >=", value, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsLessThan(BigDecimal value) {
            addCriterion("operation_total_points <", value, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operation_total_points <=", value, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsIn(List<BigDecimal> values) {
            addCriterion("operation_total_points in", values, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsNotIn(List<BigDecimal> values) {
            addCriterion("operation_total_points not in", values, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operation_total_points between", value1, value2, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTotalPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operation_total_points not between", value1, value2, "operationTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsIsNull() {
            addCriterion("result_total_points is null");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsIsNotNull() {
            addCriterion("result_total_points is not null");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsEqualTo(BigDecimal value) {
            addCriterion("result_total_points =", value, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsNotEqualTo(BigDecimal value) {
            addCriterion("result_total_points <>", value, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsGreaterThan(BigDecimal value) {
            addCriterion("result_total_points >", value, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("result_total_points >=", value, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsLessThan(BigDecimal value) {
            addCriterion("result_total_points <", value, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("result_total_points <=", value, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsIn(List<BigDecimal> values) {
            addCriterion("result_total_points in", values, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsNotIn(List<BigDecimal> values) {
            addCriterion("result_total_points not in", values, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("result_total_points between", value1, value2, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andResultTotalPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("result_total_points not between", value1, value2, "resultTotalPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsIsNull() {
            addCriterion("operation_user_points is null");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsIsNotNull() {
            addCriterion("operation_user_points is not null");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsEqualTo(BigDecimal value) {
            addCriterion("operation_user_points =", value, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsNotEqualTo(BigDecimal value) {
            addCriterion("operation_user_points <>", value, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsGreaterThan(BigDecimal value) {
            addCriterion("operation_user_points >", value, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operation_user_points >=", value, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsLessThan(BigDecimal value) {
            addCriterion("operation_user_points <", value, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operation_user_points <=", value, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsIn(List<BigDecimal> values) {
            addCriterion("operation_user_points in", values, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsNotIn(List<BigDecimal> values) {
            addCriterion("operation_user_points not in", values, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operation_user_points between", value1, value2, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationUserPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operation_user_points not between", value1, value2, "operationUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsIsNull() {
            addCriterion("result_user_points is null");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsIsNotNull() {
            addCriterion("result_user_points is not null");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsEqualTo(BigDecimal value) {
            addCriterion("result_user_points =", value, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsNotEqualTo(BigDecimal value) {
            addCriterion("result_user_points <>", value, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsGreaterThan(BigDecimal value) {
            addCriterion("result_user_points >", value, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("result_user_points >=", value, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsLessThan(BigDecimal value) {
            addCriterion("result_user_points <", value, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("result_user_points <=", value, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsIn(List<BigDecimal> values) {
            addCriterion("result_user_points in", values, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsNotIn(List<BigDecimal> values) {
            addCriterion("result_user_points not in", values, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("result_user_points between", value1, value2, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andResultUserPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("result_user_points not between", value1, value2, "resultUserPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsIsNull() {
            addCriterion("operation_members_points is null");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsIsNotNull() {
            addCriterion("operation_members_points is not null");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsEqualTo(BigDecimal value) {
            addCriterion("operation_members_points =", value, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsNotEqualTo(BigDecimal value) {
            addCriterion("operation_members_points <>", value, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsGreaterThan(BigDecimal value) {
            addCriterion("operation_members_points >", value, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operation_members_points >=", value, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsLessThan(BigDecimal value) {
            addCriterion("operation_members_points <", value, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operation_members_points <=", value, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsIn(List<BigDecimal> values) {
            addCriterion("operation_members_points in", values, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsNotIn(List<BigDecimal> values) {
            addCriterion("operation_members_points not in", values, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operation_members_points between", value1, value2, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationMembersPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operation_members_points not between", value1, value2, "operationMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsIsNull() {
            addCriterion("result_members_points is null");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsIsNotNull() {
            addCriterion("result_members_points is not null");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsEqualTo(BigDecimal value) {
            addCriterion("result_members_points =", value, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsNotEqualTo(BigDecimal value) {
            addCriterion("result_members_points <>", value, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsGreaterThan(BigDecimal value) {
            addCriterion("result_members_points >", value, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("result_members_points >=", value, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsLessThan(BigDecimal value) {
            addCriterion("result_members_points <", value, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("result_members_points <=", value, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsIn(List<BigDecimal> values) {
            addCriterion("result_members_points in", values, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsNotIn(List<BigDecimal> values) {
            addCriterion("result_members_points not in", values, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("result_members_points between", value1, value2, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andResultMembersPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("result_members_points not between", value1, value2, "resultMembersPoints");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            addCriterion("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            addCriterion("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            addCriterion("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            addCriterion("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            addCriterion("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            addCriterion("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            addCriterion("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("operation_time not between", value1, value2, "operationTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}