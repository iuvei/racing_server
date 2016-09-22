package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserRankingStakeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserRankingStakeExample() {
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

        public Criteria andRacingNumIsNull() {
            addCriterion("racing_num is null");
            return (Criteria) this;
        }

        public Criteria andRacingNumIsNotNull() {
            addCriterion("racing_num is not null");
            return (Criteria) this;
        }

        public Criteria andRacingNumEqualTo(String value) {
            addCriterion("racing_num =", value, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumNotEqualTo(String value) {
            addCriterion("racing_num <>", value, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumGreaterThan(String value) {
            addCriterion("racing_num >", value, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumGreaterThanOrEqualTo(String value) {
            addCriterion("racing_num >=", value, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumLessThan(String value) {
            addCriterion("racing_num <", value, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumLessThanOrEqualTo(String value) {
            addCriterion("racing_num <=", value, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumLike(String value) {
            addCriterion("racing_num like", value, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumNotLike(String value) {
            addCriterion("racing_num not like", value, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumIn(List<String> values) {
            addCriterion("racing_num in", values, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumNotIn(List<String> values) {
            addCriterion("racing_num not in", values, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumBetween(String value1, String value2) {
            addCriterion("racing_num between", value1, value2, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRacingNumNotBetween(String value1, String value2) {
            addCriterion("racing_num not between", value1, value2, "racingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumIsNull() {
            addCriterion("ranking_num is null");
            return (Criteria) this;
        }

        public Criteria andRankingNumIsNotNull() {
            addCriterion("ranking_num is not null");
            return (Criteria) this;
        }

        public Criteria andRankingNumEqualTo(Integer value) {
            addCriterion("ranking_num =", value, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumNotEqualTo(Integer value) {
            addCriterion("ranking_num <>", value, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumGreaterThan(Integer value) {
            addCriterion("ranking_num >", value, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ranking_num >=", value, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumLessThan(Integer value) {
            addCriterion("ranking_num <", value, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumLessThanOrEqualTo(Integer value) {
            addCriterion("ranking_num <=", value, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumIn(List<Integer> values) {
            addCriterion("ranking_num in", values, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumNotIn(List<Integer> values) {
            addCriterion("ranking_num not in", values, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumBetween(Integer value1, Integer value2) {
            addCriterion("ranking_num between", value1, value2, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andRankingNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ranking_num not between", value1, value2, "rankingNum");
            return (Criteria) this;
        }

        public Criteria andBigIsNull() {
            addCriterion("big is null");
            return (Criteria) this;
        }

        public Criteria andBigIsNotNull() {
            addCriterion("big is not null");
            return (Criteria) this;
        }

        public Criteria andBigEqualTo(BigDecimal value) {
            addCriterion("big =", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotEqualTo(BigDecimal value) {
            addCriterion("big <>", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigGreaterThan(BigDecimal value) {
            addCriterion("big >", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("big >=", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLessThan(BigDecimal value) {
            addCriterion("big <", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLessThanOrEqualTo(BigDecimal value) {
            addCriterion("big <=", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigIn(List<BigDecimal> values) {
            addCriterion("big in", values, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotIn(List<BigDecimal> values) {
            addCriterion("big not in", values, "big");
            return (Criteria) this;
        }

        public Criteria andBigBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("big between", value1, value2, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("big not between", value1, value2, "big");
            return (Criteria) this;
        }

        public Criteria andSmallIsNull() {
            addCriterion("small is null");
            return (Criteria) this;
        }

        public Criteria andSmallIsNotNull() {
            addCriterion("small is not null");
            return (Criteria) this;
        }

        public Criteria andSmallEqualTo(BigDecimal value) {
            addCriterion("small =", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotEqualTo(BigDecimal value) {
            addCriterion("small <>", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallGreaterThan(BigDecimal value) {
            addCriterion("small >", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("small >=", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallLessThan(BigDecimal value) {
            addCriterion("small <", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallLessThanOrEqualTo(BigDecimal value) {
            addCriterion("small <=", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallIn(List<BigDecimal> values) {
            addCriterion("small in", values, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotIn(List<BigDecimal> values) {
            addCriterion("small not in", values, "small");
            return (Criteria) this;
        }

        public Criteria andSmallBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("small between", value1, value2, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("small not between", value1, value2, "small");
            return (Criteria) this;
        }

        public Criteria andOddIsNull() {
            addCriterion("odd is null");
            return (Criteria) this;
        }

        public Criteria andOddIsNotNull() {
            addCriterion("odd is not null");
            return (Criteria) this;
        }

        public Criteria andOddEqualTo(BigDecimal value) {
            addCriterion("odd =", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddNotEqualTo(BigDecimal value) {
            addCriterion("odd <>", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddGreaterThan(BigDecimal value) {
            addCriterion("odd >", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("odd >=", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddLessThan(BigDecimal value) {
            addCriterion("odd <", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddLessThanOrEqualTo(BigDecimal value) {
            addCriterion("odd <=", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddIn(List<BigDecimal> values) {
            addCriterion("odd in", values, "odd");
            return (Criteria) this;
        }

        public Criteria andOddNotIn(List<BigDecimal> values) {
            addCriterion("odd not in", values, "odd");
            return (Criteria) this;
        }

        public Criteria andOddBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("odd between", value1, value2, "odd");
            return (Criteria) this;
        }

        public Criteria andOddNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("odd not between", value1, value2, "odd");
            return (Criteria) this;
        }

        public Criteria andEvenIsNull() {
            addCriterion("even is null");
            return (Criteria) this;
        }

        public Criteria andEvenIsNotNull() {
            addCriterion("even is not null");
            return (Criteria) this;
        }

        public Criteria andEvenEqualTo(BigDecimal value) {
            addCriterion("even =", value, "even");
            return (Criteria) this;
        }

        public Criteria andEvenNotEqualTo(BigDecimal value) {
            addCriterion("even <>", value, "even");
            return (Criteria) this;
        }

        public Criteria andEvenGreaterThan(BigDecimal value) {
            addCriterion("even >", value, "even");
            return (Criteria) this;
        }

        public Criteria andEvenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("even >=", value, "even");
            return (Criteria) this;
        }

        public Criteria andEvenLessThan(BigDecimal value) {
            addCriterion("even <", value, "even");
            return (Criteria) this;
        }

        public Criteria andEvenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("even <=", value, "even");
            return (Criteria) this;
        }

        public Criteria andEvenIn(List<BigDecimal> values) {
            addCriterion("even in", values, "even");
            return (Criteria) this;
        }

        public Criteria andEvenNotIn(List<BigDecimal> values) {
            addCriterion("even not in", values, "even");
            return (Criteria) this;
        }

        public Criteria andEvenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("even between", value1, value2, "even");
            return (Criteria) this;
        }

        public Criteria andEvenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("even not between", value1, value2, "even");
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