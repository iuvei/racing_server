package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TotalDayCountIncomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TotalDayCountIncomeExample() {
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

        public Criteria andStakeAmountIsNull() {
            addCriterion("stake_amount is null");
            return (Criteria) this;
        }

        public Criteria andStakeAmountIsNotNull() {
            addCriterion("stake_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStakeAmountEqualTo(BigDecimal value) {
            addCriterion("stake_amount =", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountNotEqualTo(BigDecimal value) {
            addCriterion("stake_amount <>", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountGreaterThan(BigDecimal value) {
            addCriterion("stake_amount >", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stake_amount >=", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountLessThan(BigDecimal value) {
            addCriterion("stake_amount <", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stake_amount <=", value, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountIn(List<BigDecimal> values) {
            addCriterion("stake_amount in", values, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountNotIn(List<BigDecimal> values) {
            addCriterion("stake_amount not in", values, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stake_amount between", value1, value2, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andStakeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stake_amount not between", value1, value2, "stakeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIsNull() {
            addCriterion("income_amount is null");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIsNotNull() {
            addCriterion("income_amount is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountEqualTo(BigDecimal value) {
            addCriterion("income_amount =", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotEqualTo(BigDecimal value) {
            addCriterion("income_amount <>", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountGreaterThan(BigDecimal value) {
            addCriterion("income_amount >", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_amount >=", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountLessThan(BigDecimal value) {
            addCriterion("income_amount <", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_amount <=", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIn(List<BigDecimal> values) {
            addCriterion("income_amount in", values, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotIn(List<BigDecimal> values) {
            addCriterion("income_amount not in", values, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_amount between", value1, value2, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_amount not between", value1, value2, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountIsNull() {
            addCriterion("deficit_amount is null");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountIsNotNull() {
            addCriterion("deficit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountEqualTo(BigDecimal value) {
            addCriterion("deficit_amount =", value, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountNotEqualTo(BigDecimal value) {
            addCriterion("deficit_amount <>", value, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountGreaterThan(BigDecimal value) {
            addCriterion("deficit_amount >", value, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deficit_amount >=", value, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountLessThan(BigDecimal value) {
            addCriterion("deficit_amount <", value, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deficit_amount <=", value, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountIn(List<BigDecimal> values) {
            addCriterion("deficit_amount in", values, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountNotIn(List<BigDecimal> values) {
            addCriterion("deficit_amount not in", values, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deficit_amount between", value1, value2, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andDeficitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deficit_amount not between", value1, value2, "deficitAmount");
            return (Criteria) this;
        }

        public Criteria andStakeCountIsNull() {
            addCriterion("stake_count is null");
            return (Criteria) this;
        }

        public Criteria andStakeCountIsNotNull() {
            addCriterion("stake_count is not null");
            return (Criteria) this;
        }

        public Criteria andStakeCountEqualTo(Integer value) {
            addCriterion("stake_count =", value, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountNotEqualTo(Integer value) {
            addCriterion("stake_count <>", value, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountGreaterThan(Integer value) {
            addCriterion("stake_count >", value, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stake_count >=", value, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountLessThan(Integer value) {
            addCriterion("stake_count <", value, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountLessThanOrEqualTo(Integer value) {
            addCriterion("stake_count <=", value, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountIn(List<Integer> values) {
            addCriterion("stake_count in", values, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountNotIn(List<Integer> values) {
            addCriterion("stake_count not in", values, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountBetween(Integer value1, Integer value2) {
            addCriterion("stake_count between", value1, value2, "stakeCount");
            return (Criteria) this;
        }

        public Criteria andStakeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("stake_count not between", value1, value2, "stakeCount");
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