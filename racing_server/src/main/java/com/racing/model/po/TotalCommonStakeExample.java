package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TotalCommonStakeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TotalCommonStakeExample() {
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

        public Criteria andFirstUpIsNull() {
            addCriterion("first_up is null");
            return (Criteria) this;
        }

        public Criteria andFirstUpIsNotNull() {
            addCriterion("first_up is not null");
            return (Criteria) this;
        }

        public Criteria andFirstUpEqualTo(BigDecimal value) {
            addCriterion("first_up =", value, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpNotEqualTo(BigDecimal value) {
            addCriterion("first_up <>", value, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpGreaterThan(BigDecimal value) {
            addCriterion("first_up >", value, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_up >=", value, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpLessThan(BigDecimal value) {
            addCriterion("first_up <", value, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_up <=", value, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpIn(List<BigDecimal> values) {
            addCriterion("first_up in", values, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpNotIn(List<BigDecimal> values) {
            addCriterion("first_up not in", values, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_up between", value1, value2, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_up not between", value1, value2, "firstUp");
            return (Criteria) this;
        }

        public Criteria andFirstDowmIsNull() {
            addCriterion("first_dowm is null");
            return (Criteria) this;
        }

        public Criteria andFirstDowmIsNotNull() {
            addCriterion("first_dowm is not null");
            return (Criteria) this;
        }

        public Criteria andFirstDowmEqualTo(BigDecimal value) {
            addCriterion("first_dowm =", value, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmNotEqualTo(BigDecimal value) {
            addCriterion("first_dowm <>", value, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmGreaterThan(BigDecimal value) {
            addCriterion("first_dowm >", value, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_dowm >=", value, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmLessThan(BigDecimal value) {
            addCriterion("first_dowm <", value, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_dowm <=", value, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmIn(List<BigDecimal> values) {
            addCriterion("first_dowm in", values, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmNotIn(List<BigDecimal> values) {
            addCriterion("first_dowm not in", values, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_dowm between", value1, value2, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andFirstDowmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_dowm not between", value1, value2, "firstDowm");
            return (Criteria) this;
        }

        public Criteria andSecondUpIsNull() {
            addCriterion("second_up is null");
            return (Criteria) this;
        }

        public Criteria andSecondUpIsNotNull() {
            addCriterion("second_up is not null");
            return (Criteria) this;
        }

        public Criteria andSecondUpEqualTo(BigDecimal value) {
            addCriterion("second_up =", value, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpNotEqualTo(BigDecimal value) {
            addCriterion("second_up <>", value, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpGreaterThan(BigDecimal value) {
            addCriterion("second_up >", value, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("second_up >=", value, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpLessThan(BigDecimal value) {
            addCriterion("second_up <", value, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("second_up <=", value, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpIn(List<BigDecimal> values) {
            addCriterion("second_up in", values, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpNotIn(List<BigDecimal> values) {
            addCriterion("second_up not in", values, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_up between", value1, value2, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_up not between", value1, value2, "secondUp");
            return (Criteria) this;
        }

        public Criteria andSecondDowmIsNull() {
            addCriterion("second_dowm is null");
            return (Criteria) this;
        }

        public Criteria andSecondDowmIsNotNull() {
            addCriterion("second_dowm is not null");
            return (Criteria) this;
        }

        public Criteria andSecondDowmEqualTo(BigDecimal value) {
            addCriterion("second_dowm =", value, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmNotEqualTo(BigDecimal value) {
            addCriterion("second_dowm <>", value, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmGreaterThan(BigDecimal value) {
            addCriterion("second_dowm >", value, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("second_dowm >=", value, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmLessThan(BigDecimal value) {
            addCriterion("second_dowm <", value, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("second_dowm <=", value, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmIn(List<BigDecimal> values) {
            addCriterion("second_dowm in", values, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmNotIn(List<BigDecimal> values) {
            addCriterion("second_dowm not in", values, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_dowm between", value1, value2, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andSecondDowmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_dowm not between", value1, value2, "secondDowm");
            return (Criteria) this;
        }

        public Criteria andThirdUpIsNull() {
            addCriterion("third_up is null");
            return (Criteria) this;
        }

        public Criteria andThirdUpIsNotNull() {
            addCriterion("third_up is not null");
            return (Criteria) this;
        }

        public Criteria andThirdUpEqualTo(BigDecimal value) {
            addCriterion("third_up =", value, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpNotEqualTo(BigDecimal value) {
            addCriterion("third_up <>", value, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpGreaterThan(BigDecimal value) {
            addCriterion("third_up >", value, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("third_up >=", value, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpLessThan(BigDecimal value) {
            addCriterion("third_up <", value, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("third_up <=", value, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpIn(List<BigDecimal> values) {
            addCriterion("third_up in", values, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpNotIn(List<BigDecimal> values) {
            addCriterion("third_up not in", values, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("third_up between", value1, value2, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("third_up not between", value1, value2, "thirdUp");
            return (Criteria) this;
        }

        public Criteria andThirdDowmIsNull() {
            addCriterion("third_dowm is null");
            return (Criteria) this;
        }

        public Criteria andThirdDowmIsNotNull() {
            addCriterion("third_dowm is not null");
            return (Criteria) this;
        }

        public Criteria andThirdDowmEqualTo(BigDecimal value) {
            addCriterion("third_dowm =", value, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmNotEqualTo(BigDecimal value) {
            addCriterion("third_dowm <>", value, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmGreaterThan(BigDecimal value) {
            addCriterion("third_dowm >", value, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("third_dowm >=", value, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmLessThan(BigDecimal value) {
            addCriterion("third_dowm <", value, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("third_dowm <=", value, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmIn(List<BigDecimal> values) {
            addCriterion("third_dowm in", values, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmNotIn(List<BigDecimal> values) {
            addCriterion("third_dowm not in", values, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("third_dowm between", value1, value2, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andThirdDowmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("third_dowm not between", value1, value2, "thirdDowm");
            return (Criteria) this;
        }

        public Criteria andFourthUpIsNull() {
            addCriterion("fourth_up is null");
            return (Criteria) this;
        }

        public Criteria andFourthUpIsNotNull() {
            addCriterion("fourth_up is not null");
            return (Criteria) this;
        }

        public Criteria andFourthUpEqualTo(BigDecimal value) {
            addCriterion("fourth_up =", value, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpNotEqualTo(BigDecimal value) {
            addCriterion("fourth_up <>", value, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpGreaterThan(BigDecimal value) {
            addCriterion("fourth_up >", value, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fourth_up >=", value, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpLessThan(BigDecimal value) {
            addCriterion("fourth_up <", value, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fourth_up <=", value, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpIn(List<BigDecimal> values) {
            addCriterion("fourth_up in", values, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpNotIn(List<BigDecimal> values) {
            addCriterion("fourth_up not in", values, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fourth_up between", value1, value2, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fourth_up not between", value1, value2, "fourthUp");
            return (Criteria) this;
        }

        public Criteria andFourthDowmIsNull() {
            addCriterion("fourth_dowm is null");
            return (Criteria) this;
        }

        public Criteria andFourthDowmIsNotNull() {
            addCriterion("fourth_dowm is not null");
            return (Criteria) this;
        }

        public Criteria andFourthDowmEqualTo(BigDecimal value) {
            addCriterion("fourth_dowm =", value, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmNotEqualTo(BigDecimal value) {
            addCriterion("fourth_dowm <>", value, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmGreaterThan(BigDecimal value) {
            addCriterion("fourth_dowm >", value, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fourth_dowm >=", value, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmLessThan(BigDecimal value) {
            addCriterion("fourth_dowm <", value, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fourth_dowm <=", value, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmIn(List<BigDecimal> values) {
            addCriterion("fourth_dowm in", values, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmNotIn(List<BigDecimal> values) {
            addCriterion("fourth_dowm not in", values, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fourth_dowm between", value1, value2, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFourthDowmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fourth_dowm not between", value1, value2, "fourthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthUpIsNull() {
            addCriterion("fifth_up is null");
            return (Criteria) this;
        }

        public Criteria andFifthUpIsNotNull() {
            addCriterion("fifth_up is not null");
            return (Criteria) this;
        }

        public Criteria andFifthUpEqualTo(BigDecimal value) {
            addCriterion("fifth_up =", value, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpNotEqualTo(BigDecimal value) {
            addCriterion("fifth_up <>", value, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpGreaterThan(BigDecimal value) {
            addCriterion("fifth_up >", value, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fifth_up >=", value, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpLessThan(BigDecimal value) {
            addCriterion("fifth_up <", value, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fifth_up <=", value, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpIn(List<BigDecimal> values) {
            addCriterion("fifth_up in", values, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpNotIn(List<BigDecimal> values) {
            addCriterion("fifth_up not in", values, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fifth_up between", value1, value2, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthUpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fifth_up not between", value1, value2, "fifthUp");
            return (Criteria) this;
        }

        public Criteria andFifthDowmIsNull() {
            addCriterion("fifth_dowm is null");
            return (Criteria) this;
        }

        public Criteria andFifthDowmIsNotNull() {
            addCriterion("fifth_dowm is not null");
            return (Criteria) this;
        }

        public Criteria andFifthDowmEqualTo(BigDecimal value) {
            addCriterion("fifth_dowm =", value, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmNotEqualTo(BigDecimal value) {
            addCriterion("fifth_dowm <>", value, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmGreaterThan(BigDecimal value) {
            addCriterion("fifth_dowm >", value, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fifth_dowm >=", value, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmLessThan(BigDecimal value) {
            addCriterion("fifth_dowm <", value, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fifth_dowm <=", value, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmIn(List<BigDecimal> values) {
            addCriterion("fifth_dowm in", values, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmNotIn(List<BigDecimal> values) {
            addCriterion("fifth_dowm not in", values, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fifth_dowm between", value1, value2, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFifthDowmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fifth_dowm not between", value1, value2, "fifthDowm");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddIsNull() {
            addCriterion("first_second_odd is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddIsNotNull() {
            addCriterion("first_second_odd is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddEqualTo(BigDecimal value) {
            addCriterion("first_second_odd =", value, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddNotEqualTo(BigDecimal value) {
            addCriterion("first_second_odd <>", value, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddGreaterThan(BigDecimal value) {
            addCriterion("first_second_odd >", value, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_odd >=", value, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddLessThan(BigDecimal value) {
            addCriterion("first_second_odd <", value, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_odd <=", value, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddIn(List<BigDecimal> values) {
            addCriterion("first_second_odd in", values, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddNotIn(List<BigDecimal> values) {
            addCriterion("first_second_odd not in", values, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_odd between", value1, value2, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondOddNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_odd not between", value1, value2, "firstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenIsNull() {
            addCriterion("first_second_even is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenIsNotNull() {
            addCriterion("first_second_even is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenEqualTo(BigDecimal value) {
            addCriterion("first_second_even =", value, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenNotEqualTo(BigDecimal value) {
            addCriterion("first_second_even <>", value, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenGreaterThan(BigDecimal value) {
            addCriterion("first_second_even >", value, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_even >=", value, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenLessThan(BigDecimal value) {
            addCriterion("first_second_even <", value, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_even <=", value, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenIn(List<BigDecimal> values) {
            addCriterion("first_second_even in", values, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenNotIn(List<BigDecimal> values) {
            addCriterion("first_second_even not in", values, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_even between", value1, value2, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondEvenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_even not between", value1, value2, "firstSecondEven");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigIsNull() {
            addCriterion("first_second_big is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigIsNotNull() {
            addCriterion("first_second_big is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigEqualTo(BigDecimal value) {
            addCriterion("first_second_big =", value, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigNotEqualTo(BigDecimal value) {
            addCriterion("first_second_big <>", value, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigGreaterThan(BigDecimal value) {
            addCriterion("first_second_big >", value, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_big >=", value, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigLessThan(BigDecimal value) {
            addCriterion("first_second_big <", value, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_big <=", value, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigIn(List<BigDecimal> values) {
            addCriterion("first_second_big in", values, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigNotIn(List<BigDecimal> values) {
            addCriterion("first_second_big not in", values, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_big between", value1, value2, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondBigNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_big not between", value1, value2, "firstSecondBig");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallIsNull() {
            addCriterion("first_second_small is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallIsNotNull() {
            addCriterion("first_second_small is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallEqualTo(BigDecimal value) {
            addCriterion("first_second_small =", value, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallNotEqualTo(BigDecimal value) {
            addCriterion("first_second_small <>", value, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallGreaterThan(BigDecimal value) {
            addCriterion("first_second_small >", value, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_small >=", value, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallLessThan(BigDecimal value) {
            addCriterion("first_second_small <", value, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_small <=", value, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallIn(List<BigDecimal> values) {
            addCriterion("first_second_small in", values, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallNotIn(List<BigDecimal> values) {
            addCriterion("first_second_small not in", values, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_small between", value1, value2, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecondSmallNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_small not between", value1, value2, "firstSecondSmall");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3IsNull() {
            addCriterion("first_second_3 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3IsNotNull() {
            addCriterion("first_second_3 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3EqualTo(BigDecimal value) {
            addCriterion("first_second_3 =", value, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3NotEqualTo(BigDecimal value) {
            addCriterion("first_second_3 <>", value, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3GreaterThan(BigDecimal value) {
            addCriterion("first_second_3 >", value, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_3 >=", value, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3LessThan(BigDecimal value) {
            addCriterion("first_second_3 <", value, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_3 <=", value, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3In(List<BigDecimal> values) {
            addCriterion("first_second_3 in", values, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3NotIn(List<BigDecimal> values) {
            addCriterion("first_second_3 not in", values, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_3 between", value1, value2, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_3 not between", value1, value2, "firstSecond3");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4IsNull() {
            addCriterion("first_second_4 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4IsNotNull() {
            addCriterion("first_second_4 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4EqualTo(BigDecimal value) {
            addCriterion("first_second_4 =", value, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4NotEqualTo(BigDecimal value) {
            addCriterion("first_second_4 <>", value, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4GreaterThan(BigDecimal value) {
            addCriterion("first_second_4 >", value, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_4 >=", value, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4LessThan(BigDecimal value) {
            addCriterion("first_second_4 <", value, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_4 <=", value, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4In(List<BigDecimal> values) {
            addCriterion("first_second_4 in", values, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4NotIn(List<BigDecimal> values) {
            addCriterion("first_second_4 not in", values, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_4 between", value1, value2, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_4 not between", value1, value2, "firstSecond4");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5IsNull() {
            addCriterion("first_second_5 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5IsNotNull() {
            addCriterion("first_second_5 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5EqualTo(BigDecimal value) {
            addCriterion("first_second_5 =", value, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5NotEqualTo(BigDecimal value) {
            addCriterion("first_second_5 <>", value, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5GreaterThan(BigDecimal value) {
            addCriterion("first_second_5 >", value, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_5 >=", value, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5LessThan(BigDecimal value) {
            addCriterion("first_second_5 <", value, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_5 <=", value, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5In(List<BigDecimal> values) {
            addCriterion("first_second_5 in", values, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5NotIn(List<BigDecimal> values) {
            addCriterion("first_second_5 not in", values, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_5 between", value1, value2, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_5 not between", value1, value2, "firstSecond5");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6IsNull() {
            addCriterion("first_second_6 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6IsNotNull() {
            addCriterion("first_second_6 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6EqualTo(BigDecimal value) {
            addCriterion("first_second_6 =", value, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6NotEqualTo(BigDecimal value) {
            addCriterion("first_second_6 <>", value, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6GreaterThan(BigDecimal value) {
            addCriterion("first_second_6 >", value, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_6 >=", value, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6LessThan(BigDecimal value) {
            addCriterion("first_second_6 <", value, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_6 <=", value, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6In(List<BigDecimal> values) {
            addCriterion("first_second_6 in", values, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6NotIn(List<BigDecimal> values) {
            addCriterion("first_second_6 not in", values, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_6 between", value1, value2, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond6NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_6 not between", value1, value2, "firstSecond6");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7IsNull() {
            addCriterion("first_second_7 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7IsNotNull() {
            addCriterion("first_second_7 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7EqualTo(BigDecimal value) {
            addCriterion("first_second_7 =", value, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7NotEqualTo(BigDecimal value) {
            addCriterion("first_second_7 <>", value, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7GreaterThan(BigDecimal value) {
            addCriterion("first_second_7 >", value, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_7 >=", value, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7LessThan(BigDecimal value) {
            addCriterion("first_second_7 <", value, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_7 <=", value, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7In(List<BigDecimal> values) {
            addCriterion("first_second_7 in", values, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7NotIn(List<BigDecimal> values) {
            addCriterion("first_second_7 not in", values, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_7 between", value1, value2, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond7NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_7 not between", value1, value2, "firstSecond7");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8IsNull() {
            addCriterion("first_second_8 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8IsNotNull() {
            addCriterion("first_second_8 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8EqualTo(BigDecimal value) {
            addCriterion("first_second_8 =", value, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8NotEqualTo(BigDecimal value) {
            addCriterion("first_second_8 <>", value, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8GreaterThan(BigDecimal value) {
            addCriterion("first_second_8 >", value, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_8 >=", value, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8LessThan(BigDecimal value) {
            addCriterion("first_second_8 <", value, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_8 <=", value, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8In(List<BigDecimal> values) {
            addCriterion("first_second_8 in", values, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8NotIn(List<BigDecimal> values) {
            addCriterion("first_second_8 not in", values, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_8 between", value1, value2, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond8NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_8 not between", value1, value2, "firstSecond8");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9IsNull() {
            addCriterion("first_second_9 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9IsNotNull() {
            addCriterion("first_second_9 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9EqualTo(BigDecimal value) {
            addCriterion("first_second_9 =", value, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9NotEqualTo(BigDecimal value) {
            addCriterion("first_second_9 <>", value, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9GreaterThan(BigDecimal value) {
            addCriterion("first_second_9 >", value, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_9 >=", value, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9LessThan(BigDecimal value) {
            addCriterion("first_second_9 <", value, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_9 <=", value, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9In(List<BigDecimal> values) {
            addCriterion("first_second_9 in", values, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9NotIn(List<BigDecimal> values) {
            addCriterion("first_second_9 not in", values, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_9 between", value1, value2, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond9NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_9 not between", value1, value2, "firstSecond9");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10IsNull() {
            addCriterion("first_second_10 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10IsNotNull() {
            addCriterion("first_second_10 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10EqualTo(BigDecimal value) {
            addCriterion("first_second_10 =", value, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10NotEqualTo(BigDecimal value) {
            addCriterion("first_second_10 <>", value, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10GreaterThan(BigDecimal value) {
            addCriterion("first_second_10 >", value, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_10 >=", value, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10LessThan(BigDecimal value) {
            addCriterion("first_second_10 <", value, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_10 <=", value, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10In(List<BigDecimal> values) {
            addCriterion("first_second_10 in", values, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10NotIn(List<BigDecimal> values) {
            addCriterion("first_second_10 not in", values, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_10 between", value1, value2, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond10NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_10 not between", value1, value2, "firstSecond10");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11IsNull() {
            addCriterion("first_second_11 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11IsNotNull() {
            addCriterion("first_second_11 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11EqualTo(BigDecimal value) {
            addCriterion("first_second_11 =", value, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11NotEqualTo(BigDecimal value) {
            addCriterion("first_second_11 <>", value, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11GreaterThan(BigDecimal value) {
            addCriterion("first_second_11 >", value, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_11 >=", value, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11LessThan(BigDecimal value) {
            addCriterion("first_second_11 <", value, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_11 <=", value, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11In(List<BigDecimal> values) {
            addCriterion("first_second_11 in", values, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11NotIn(List<BigDecimal> values) {
            addCriterion("first_second_11 not in", values, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_11 between", value1, value2, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond11NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_11 not between", value1, value2, "firstSecond11");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12IsNull() {
            addCriterion("first_second_12 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12IsNotNull() {
            addCriterion("first_second_12 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12EqualTo(BigDecimal value) {
            addCriterion("first_second_12 =", value, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12NotEqualTo(BigDecimal value) {
            addCriterion("first_second_12 <>", value, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12GreaterThan(BigDecimal value) {
            addCriterion("first_second_12 >", value, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_12 >=", value, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12LessThan(BigDecimal value) {
            addCriterion("first_second_12 <", value, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_12 <=", value, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12In(List<BigDecimal> values) {
            addCriterion("first_second_12 in", values, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12NotIn(List<BigDecimal> values) {
            addCriterion("first_second_12 not in", values, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_12 between", value1, value2, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond12NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_12 not between", value1, value2, "firstSecond12");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13IsNull() {
            addCriterion("first_second_13 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13IsNotNull() {
            addCriterion("first_second_13 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13EqualTo(BigDecimal value) {
            addCriterion("first_second_13 =", value, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13NotEqualTo(BigDecimal value) {
            addCriterion("first_second_13 <>", value, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13GreaterThan(BigDecimal value) {
            addCriterion("first_second_13 >", value, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_13 >=", value, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13LessThan(BigDecimal value) {
            addCriterion("first_second_13 <", value, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_13 <=", value, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13In(List<BigDecimal> values) {
            addCriterion("first_second_13 in", values, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13NotIn(List<BigDecimal> values) {
            addCriterion("first_second_13 not in", values, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_13 between", value1, value2, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond13NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_13 not between", value1, value2, "firstSecond13");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14IsNull() {
            addCriterion("first_second_14 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14IsNotNull() {
            addCriterion("first_second_14 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14EqualTo(BigDecimal value) {
            addCriterion("first_second_14 =", value, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14NotEqualTo(BigDecimal value) {
            addCriterion("first_second_14 <>", value, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14GreaterThan(BigDecimal value) {
            addCriterion("first_second_14 >", value, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_14 >=", value, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14LessThan(BigDecimal value) {
            addCriterion("first_second_14 <", value, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_14 <=", value, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14In(List<BigDecimal> values) {
            addCriterion("first_second_14 in", values, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14NotIn(List<BigDecimal> values) {
            addCriterion("first_second_14 not in", values, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_14 between", value1, value2, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond14NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_14 not between", value1, value2, "firstSecond14");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15IsNull() {
            addCriterion("first_second_15 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15IsNotNull() {
            addCriterion("first_second_15 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15EqualTo(BigDecimal value) {
            addCriterion("first_second_15 =", value, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15NotEqualTo(BigDecimal value) {
            addCriterion("first_second_15 <>", value, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15GreaterThan(BigDecimal value) {
            addCriterion("first_second_15 >", value, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_15 >=", value, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15LessThan(BigDecimal value) {
            addCriterion("first_second_15 <", value, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_15 <=", value, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15In(List<BigDecimal> values) {
            addCriterion("first_second_15 in", values, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15NotIn(List<BigDecimal> values) {
            addCriterion("first_second_15 not in", values, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_15 between", value1, value2, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond15NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_15 not between", value1, value2, "firstSecond15");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16IsNull() {
            addCriterion("first_second_16 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16IsNotNull() {
            addCriterion("first_second_16 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16EqualTo(BigDecimal value) {
            addCriterion("first_second_16 =", value, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16NotEqualTo(BigDecimal value) {
            addCriterion("first_second_16 <>", value, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16GreaterThan(BigDecimal value) {
            addCriterion("first_second_16 >", value, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_16 >=", value, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16LessThan(BigDecimal value) {
            addCriterion("first_second_16 <", value, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_16 <=", value, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16In(List<BigDecimal> values) {
            addCriterion("first_second_16 in", values, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16NotIn(List<BigDecimal> values) {
            addCriterion("first_second_16 not in", values, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_16 between", value1, value2, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond16NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_16 not between", value1, value2, "firstSecond16");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17IsNull() {
            addCriterion("first_second_17 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17IsNotNull() {
            addCriterion("first_second_17 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17EqualTo(BigDecimal value) {
            addCriterion("first_second_17 =", value, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17NotEqualTo(BigDecimal value) {
            addCriterion("first_second_17 <>", value, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17GreaterThan(BigDecimal value) {
            addCriterion("first_second_17 >", value, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_17 >=", value, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17LessThan(BigDecimal value) {
            addCriterion("first_second_17 <", value, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_17 <=", value, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17In(List<BigDecimal> values) {
            addCriterion("first_second_17 in", values, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17NotIn(List<BigDecimal> values) {
            addCriterion("first_second_17 not in", values, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_17 between", value1, value2, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond17NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_17 not between", value1, value2, "firstSecond17");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18IsNull() {
            addCriterion("first_second_18 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18IsNotNull() {
            addCriterion("first_second_18 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18EqualTo(BigDecimal value) {
            addCriterion("first_second_18 =", value, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18NotEqualTo(BigDecimal value) {
            addCriterion("first_second_18 <>", value, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18GreaterThan(BigDecimal value) {
            addCriterion("first_second_18 >", value, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_18 >=", value, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18LessThan(BigDecimal value) {
            addCriterion("first_second_18 <", value, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_18 <=", value, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18In(List<BigDecimal> values) {
            addCriterion("first_second_18 in", values, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18NotIn(List<BigDecimal> values) {
            addCriterion("first_second_18 not in", values, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_18 between", value1, value2, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond18NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_18 not between", value1, value2, "firstSecond18");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19IsNull() {
            addCriterion("first_second_19 is null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19IsNotNull() {
            addCriterion("first_second_19 is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19EqualTo(BigDecimal value) {
            addCriterion("first_second_19 =", value, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19NotEqualTo(BigDecimal value) {
            addCriterion("first_second_19 <>", value, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19GreaterThan(BigDecimal value) {
            addCriterion("first_second_19 >", value, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_19 >=", value, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19LessThan(BigDecimal value) {
            addCriterion("first_second_19 <", value, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19LessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_second_19 <=", value, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19In(List<BigDecimal> values) {
            addCriterion("first_second_19 in", values, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19NotIn(List<BigDecimal> values) {
            addCriterion("first_second_19 not in", values, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_19 between", value1, value2, "firstSecond19");
            return (Criteria) this;
        }

        public Criteria andFirstSecond19NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_second_19 not between", value1, value2, "firstSecond19");
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