package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserAppointStakeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAppointStakeExample() {
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

        public Criteria andCarNumIsNull() {
            addCriterion("car_num is null");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNotNull() {
            addCriterion("car_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumEqualTo(Integer value) {
            addCriterion("car_num =", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotEqualTo(Integer value) {
            addCriterion("car_num <>", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThan(Integer value) {
            addCriterion("car_num >", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_num >=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThan(Integer value) {
            addCriterion("car_num <", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThanOrEqualTo(Integer value) {
            addCriterion("car_num <=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumIn(List<Integer> values) {
            addCriterion("car_num in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotIn(List<Integer> values) {
            addCriterion("car_num not in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumBetween(Integer value1, Integer value2) {
            addCriterion("car_num between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotBetween(Integer value1, Integer value2) {
            addCriterion("car_num not between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andFirstIsNull() {
            addCriterion("first is null");
            return (Criteria) this;
        }

        public Criteria andFirstIsNotNull() {
            addCriterion("first is not null");
            return (Criteria) this;
        }

        public Criteria andFirstEqualTo(BigDecimal value) {
            addCriterion("first =", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotEqualTo(BigDecimal value) {
            addCriterion("first <>", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstGreaterThan(BigDecimal value) {
            addCriterion("first >", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first >=", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLessThan(BigDecimal value) {
            addCriterion("first <", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first <=", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstIn(List<BigDecimal> values) {
            addCriterion("first in", values, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotIn(List<BigDecimal> values) {
            addCriterion("first not in", values, "first");
            return (Criteria) this;
        }

        public Criteria andFirstBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first between", value1, value2, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first not between", value1, value2, "first");
            return (Criteria) this;
        }

        public Criteria andSecondIsNull() {
            addCriterion("second is null");
            return (Criteria) this;
        }

        public Criteria andSecondIsNotNull() {
            addCriterion("second is not null");
            return (Criteria) this;
        }

        public Criteria andSecondEqualTo(BigDecimal value) {
            addCriterion("second =", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotEqualTo(BigDecimal value) {
            addCriterion("second <>", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondGreaterThan(BigDecimal value) {
            addCriterion("second >", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("second >=", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLessThan(BigDecimal value) {
            addCriterion("second <", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLessThanOrEqualTo(BigDecimal value) {
            addCriterion("second <=", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondIn(List<BigDecimal> values) {
            addCriterion("second in", values, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotIn(List<BigDecimal> values) {
            addCriterion("second not in", values, "second");
            return (Criteria) this;
        }

        public Criteria andSecondBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second between", value1, value2, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second not between", value1, value2, "second");
            return (Criteria) this;
        }

        public Criteria andThirdIsNull() {
            addCriterion("third is null");
            return (Criteria) this;
        }

        public Criteria andThirdIsNotNull() {
            addCriterion("third is not null");
            return (Criteria) this;
        }

        public Criteria andThirdEqualTo(BigDecimal value) {
            addCriterion("third =", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdNotEqualTo(BigDecimal value) {
            addCriterion("third <>", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdGreaterThan(BigDecimal value) {
            addCriterion("third >", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("third >=", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdLessThan(BigDecimal value) {
            addCriterion("third <", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("third <=", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdIn(List<BigDecimal> values) {
            addCriterion("third in", values, "third");
            return (Criteria) this;
        }

        public Criteria andThirdNotIn(List<BigDecimal> values) {
            addCriterion("third not in", values, "third");
            return (Criteria) this;
        }

        public Criteria andThirdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("third between", value1, value2, "third");
            return (Criteria) this;
        }

        public Criteria andThirdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("third not between", value1, value2, "third");
            return (Criteria) this;
        }

        public Criteria andFourthIsNull() {
            addCriterion("fourth is null");
            return (Criteria) this;
        }

        public Criteria andFourthIsNotNull() {
            addCriterion("fourth is not null");
            return (Criteria) this;
        }

        public Criteria andFourthEqualTo(BigDecimal value) {
            addCriterion("fourth =", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthNotEqualTo(BigDecimal value) {
            addCriterion("fourth <>", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthGreaterThan(BigDecimal value) {
            addCriterion("fourth >", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fourth >=", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthLessThan(BigDecimal value) {
            addCriterion("fourth <", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fourth <=", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthIn(List<BigDecimal> values) {
            addCriterion("fourth in", values, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthNotIn(List<BigDecimal> values) {
            addCriterion("fourth not in", values, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fourth between", value1, value2, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fourth not between", value1, value2, "fourth");
            return (Criteria) this;
        }

        public Criteria andFifthIsNull() {
            addCriterion("fifth is null");
            return (Criteria) this;
        }

        public Criteria andFifthIsNotNull() {
            addCriterion("fifth is not null");
            return (Criteria) this;
        }

        public Criteria andFifthEqualTo(BigDecimal value) {
            addCriterion("fifth =", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthNotEqualTo(BigDecimal value) {
            addCriterion("fifth <>", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthGreaterThan(BigDecimal value) {
            addCriterion("fifth >", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fifth >=", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthLessThan(BigDecimal value) {
            addCriterion("fifth <", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fifth <=", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthIn(List<BigDecimal> values) {
            addCriterion("fifth in", values, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthNotIn(List<BigDecimal> values) {
            addCriterion("fifth not in", values, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fifth between", value1, value2, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fifth not between", value1, value2, "fifth");
            return (Criteria) this;
        }

        public Criteria andSixthIsNull() {
            addCriterion("sixth is null");
            return (Criteria) this;
        }

        public Criteria andSixthIsNotNull() {
            addCriterion("sixth is not null");
            return (Criteria) this;
        }

        public Criteria andSixthEqualTo(BigDecimal value) {
            addCriterion("sixth =", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthNotEqualTo(BigDecimal value) {
            addCriterion("sixth <>", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthGreaterThan(BigDecimal value) {
            addCriterion("sixth >", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sixth >=", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthLessThan(BigDecimal value) {
            addCriterion("sixth <", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sixth <=", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthIn(List<BigDecimal> values) {
            addCriterion("sixth in", values, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthNotIn(List<BigDecimal> values) {
            addCriterion("sixth not in", values, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sixth between", value1, value2, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sixth not between", value1, value2, "sixth");
            return (Criteria) this;
        }

        public Criteria andSeventhIsNull() {
            addCriterion("seventh is null");
            return (Criteria) this;
        }

        public Criteria andSeventhIsNotNull() {
            addCriterion("seventh is not null");
            return (Criteria) this;
        }

        public Criteria andSeventhEqualTo(BigDecimal value) {
            addCriterion("seventh =", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhNotEqualTo(BigDecimal value) {
            addCriterion("seventh <>", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhGreaterThan(BigDecimal value) {
            addCriterion("seventh >", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("seventh >=", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhLessThan(BigDecimal value) {
            addCriterion("seventh <", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("seventh <=", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhIn(List<BigDecimal> values) {
            addCriterion("seventh in", values, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhNotIn(List<BigDecimal> values) {
            addCriterion("seventh not in", values, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seventh between", value1, value2, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seventh not between", value1, value2, "seventh");
            return (Criteria) this;
        }

        public Criteria andEighthIsNull() {
            addCriterion("eighth is null");
            return (Criteria) this;
        }

        public Criteria andEighthIsNotNull() {
            addCriterion("eighth is not null");
            return (Criteria) this;
        }

        public Criteria andEighthEqualTo(BigDecimal value) {
            addCriterion("eighth =", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthNotEqualTo(BigDecimal value) {
            addCriterion("eighth <>", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthGreaterThan(BigDecimal value) {
            addCriterion("eighth >", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("eighth >=", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthLessThan(BigDecimal value) {
            addCriterion("eighth <", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("eighth <=", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthIn(List<BigDecimal> values) {
            addCriterion("eighth in", values, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthNotIn(List<BigDecimal> values) {
            addCriterion("eighth not in", values, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eighth between", value1, value2, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("eighth not between", value1, value2, "eighth");
            return (Criteria) this;
        }

        public Criteria andNinthIsNull() {
            addCriterion("ninth is null");
            return (Criteria) this;
        }

        public Criteria andNinthIsNotNull() {
            addCriterion("ninth is not null");
            return (Criteria) this;
        }

        public Criteria andNinthEqualTo(BigDecimal value) {
            addCriterion("ninth =", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthNotEqualTo(BigDecimal value) {
            addCriterion("ninth <>", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthGreaterThan(BigDecimal value) {
            addCriterion("ninth >", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ninth >=", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthLessThan(BigDecimal value) {
            addCriterion("ninth <", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ninth <=", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthIn(List<BigDecimal> values) {
            addCriterion("ninth in", values, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthNotIn(List<BigDecimal> values) {
            addCriterion("ninth not in", values, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ninth between", value1, value2, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ninth not between", value1, value2, "ninth");
            return (Criteria) this;
        }

        public Criteria andTenthIsNull() {
            addCriterion("tenth is null");
            return (Criteria) this;
        }

        public Criteria andTenthIsNotNull() {
            addCriterion("tenth is not null");
            return (Criteria) this;
        }

        public Criteria andTenthEqualTo(BigDecimal value) {
            addCriterion("tenth =", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthNotEqualTo(BigDecimal value) {
            addCriterion("tenth <>", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthGreaterThan(BigDecimal value) {
            addCriterion("tenth >", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tenth >=", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthLessThan(BigDecimal value) {
            addCriterion("tenth <", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tenth <=", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthIn(List<BigDecimal> values) {
            addCriterion("tenth in", values, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthNotIn(List<BigDecimal> values) {
            addCriterion("tenth not in", values, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tenth between", value1, value2, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tenth not between", value1, value2, "tenth");
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