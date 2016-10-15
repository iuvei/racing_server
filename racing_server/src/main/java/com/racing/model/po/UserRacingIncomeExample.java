package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRacingIncomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserRacingIncomeExample() {
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

        public Criteria andUserStakeAmountIsNull() {
            addCriterion("user_stake_amount is null");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountIsNotNull() {
            addCriterion("user_stake_amount is not null");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountEqualTo(BigDecimal value) {
            addCriterion("user_stake_amount =", value, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountNotEqualTo(BigDecimal value) {
            addCriterion("user_stake_amount <>", value, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountGreaterThan(BigDecimal value) {
            addCriterion("user_stake_amount >", value, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_stake_amount >=", value, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountLessThan(BigDecimal value) {
            addCriterion("user_stake_amount <", value, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_stake_amount <=", value, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountIn(List<BigDecimal> values) {
            addCriterion("user_stake_amount in", values, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountNotIn(List<BigDecimal> values) {
            addCriterion("user_stake_amount not in", values, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_stake_amount between", value1, value2, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andUserStakeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_stake_amount not between", value1, value2, "userStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountIsNull() {
            addCriterion("members_stake_amount is null");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountIsNotNull() {
            addCriterion("members_stake_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountEqualTo(BigDecimal value) {
            addCriterion("members_stake_amount =", value, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountNotEqualTo(BigDecimal value) {
            addCriterion("members_stake_amount <>", value, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountGreaterThan(BigDecimal value) {
            addCriterion("members_stake_amount >", value, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("members_stake_amount >=", value, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountLessThan(BigDecimal value) {
            addCriterion("members_stake_amount <", value, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("members_stake_amount <=", value, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountIn(List<BigDecimal> values) {
            addCriterion("members_stake_amount in", values, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountNotIn(List<BigDecimal> values) {
            addCriterion("members_stake_amount not in", values, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("members_stake_amount between", value1, value2, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("members_stake_amount not between", value1, value2, "membersStakeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountIsNull() {
            addCriterion("total_income_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountIsNotNull() {
            addCriterion("total_income_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountEqualTo(BigDecimal value) {
            addCriterion("total_income_amount =", value, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_income_amount <>", value, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountGreaterThan(BigDecimal value) {
            addCriterion("total_income_amount >", value, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_income_amount >=", value, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountLessThan(BigDecimal value) {
            addCriterion("total_income_amount <", value, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_income_amount <=", value, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountIn(List<BigDecimal> values) {
            addCriterion("total_income_amount in", values, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_income_amount not in", values, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_income_amount between", value1, value2, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_income_amount not between", value1, value2, "totalIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountIsNull() {
            addCriterion("user_income_amount is null");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountIsNotNull() {
            addCriterion("user_income_amount is not null");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountEqualTo(BigDecimal value) {
            addCriterion("user_income_amount =", value, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountNotEqualTo(BigDecimal value) {
            addCriterion("user_income_amount <>", value, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountGreaterThan(BigDecimal value) {
            addCriterion("user_income_amount >", value, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_income_amount >=", value, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountLessThan(BigDecimal value) {
            addCriterion("user_income_amount <", value, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_income_amount <=", value, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountIn(List<BigDecimal> values) {
            addCriterion("user_income_amount in", values, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountNotIn(List<BigDecimal> values) {
            addCriterion("user_income_amount not in", values, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_income_amount between", value1, value2, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andUserIncomeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_income_amount not between", value1, value2, "userIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountIsNull() {
            addCriterion("members_income_amount is null");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountIsNotNull() {
            addCriterion("members_income_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountEqualTo(BigDecimal value) {
            addCriterion("members_income_amount =", value, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountNotEqualTo(BigDecimal value) {
            addCriterion("members_income_amount <>", value, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountGreaterThan(BigDecimal value) {
            addCriterion("members_income_amount >", value, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("members_income_amount >=", value, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountLessThan(BigDecimal value) {
            addCriterion("members_income_amount <", value, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("members_income_amount <=", value, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountIn(List<BigDecimal> values) {
            addCriterion("members_income_amount in", values, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountNotIn(List<BigDecimal> values) {
            addCriterion("members_income_amount not in", values, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("members_income_amount between", value1, value2, "membersIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andMembersIncomeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("members_income_amount not between", value1, value2, "membersIncomeAmount");
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

        public Criteria andUserDeficitAmountIsNull() {
            addCriterion("user_deficit_amount is null");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountIsNotNull() {
            addCriterion("user_deficit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountEqualTo(BigDecimal value) {
            addCriterion("user_deficit_amount =", value, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountNotEqualTo(BigDecimal value) {
            addCriterion("user_deficit_amount <>", value, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountGreaterThan(BigDecimal value) {
            addCriterion("user_deficit_amount >", value, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_deficit_amount >=", value, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountLessThan(BigDecimal value) {
            addCriterion("user_deficit_amount <", value, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_deficit_amount <=", value, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountIn(List<BigDecimal> values) {
            addCriterion("user_deficit_amount in", values, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountNotIn(List<BigDecimal> values) {
            addCriterion("user_deficit_amount not in", values, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_deficit_amount between", value1, value2, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andUserDeficitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_deficit_amount not between", value1, value2, "userDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountIsNull() {
            addCriterion("members_deficit_amount is null");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountIsNotNull() {
            addCriterion("members_deficit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountEqualTo(BigDecimal value) {
            addCriterion("members_deficit_amount =", value, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountNotEqualTo(BigDecimal value) {
            addCriterion("members_deficit_amount <>", value, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountGreaterThan(BigDecimal value) {
            addCriterion("members_deficit_amount >", value, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("members_deficit_amount >=", value, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountLessThan(BigDecimal value) {
            addCriterion("members_deficit_amount <", value, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("members_deficit_amount <=", value, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountIn(List<BigDecimal> values) {
            addCriterion("members_deficit_amount in", values, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountNotIn(List<BigDecimal> values) {
            addCriterion("members_deficit_amount not in", values, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("members_deficit_amount between", value1, value2, "membersDeficitAmount");
            return (Criteria) this;
        }

        public Criteria andMembersDeficitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("members_deficit_amount not between", value1, value2, "membersDeficitAmount");
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

        public Criteria andUserStakeCountIsNull() {
            addCriterion("user_stake_count is null");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountIsNotNull() {
            addCriterion("user_stake_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountEqualTo(Integer value) {
            addCriterion("user_stake_count =", value, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountNotEqualTo(Integer value) {
            addCriterion("user_stake_count <>", value, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountGreaterThan(Integer value) {
            addCriterion("user_stake_count >", value, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_stake_count >=", value, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountLessThan(Integer value) {
            addCriterion("user_stake_count <", value, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_stake_count <=", value, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountIn(List<Integer> values) {
            addCriterion("user_stake_count in", values, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountNotIn(List<Integer> values) {
            addCriterion("user_stake_count not in", values, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountBetween(Integer value1, Integer value2) {
            addCriterion("user_stake_count between", value1, value2, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andUserStakeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_stake_count not between", value1, value2, "userStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountIsNull() {
            addCriterion("members_stake_count is null");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountIsNotNull() {
            addCriterion("members_stake_count is not null");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountEqualTo(Integer value) {
            addCriterion("members_stake_count =", value, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountNotEqualTo(Integer value) {
            addCriterion("members_stake_count <>", value, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountGreaterThan(Integer value) {
            addCriterion("members_stake_count >", value, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("members_stake_count >=", value, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountLessThan(Integer value) {
            addCriterion("members_stake_count <", value, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountLessThanOrEqualTo(Integer value) {
            addCriterion("members_stake_count <=", value, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountIn(List<Integer> values) {
            addCriterion("members_stake_count in", values, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountNotIn(List<Integer> values) {
            addCriterion("members_stake_count not in", values, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountBetween(Integer value1, Integer value2) {
            addCriterion("members_stake_count between", value1, value2, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andMembersStakeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("members_stake_count not between", value1, value2, "membersStakeCount");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsIsNull() {
            addCriterion("is_complate_statistics is null");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsIsNotNull() {
            addCriterion("is_complate_statistics is not null");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsEqualTo(Boolean value) {
            addCriterion("is_complate_statistics =", value, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsNotEqualTo(Boolean value) {
            addCriterion("is_complate_statistics <>", value, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsGreaterThan(Boolean value) {
            addCriterion("is_complate_statistics >", value, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_complate_statistics >=", value, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsLessThan(Boolean value) {
            addCriterion("is_complate_statistics <", value, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsLessThanOrEqualTo(Boolean value) {
            addCriterion("is_complate_statistics <=", value, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsIn(List<Boolean> values) {
            addCriterion("is_complate_statistics in", values, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsNotIn(List<Boolean> values) {
            addCriterion("is_complate_statistics not in", values, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complate_statistics between", value1, value2, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andIsComplateStatisticsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complate_statistics not between", value1, value2, "isComplateStatistics");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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