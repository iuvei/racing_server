package com.racing.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordResultExample() {
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

        public Criteria andFirstIsNull() {
            addCriterion("first is null");
            return (Criteria) this;
        }

        public Criteria andFirstIsNotNull() {
            addCriterion("first is not null");
            return (Criteria) this;
        }

        public Criteria andFirstEqualTo(Integer value) {
            addCriterion("first =", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotEqualTo(Integer value) {
            addCriterion("first <>", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstGreaterThan(Integer value) {
            addCriterion("first >", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstGreaterThanOrEqualTo(Integer value) {
            addCriterion("first >=", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLessThan(Integer value) {
            addCriterion("first <", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLessThanOrEqualTo(Integer value) {
            addCriterion("first <=", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstIn(List<Integer> values) {
            addCriterion("first in", values, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotIn(List<Integer> values) {
            addCriterion("first not in", values, "first");
            return (Criteria) this;
        }

        public Criteria andFirstBetween(Integer value1, Integer value2) {
            addCriterion("first between", value1, value2, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotBetween(Integer value1, Integer value2) {
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

        public Criteria andSecondEqualTo(Integer value) {
            addCriterion("second =", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotEqualTo(Integer value) {
            addCriterion("second <>", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondGreaterThan(Integer value) {
            addCriterion("second >", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondGreaterThanOrEqualTo(Integer value) {
            addCriterion("second >=", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLessThan(Integer value) {
            addCriterion("second <", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLessThanOrEqualTo(Integer value) {
            addCriterion("second <=", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondIn(List<Integer> values) {
            addCriterion("second in", values, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotIn(List<Integer> values) {
            addCriterion("second not in", values, "second");
            return (Criteria) this;
        }

        public Criteria andSecondBetween(Integer value1, Integer value2) {
            addCriterion("second between", value1, value2, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotBetween(Integer value1, Integer value2) {
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

        public Criteria andThirdEqualTo(Integer value) {
            addCriterion("third =", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdNotEqualTo(Integer value) {
            addCriterion("third <>", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdGreaterThan(Integer value) {
            addCriterion("third >", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdGreaterThanOrEqualTo(Integer value) {
            addCriterion("third >=", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdLessThan(Integer value) {
            addCriterion("third <", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdLessThanOrEqualTo(Integer value) {
            addCriterion("third <=", value, "third");
            return (Criteria) this;
        }

        public Criteria andThirdIn(List<Integer> values) {
            addCriterion("third in", values, "third");
            return (Criteria) this;
        }

        public Criteria andThirdNotIn(List<Integer> values) {
            addCriterion("third not in", values, "third");
            return (Criteria) this;
        }

        public Criteria andThirdBetween(Integer value1, Integer value2) {
            addCriterion("third between", value1, value2, "third");
            return (Criteria) this;
        }

        public Criteria andThirdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andFourthEqualTo(Integer value) {
            addCriterion("fourth =", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthNotEqualTo(Integer value) {
            addCriterion("fourth <>", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthGreaterThan(Integer value) {
            addCriterion("fourth >", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthGreaterThanOrEqualTo(Integer value) {
            addCriterion("fourth >=", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthLessThan(Integer value) {
            addCriterion("fourth <", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthLessThanOrEqualTo(Integer value) {
            addCriterion("fourth <=", value, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthIn(List<Integer> values) {
            addCriterion("fourth in", values, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthNotIn(List<Integer> values) {
            addCriterion("fourth not in", values, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthBetween(Integer value1, Integer value2) {
            addCriterion("fourth between", value1, value2, "fourth");
            return (Criteria) this;
        }

        public Criteria andFourthNotBetween(Integer value1, Integer value2) {
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

        public Criteria andFifthEqualTo(Integer value) {
            addCriterion("fifth =", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthNotEqualTo(Integer value) {
            addCriterion("fifth <>", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthGreaterThan(Integer value) {
            addCriterion("fifth >", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthGreaterThanOrEqualTo(Integer value) {
            addCriterion("fifth >=", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthLessThan(Integer value) {
            addCriterion("fifth <", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthLessThanOrEqualTo(Integer value) {
            addCriterion("fifth <=", value, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthIn(List<Integer> values) {
            addCriterion("fifth in", values, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthNotIn(List<Integer> values) {
            addCriterion("fifth not in", values, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthBetween(Integer value1, Integer value2) {
            addCriterion("fifth between", value1, value2, "fifth");
            return (Criteria) this;
        }

        public Criteria andFifthNotBetween(Integer value1, Integer value2) {
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

        public Criteria andSixthEqualTo(Integer value) {
            addCriterion("sixth =", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthNotEqualTo(Integer value) {
            addCriterion("sixth <>", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthGreaterThan(Integer value) {
            addCriterion("sixth >", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthGreaterThanOrEqualTo(Integer value) {
            addCriterion("sixth >=", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthLessThan(Integer value) {
            addCriterion("sixth <", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthLessThanOrEqualTo(Integer value) {
            addCriterion("sixth <=", value, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthIn(List<Integer> values) {
            addCriterion("sixth in", values, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthNotIn(List<Integer> values) {
            addCriterion("sixth not in", values, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthBetween(Integer value1, Integer value2) {
            addCriterion("sixth between", value1, value2, "sixth");
            return (Criteria) this;
        }

        public Criteria andSixthNotBetween(Integer value1, Integer value2) {
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

        public Criteria andSeventhEqualTo(Integer value) {
            addCriterion("seventh =", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhNotEqualTo(Integer value) {
            addCriterion("seventh <>", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhGreaterThan(Integer value) {
            addCriterion("seventh >", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhGreaterThanOrEqualTo(Integer value) {
            addCriterion("seventh >=", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhLessThan(Integer value) {
            addCriterion("seventh <", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhLessThanOrEqualTo(Integer value) {
            addCriterion("seventh <=", value, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhIn(List<Integer> values) {
            addCriterion("seventh in", values, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhNotIn(List<Integer> values) {
            addCriterion("seventh not in", values, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhBetween(Integer value1, Integer value2) {
            addCriterion("seventh between", value1, value2, "seventh");
            return (Criteria) this;
        }

        public Criteria andSeventhNotBetween(Integer value1, Integer value2) {
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

        public Criteria andEighthEqualTo(Integer value) {
            addCriterion("eighth =", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthNotEqualTo(Integer value) {
            addCriterion("eighth <>", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthGreaterThan(Integer value) {
            addCriterion("eighth >", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthGreaterThanOrEqualTo(Integer value) {
            addCriterion("eighth >=", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthLessThan(Integer value) {
            addCriterion("eighth <", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthLessThanOrEqualTo(Integer value) {
            addCriterion("eighth <=", value, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthIn(List<Integer> values) {
            addCriterion("eighth in", values, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthNotIn(List<Integer> values) {
            addCriterion("eighth not in", values, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthBetween(Integer value1, Integer value2) {
            addCriterion("eighth between", value1, value2, "eighth");
            return (Criteria) this;
        }

        public Criteria andEighthNotBetween(Integer value1, Integer value2) {
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

        public Criteria andNinthEqualTo(Integer value) {
            addCriterion("ninth =", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthNotEqualTo(Integer value) {
            addCriterion("ninth <>", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthGreaterThan(Integer value) {
            addCriterion("ninth >", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthGreaterThanOrEqualTo(Integer value) {
            addCriterion("ninth >=", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthLessThan(Integer value) {
            addCriterion("ninth <", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthLessThanOrEqualTo(Integer value) {
            addCriterion("ninth <=", value, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthIn(List<Integer> values) {
            addCriterion("ninth in", values, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthNotIn(List<Integer> values) {
            addCriterion("ninth not in", values, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthBetween(Integer value1, Integer value2) {
            addCriterion("ninth between", value1, value2, "ninth");
            return (Criteria) this;
        }

        public Criteria andNinthNotBetween(Integer value1, Integer value2) {
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

        public Criteria andTenthEqualTo(Integer value) {
            addCriterion("tenth =", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthNotEqualTo(Integer value) {
            addCriterion("tenth <>", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthGreaterThan(Integer value) {
            addCriterion("tenth >", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthGreaterThanOrEqualTo(Integer value) {
            addCriterion("tenth >=", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthLessThan(Integer value) {
            addCriterion("tenth <", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthLessThanOrEqualTo(Integer value) {
            addCriterion("tenth <=", value, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthIn(List<Integer> values) {
            addCriterion("tenth in", values, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthNotIn(List<Integer> values) {
            addCriterion("tenth not in", values, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthBetween(Integer value1, Integer value2) {
            addCriterion("tenth between", value1, value2, "tenth");
            return (Criteria) this;
        }

        public Criteria andTenthNotBetween(Integer value1, Integer value2) {
            addCriterion("tenth not between", value1, value2, "tenth");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondIsNull() {
            addCriterion("first_add_second is null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondIsNotNull() {
            addCriterion("first_add_second is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondEqualTo(Integer value) {
            addCriterion("first_add_second =", value, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondNotEqualTo(Integer value) {
            addCriterion("first_add_second <>", value, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondGreaterThan(Integer value) {
            addCriterion("first_add_second >", value, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_add_second >=", value, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondLessThan(Integer value) {
            addCriterion("first_add_second <", value, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondLessThanOrEqualTo(Integer value) {
            addCriterion("first_add_second <=", value, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondIn(List<Integer> values) {
            addCriterion("first_add_second in", values, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondNotIn(List<Integer> values) {
            addCriterion("first_add_second not in", values, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondBetween(Integer value1, Integer value2) {
            addCriterion("first_add_second between", value1, value2, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andFirstAddSecondNotBetween(Integer value1, Integer value2) {
            addCriterion("first_add_second not between", value1, value2, "firstAddSecond");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigIsNull() {
            addCriterion("is_first_second_big is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigIsNotNull() {
            addCriterion("is_first_second_big is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigEqualTo(Boolean value) {
            addCriterion("is_first_second_big =", value, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigNotEqualTo(Boolean value) {
            addCriterion("is_first_second_big <>", value, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigGreaterThan(Boolean value) {
            addCriterion("is_first_second_big >", value, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_first_second_big >=", value, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigLessThan(Boolean value) {
            addCriterion("is_first_second_big <", value, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigLessThanOrEqualTo(Boolean value) {
            addCriterion("is_first_second_big <=", value, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigIn(List<Boolean> values) {
            addCriterion("is_first_second_big in", values, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigNotIn(List<Boolean> values) {
            addCriterion("is_first_second_big not in", values, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigBetween(Boolean value1, Boolean value2) {
            addCriterion("is_first_second_big between", value1, value2, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondBigNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_first_second_big not between", value1, value2, "isFirstSecondBig");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddIsNull() {
            addCriterion("is_first_second_odd is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddIsNotNull() {
            addCriterion("is_first_second_odd is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddEqualTo(Boolean value) {
            addCriterion("is_first_second_odd =", value, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddNotEqualTo(Boolean value) {
            addCriterion("is_first_second_odd <>", value, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddGreaterThan(Boolean value) {
            addCriterion("is_first_second_odd >", value, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_first_second_odd >=", value, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddLessThan(Boolean value) {
            addCriterion("is_first_second_odd <", value, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddLessThanOrEqualTo(Boolean value) {
            addCriterion("is_first_second_odd <=", value, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddIn(List<Boolean> values) {
            addCriterion("is_first_second_odd in", values, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddNotIn(List<Boolean> values) {
            addCriterion("is_first_second_odd not in", values, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddBetween(Boolean value1, Boolean value2) {
            addCriterion("is_first_second_odd between", value1, value2, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstSecondOddNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_first_second_odd not between", value1, value2, "isFirstSecondOdd");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpIsNull() {
            addCriterion("is_first_up is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpIsNotNull() {
            addCriterion("is_first_up is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpEqualTo(Boolean value) {
            addCriterion("is_first_up =", value, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpNotEqualTo(Boolean value) {
            addCriterion("is_first_up <>", value, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpGreaterThan(Boolean value) {
            addCriterion("is_first_up >", value, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_first_up >=", value, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpLessThan(Boolean value) {
            addCriterion("is_first_up <", value, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpLessThanOrEqualTo(Boolean value) {
            addCriterion("is_first_up <=", value, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpIn(List<Boolean> values) {
            addCriterion("is_first_up in", values, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpNotIn(List<Boolean> values) {
            addCriterion("is_first_up not in", values, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpBetween(Boolean value1, Boolean value2) {
            addCriterion("is_first_up between", value1, value2, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsFirstUpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_first_up not between", value1, value2, "isFirstUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpIsNull() {
            addCriterion("is_second_up is null");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpIsNotNull() {
            addCriterion("is_second_up is not null");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpEqualTo(Boolean value) {
            addCriterion("is_second_up =", value, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpNotEqualTo(Boolean value) {
            addCriterion("is_second_up <>", value, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpGreaterThan(Boolean value) {
            addCriterion("is_second_up >", value, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_second_up >=", value, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpLessThan(Boolean value) {
            addCriterion("is_second_up <", value, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpLessThanOrEqualTo(Boolean value) {
            addCriterion("is_second_up <=", value, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpIn(List<Boolean> values) {
            addCriterion("is_second_up in", values, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpNotIn(List<Boolean> values) {
            addCriterion("is_second_up not in", values, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpBetween(Boolean value1, Boolean value2) {
            addCriterion("is_second_up between", value1, value2, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsSecondUpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_second_up not between", value1, value2, "isSecondUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpIsNull() {
            addCriterion("is_third_up is null");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpIsNotNull() {
            addCriterion("is_third_up is not null");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpEqualTo(Boolean value) {
            addCriterion("is_third_up =", value, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpNotEqualTo(Boolean value) {
            addCriterion("is_third_up <>", value, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpGreaterThan(Boolean value) {
            addCriterion("is_third_up >", value, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_third_up >=", value, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpLessThan(Boolean value) {
            addCriterion("is_third_up <", value, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpLessThanOrEqualTo(Boolean value) {
            addCriterion("is_third_up <=", value, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpIn(List<Boolean> values) {
            addCriterion("is_third_up in", values, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpNotIn(List<Boolean> values) {
            addCriterion("is_third_up not in", values, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpBetween(Boolean value1, Boolean value2) {
            addCriterion("is_third_up between", value1, value2, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsThirdUpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_third_up not between", value1, value2, "isThirdUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpIsNull() {
            addCriterion("is_fourth_up is null");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpIsNotNull() {
            addCriterion("is_fourth_up is not null");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpEqualTo(Boolean value) {
            addCriterion("is_fourth_up =", value, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpNotEqualTo(Boolean value) {
            addCriterion("is_fourth_up <>", value, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpGreaterThan(Boolean value) {
            addCriterion("is_fourth_up >", value, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_fourth_up >=", value, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpLessThan(Boolean value) {
            addCriterion("is_fourth_up <", value, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpLessThanOrEqualTo(Boolean value) {
            addCriterion("is_fourth_up <=", value, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpIn(List<Boolean> values) {
            addCriterion("is_fourth_up in", values, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpNotIn(List<Boolean> values) {
            addCriterion("is_fourth_up not in", values, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpBetween(Boolean value1, Boolean value2) {
            addCriterion("is_fourth_up between", value1, value2, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFourthUpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_fourth_up not between", value1, value2, "isFourthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpIsNull() {
            addCriterion("is_fifth_up is null");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpIsNotNull() {
            addCriterion("is_fifth_up is not null");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpEqualTo(Boolean value) {
            addCriterion("is_fifth_up =", value, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpNotEqualTo(Boolean value) {
            addCriterion("is_fifth_up <>", value, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpGreaterThan(Boolean value) {
            addCriterion("is_fifth_up >", value, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_fifth_up >=", value, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpLessThan(Boolean value) {
            addCriterion("is_fifth_up <", value, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpLessThanOrEqualTo(Boolean value) {
            addCriterion("is_fifth_up <=", value, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpIn(List<Boolean> values) {
            addCriterion("is_fifth_up in", values, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpNotIn(List<Boolean> values) {
            addCriterion("is_fifth_up not in", values, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpBetween(Boolean value1, Boolean value2) {
            addCriterion("is_fifth_up between", value1, value2, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsFifthUpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_fifth_up not between", value1, value2, "isFifthUp");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationIsNull() {
            addCriterion("is_complate_calculation is null");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationIsNotNull() {
            addCriterion("is_complate_calculation is not null");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationEqualTo(Boolean value) {
            addCriterion("is_complate_calculation =", value, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationNotEqualTo(Boolean value) {
            addCriterion("is_complate_calculation <>", value, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationGreaterThan(Boolean value) {
            addCriterion("is_complate_calculation >", value, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_complate_calculation >=", value, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationLessThan(Boolean value) {
            addCriterion("is_complate_calculation <", value, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationLessThanOrEqualTo(Boolean value) {
            addCriterion("is_complate_calculation <=", value, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationIn(List<Boolean> values) {
            addCriterion("is_complate_calculation in", values, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationNotIn(List<Boolean> values) {
            addCriterion("is_complate_calculation not in", values, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complate_calculation between", value1, value2, "isComplateCalculation");
            return (Criteria) this;
        }

        public Criteria andIsComplateCalculationNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complate_calculation not between", value1, value2, "isComplateCalculation");
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

        public Criteria andComplateCalculationTimeIsNull() {
            addCriterion("complate_calculation_time is null");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeIsNotNull() {
            addCriterion("complate_calculation_time is not null");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeEqualTo(Date value) {
            addCriterion("complate_calculation_time =", value, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeNotEqualTo(Date value) {
            addCriterion("complate_calculation_time <>", value, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeGreaterThan(Date value) {
            addCriterion("complate_calculation_time >", value, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complate_calculation_time >=", value, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeLessThan(Date value) {
            addCriterion("complate_calculation_time <", value, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeLessThanOrEqualTo(Date value) {
            addCriterion("complate_calculation_time <=", value, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeIn(List<Date> values) {
            addCriterion("complate_calculation_time in", values, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeNotIn(List<Date> values) {
            addCriterion("complate_calculation_time not in", values, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeBetween(Date value1, Date value2) {
            addCriterion("complate_calculation_time between", value1, value2, "complateCalculationTime");
            return (Criteria) this;
        }

        public Criteria andComplateCalculationTimeNotBetween(Date value1, Date value2) {
            addCriterion("complate_calculation_time not between", value1, value2, "complateCalculationTime");
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