package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DayCountStakeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DayCountStakeExample() {
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

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(String value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(String value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(String value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(String value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(String value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(String value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLike(String value) {
            addCriterion("day like", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotLike(String value) {
            addCriterion("day not like", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<String> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<String> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(String value1, String value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(String value1, String value2) {
            addCriterion("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountIsNull() {
            addCriterion("total_stake_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountIsNotNull() {
            addCriterion("total_stake_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountEqualTo(BigDecimal value) {
            addCriterion("total_stake_amount =", value, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_stake_amount <>", value, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountGreaterThan(BigDecimal value) {
            addCriterion("total_stake_amount >", value, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_stake_amount >=", value, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountLessThan(BigDecimal value) {
            addCriterion("total_stake_amount <", value, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_stake_amount <=", value, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountIn(List<BigDecimal> values) {
            addCriterion("total_stake_amount in", values, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_stake_amount not in", values, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_stake_amount between", value1, value2, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_stake_amount not between", value1, value2, "totalStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountIsNull() {
            addCriterion("total_deficit_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountIsNotNull() {
            addCriterion("total_deficit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountEqualTo(BigDecimal value) {
            addCriterion("total_deficit_amount =", value, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_deficit_amount <>", value, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountGreaterThan(BigDecimal value) {
            addCriterion("total_deficit_amount >", value, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_deficit_amount >=", value, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountLessThan(BigDecimal value) {
            addCriterion("total_deficit_amount <", value, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_deficit_amount <=", value, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountIn(List<BigDecimal> values) {
            addCriterion("total_deficit_amount in", values, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_deficit_amount not in", values, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_deficit_amount between", value1, value2, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalDeficitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_deficit_amount not between", value1, value2, "totalDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountIsNull() {
            addCriterion("total_stake_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountIsNotNull() {
            addCriterion("total_stake_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountEqualTo(Integer value) {
            addCriterion("total_stake_count =", value, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountNotEqualTo(Integer value) {
            addCriterion("total_stake_count <>", value, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountGreaterThan(Integer value) {
            addCriterion("total_stake_count >", value, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_stake_count >=", value, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountLessThan(Integer value) {
            addCriterion("total_stake_count <", value, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_stake_count <=", value, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountIn(List<Integer> values) {
            addCriterion("total_stake_count in", values, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountNotIn(List<Integer> values) {
            addCriterion("total_stake_count not in", values, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountBetween(Integer value1, Integer value2) {
            addCriterion("total_stake_count between", value1, value2, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andTotalStakeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_stake_count not between", value1, value2, "totalStakeCount");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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