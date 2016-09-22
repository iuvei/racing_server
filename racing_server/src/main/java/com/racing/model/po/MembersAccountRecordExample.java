package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembersAccountRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MembersAccountRecordExample() {
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

        public Criteria andMembersIdIsNull() {
            addCriterion("members_id is null");
            return (Criteria) this;
        }

        public Criteria andMembersIdIsNotNull() {
            addCriterion("members_id is not null");
            return (Criteria) this;
        }

        public Criteria andMembersIdEqualTo(Integer value) {
            addCriterion("members_id =", value, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdNotEqualTo(Integer value) {
            addCriterion("members_id <>", value, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdGreaterThan(Integer value) {
            addCriterion("members_id >", value, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("members_id >=", value, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdLessThan(Integer value) {
            addCriterion("members_id <", value, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdLessThanOrEqualTo(Integer value) {
            addCriterion("members_id <=", value, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdIn(List<Integer> values) {
            addCriterion("members_id in", values, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdNotIn(List<Integer> values) {
            addCriterion("members_id not in", values, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdBetween(Integer value1, Integer value2) {
            addCriterion("members_id between", value1, value2, "membersId");
            return (Criteria) this;
        }

        public Criteria andMembersIdNotBetween(Integer value1, Integer value2) {
            addCriterion("members_id not between", value1, value2, "membersId");
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

        public Criteria andOperationPointsIsNull() {
            addCriterion("operation_points is null");
            return (Criteria) this;
        }

        public Criteria andOperationPointsIsNotNull() {
            addCriterion("operation_points is not null");
            return (Criteria) this;
        }

        public Criteria andOperationPointsEqualTo(BigDecimal value) {
            addCriterion("operation_points =", value, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsNotEqualTo(BigDecimal value) {
            addCriterion("operation_points <>", value, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsGreaterThan(BigDecimal value) {
            addCriterion("operation_points >", value, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operation_points >=", value, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsLessThan(BigDecimal value) {
            addCriterion("operation_points <", value, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operation_points <=", value, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsIn(List<BigDecimal> values) {
            addCriterion("operation_points in", values, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsNotIn(List<BigDecimal> values) {
            addCriterion("operation_points not in", values, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operation_points between", value1, value2, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andOperationPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operation_points not between", value1, value2, "operationPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsIsNull() {
            addCriterion("result_points is null");
            return (Criteria) this;
        }

        public Criteria andResultPointsIsNotNull() {
            addCriterion("result_points is not null");
            return (Criteria) this;
        }

        public Criteria andResultPointsEqualTo(BigDecimal value) {
            addCriterion("result_points =", value, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsNotEqualTo(BigDecimal value) {
            addCriterion("result_points <>", value, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsGreaterThan(BigDecimal value) {
            addCriterion("result_points >", value, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("result_points >=", value, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsLessThan(BigDecimal value) {
            addCriterion("result_points <", value, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("result_points <=", value, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsIn(List<BigDecimal> values) {
            addCriterion("result_points in", values, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsNotIn(List<BigDecimal> values) {
            addCriterion("result_points not in", values, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("result_points between", value1, value2, "resultPoints");
            return (Criteria) this;
        }

        public Criteria andResultPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("result_points not between", value1, value2, "resultPoints");
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