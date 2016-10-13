package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WechatClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WechatClientExample() {
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

        public Criteria andAppointStakeRateIsNull() {
            addCriterion("appoint_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateIsNotNull() {
            addCriterion("appoint_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateEqualTo(BigDecimal value) {
            addCriterion("appoint_stake_rate =", value, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateNotEqualTo(BigDecimal value) {
            addCriterion("appoint_stake_rate <>", value, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateGreaterThan(BigDecimal value) {
            addCriterion("appoint_stake_rate >", value, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("appoint_stake_rate >=", value, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateLessThan(BigDecimal value) {
            addCriterion("appoint_stake_rate <", value, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("appoint_stake_rate <=", value, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateIn(List<BigDecimal> values) {
            addCriterion("appoint_stake_rate in", values, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateNotIn(List<BigDecimal> values) {
            addCriterion("appoint_stake_rate not in", values, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("appoint_stake_rate between", value1, value2, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andAppointStakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("appoint_stake_rate not between", value1, value2, "appointStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateIsNull() {
            addCriterion("ranking_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateIsNotNull() {
            addCriterion("ranking_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateEqualTo(BigDecimal value) {
            addCriterion("ranking_stake_rate =", value, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateNotEqualTo(BigDecimal value) {
            addCriterion("ranking_stake_rate <>", value, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateGreaterThan(BigDecimal value) {
            addCriterion("ranking_stake_rate >", value, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ranking_stake_rate >=", value, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateLessThan(BigDecimal value) {
            addCriterion("ranking_stake_rate <", value, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ranking_stake_rate <=", value, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateIn(List<BigDecimal> values) {
            addCriterion("ranking_stake_rate in", values, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateNotIn(List<BigDecimal> values) {
            addCriterion("ranking_stake_rate not in", values, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ranking_stake_rate between", value1, value2, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andRankingStakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ranking_stake_rate not between", value1, value2, "rankingStakeRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateIsNull() {
            addCriterion("up_or_down_rate is null");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateIsNotNull() {
            addCriterion("up_or_down_rate is not null");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateEqualTo(BigDecimal value) {
            addCriterion("up_or_down_rate =", value, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateNotEqualTo(BigDecimal value) {
            addCriterion("up_or_down_rate <>", value, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateGreaterThan(BigDecimal value) {
            addCriterion("up_or_down_rate >", value, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("up_or_down_rate >=", value, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateLessThan(BigDecimal value) {
            addCriterion("up_or_down_rate <", value, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("up_or_down_rate <=", value, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateIn(List<BigDecimal> values) {
            addCriterion("up_or_down_rate in", values, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateNotIn(List<BigDecimal> values) {
            addCriterion("up_or_down_rate not in", values, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_or_down_rate between", value1, value2, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andUpOrDownRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_or_down_rate not between", value1, value2, "upOrDownRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateIsNull() {
            addCriterion("first_add_second_odd_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateIsNotNull() {
            addCriterion("first_add_second_odd_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_odd_rate =", value, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_odd_rate <>", value, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_odd_rate >", value, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_odd_rate >=", value, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_odd_rate <", value, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_odd_rate <=", value, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_odd_rate in", values, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_odd_rate not in", values, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_odd_rate between", value1, value2, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondOddRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_odd_rate not between", value1, value2, "firstAddSecondOddRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateIsNull() {
            addCriterion("first_add_second_even_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateIsNotNull() {
            addCriterion("first_add_second_even_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_even_rate =", value, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_even_rate <>", value, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_even_rate >", value, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_even_rate >=", value, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_even_rate <", value, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_even_rate <=", value, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_even_rate in", values, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_even_rate not in", values, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_even_rate between", value1, value2, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEvenRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_even_rate not between", value1, value2, "firstAddSecondEvenRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateIsNull() {
            addCriterion("first_add_second_big_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateIsNotNull() {
            addCriterion("first_add_second_big_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_big_rate =", value, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_big_rate <>", value, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_big_rate >", value, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_big_rate >=", value, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_big_rate <", value, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_big_rate <=", value, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_big_rate in", values, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_big_rate not in", values, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_big_rate between", value1, value2, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBigRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_big_rate not between", value1, value2, "firstAddSecondBigRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateIsNull() {
            addCriterion("first_add_second_small_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateIsNotNull() {
            addCriterion("first_add_second_small_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_small_rate =", value, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_small_rate <>", value, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_small_rate >", value, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_small_rate >=", value, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_small_rate <", value, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_small_rate <=", value, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_small_rate in", values, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_small_rate not in", values, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_small_rate between", value1, value2, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondSmallRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_small_rate not between", value1, value2, "firstAddSecondSmallRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateIsNull() {
            addCriterion("first_add_second_appoint3_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint3_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint3_stake_rate =", value, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint3_stake_rate <>", value, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint3_stake_rate >", value, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint3_stake_rate >=", value, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint3_stake_rate <", value, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint3_stake_rate <=", value, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint3_stake_rate in", values, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint3_stake_rate not in", values, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint3_stake_rate between", value1, value2, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint3StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint3_stake_rate not between", value1, value2, "firstAddSecondAppoint3StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateIsNull() {
            addCriterion("first_add_second_appoint4_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint4_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint4_stake_rate =", value, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint4_stake_rate <>", value, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint4_stake_rate >", value, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint4_stake_rate >=", value, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint4_stake_rate <", value, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint4_stake_rate <=", value, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint4_stake_rate in", values, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint4_stake_rate not in", values, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint4_stake_rate between", value1, value2, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint4StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint4_stake_rate not between", value1, value2, "firstAddSecondAppoint4StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateIsNull() {
            addCriterion("first_add_second_appoint5_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint5_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint5_stake_rate =", value, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint5_stake_rate <>", value, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint5_stake_rate >", value, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint5_stake_rate >=", value, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint5_stake_rate <", value, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint5_stake_rate <=", value, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint5_stake_rate in", values, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint5_stake_rate not in", values, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint5_stake_rate between", value1, value2, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint5StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint5_stake_rate not between", value1, value2, "firstAddSecondAppoint5StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateIsNull() {
            addCriterion("first_add_second_appoint6_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint6_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint6_stake_rate =", value, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint6_stake_rate <>", value, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint6_stake_rate >", value, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint6_stake_rate >=", value, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint6_stake_rate <", value, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint6_stake_rate <=", value, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint6_stake_rate in", values, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint6_stake_rate not in", values, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint6_stake_rate between", value1, value2, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint6StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint6_stake_rate not between", value1, value2, "firstAddSecondAppoint6StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateIsNull() {
            addCriterion("first_add_second_appoint7_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint7_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint7_stake_rate =", value, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint7_stake_rate <>", value, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint7_stake_rate >", value, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint7_stake_rate >=", value, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint7_stake_rate <", value, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint7_stake_rate <=", value, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint7_stake_rate in", values, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint7_stake_rate not in", values, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint7_stake_rate between", value1, value2, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint7StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint7_stake_rate not between", value1, value2, "firstAddSecondAppoint7StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateIsNull() {
            addCriterion("first_add_second_appoint8_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint8_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint8_stake_rate =", value, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint8_stake_rate <>", value, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint8_stake_rate >", value, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint8_stake_rate >=", value, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint8_stake_rate <", value, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint8_stake_rate <=", value, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint8_stake_rate in", values, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint8_stake_rate not in", values, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint8_stake_rate between", value1, value2, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint8StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint8_stake_rate not between", value1, value2, "firstAddSecondAppoint8StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateIsNull() {
            addCriterion("first_add_second_appoint9_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint9_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint9_stake_rate =", value, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint9_stake_rate <>", value, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint9_stake_rate >", value, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint9_stake_rate >=", value, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint9_stake_rate <", value, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint9_stake_rate <=", value, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint9_stake_rate in", values, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint9_stake_rate not in", values, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint9_stake_rate between", value1, value2, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint9StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint9_stake_rate not between", value1, value2, "firstAddSecondAppoint9StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateIsNull() {
            addCriterion("first_add_second_appoint10_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint10_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint10_stake_rate =", value, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint10_stake_rate <>", value, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint10_stake_rate >", value, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint10_stake_rate >=", value, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint10_stake_rate <", value, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint10_stake_rate <=", value, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint10_stake_rate in", values, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint10_stake_rate not in", values, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint10_stake_rate between", value1, value2, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint10StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint10_stake_rate not between", value1, value2, "firstAddSecondAppoint10StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateIsNull() {
            addCriterion("first_add_second_appoint11_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint11_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint11_stake_rate =", value, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint11_stake_rate <>", value, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint11_stake_rate >", value, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint11_stake_rate >=", value, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint11_stake_rate <", value, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint11_stake_rate <=", value, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint11_stake_rate in", values, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint11_stake_rate not in", values, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint11_stake_rate between", value1, value2, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint11StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint11_stake_rate not between", value1, value2, "firstAddSecondAppoint11StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateIsNull() {
            addCriterion("first_add_second_appoint12_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint12_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint12_stake_rate =", value, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint12_stake_rate <>", value, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint12_stake_rate >", value, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint12_stake_rate >=", value, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint12_stake_rate <", value, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint12_stake_rate <=", value, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint12_stake_rate in", values, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint12_stake_rate not in", values, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint12_stake_rate between", value1, value2, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint12StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint12_stake_rate not between", value1, value2, "firstAddSecondAppoint12StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateIsNull() {
            addCriterion("first_add_second_appoint13_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint13_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint13_stake_rate =", value, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint13_stake_rate <>", value, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint13_stake_rate >", value, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint13_stake_rate >=", value, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint13_stake_rate <", value, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint13_stake_rate <=", value, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint13_stake_rate in", values, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint13_stake_rate not in", values, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint13_stake_rate between", value1, value2, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint13StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint13_stake_rate not between", value1, value2, "firstAddSecondAppoint13StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateIsNull() {
            addCriterion("first_add_second_appoint14_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint14_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint14_stake_rate =", value, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint14_stake_rate <>", value, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint14_stake_rate >", value, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint14_stake_rate >=", value, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint14_stake_rate <", value, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint14_stake_rate <=", value, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint14_stake_rate in", values, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint14_stake_rate not in", values, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint14_stake_rate between", value1, value2, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint14StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint14_stake_rate not between", value1, value2, "firstAddSecondAppoint14StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateIsNull() {
            addCriterion("first_add_second_appoint15_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint15_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint15_stake_rate =", value, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint15_stake_rate <>", value, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint15_stake_rate >", value, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint15_stake_rate >=", value, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint15_stake_rate <", value, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint15_stake_rate <=", value, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint15_stake_rate in", values, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint15_stake_rate not in", values, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint15_stake_rate between", value1, value2, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint15StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint15_stake_rate not between", value1, value2, "firstAddSecondAppoint15StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateIsNull() {
            addCriterion("first_add_second_appoint16_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint16_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint16_stake_rate =", value, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint16_stake_rate <>", value, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint16_stake_rate >", value, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint16_stake_rate >=", value, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint16_stake_rate <", value, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint16_stake_rate <=", value, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint16_stake_rate in", values, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint16_stake_rate not in", values, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint16_stake_rate between", value1, value2, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint16StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint16_stake_rate not between", value1, value2, "firstAddSecondAppoint16StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateIsNull() {
            addCriterion("first_add_second_appoint17_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint17_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint17_stake_rate =", value, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint17_stake_rate <>", value, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint17_stake_rate >", value, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint17_stake_rate >=", value, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint17_stake_rate <", value, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint17_stake_rate <=", value, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint17_stake_rate in", values, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint17_stake_rate not in", values, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint17_stake_rate between", value1, value2, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint17StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint17_stake_rate not between", value1, value2, "firstAddSecondAppoint17StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateIsNull() {
            addCriterion("first_add_second_appoint18_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint18_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint18_stake_rate =", value, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint18_stake_rate <>", value, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint18_stake_rate >", value, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint18_stake_rate >=", value, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint18_stake_rate <", value, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint18_stake_rate <=", value, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint18_stake_rate in", values, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint18_stake_rate not in", values, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint18_stake_rate between", value1, value2, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint18StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint18_stake_rate not between", value1, value2, "firstAddSecondAppoint18StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateIsNull() {
            addCriterion("first_add_second_appoint19_stake_rate is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateIsNotNull() {
            addCriterion("first_add_second_appoint19_stake_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint19_stake_rate =", value, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateNotEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint19_stake_rate <>", value, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateGreaterThan(BigDecimal value) {
            addCriterion("first_add_second_appoint19_stake_rate >", value, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint19_stake_rate >=", value, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateLessThan(BigDecimal value) {
            addCriterion("first_add_second_appoint19_stake_rate <", value, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_add_second_appoint19_stake_rate <=", value, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint19_stake_rate in", values, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateNotIn(List<BigDecimal> values) {
            addCriterion("first_add_second_appoint19_stake_rate not in", values, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint19_stake_rate between", value1, value2, "firstAddSecondAppoint19StakeRate");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondAppoint19StakeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_add_second_appoint19_stake_rate not between", value1, value2, "firstAddSecondAppoint19StakeRate");
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