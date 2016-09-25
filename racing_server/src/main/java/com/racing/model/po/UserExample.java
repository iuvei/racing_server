package com.racing.model.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andTotalPointsIsNull() {
            addCriterion("total_points is null");
            return (Criteria) this;
        }

        public Criteria andTotalPointsIsNotNull() {
            addCriterion("total_points is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPointsEqualTo(BigDecimal value) {
            addCriterion("total_points =", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsNotEqualTo(BigDecimal value) {
            addCriterion("total_points <>", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsGreaterThan(BigDecimal value) {
            addCriterion("total_points >", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_points >=", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsLessThan(BigDecimal value) {
            addCriterion("total_points <", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_points <=", value, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsIn(List<BigDecimal> values) {
            addCriterion("total_points in", values, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsNotIn(List<BigDecimal> values) {
            addCriterion("total_points not in", values, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_points between", value1, value2, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andTotalPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_points not between", value1, value2, "totalPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsIsNull() {
            addCriterion("user_points is null");
            return (Criteria) this;
        }

        public Criteria andUserPointsIsNotNull() {
            addCriterion("user_points is not null");
            return (Criteria) this;
        }

        public Criteria andUserPointsEqualTo(BigDecimal value) {
            addCriterion("user_points =", value, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsNotEqualTo(BigDecimal value) {
            addCriterion("user_points <>", value, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsGreaterThan(BigDecimal value) {
            addCriterion("user_points >", value, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_points >=", value, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsLessThan(BigDecimal value) {
            addCriterion("user_points <", value, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_points <=", value, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsIn(List<BigDecimal> values) {
            addCriterion("user_points in", values, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsNotIn(List<BigDecimal> values) {
            addCriterion("user_points not in", values, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_points between", value1, value2, "userPoints");
            return (Criteria) this;
        }

        public Criteria andUserPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_points not between", value1, value2, "userPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsIsNull() {
            addCriterion("members_points is null");
            return (Criteria) this;
        }

        public Criteria andMembersPointsIsNotNull() {
            addCriterion("members_points is not null");
            return (Criteria) this;
        }

        public Criteria andMembersPointsEqualTo(BigDecimal value) {
            addCriterion("members_points =", value, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsNotEqualTo(BigDecimal value) {
            addCriterion("members_points <>", value, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsGreaterThan(BigDecimal value) {
            addCriterion("members_points >", value, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("members_points >=", value, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsLessThan(BigDecimal value) {
            addCriterion("members_points <", value, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("members_points <=", value, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsIn(List<BigDecimal> values) {
            addCriterion("members_points in", values, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsNotIn(List<BigDecimal> values) {
            addCriterion("members_points not in", values, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("members_points between", value1, value2, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andMembersPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("members_points not between", value1, value2, "membersPoints");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("last_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("last_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("last_login_ip =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("last_login_ip <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("last_login_ip >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ip >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("last_login_ip <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("last_login_ip <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("last_login_ip like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("last_login_ip not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("last_login_ip in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("last_login_ip not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
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

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Boolean value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Boolean value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Boolean value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Boolean value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Boolean value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Boolean> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Boolean> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andClientSnIsNull() {
            addCriterion("client_sn is null");
            return (Criteria) this;
        }

        public Criteria andClientSnIsNotNull() {
            addCriterion("client_sn is not null");
            return (Criteria) this;
        }

        public Criteria andClientSnEqualTo(String value) {
            addCriterion("client_sn =", value, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnNotEqualTo(String value) {
            addCriterion("client_sn <>", value, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnGreaterThan(String value) {
            addCriterion("client_sn >", value, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnGreaterThanOrEqualTo(String value) {
            addCriterion("client_sn >=", value, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnLessThan(String value) {
            addCriterion("client_sn <", value, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnLessThanOrEqualTo(String value) {
            addCriterion("client_sn <=", value, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnLike(String value) {
            addCriterion("client_sn like", value, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnNotLike(String value) {
            addCriterion("client_sn not like", value, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnIn(List<String> values) {
            addCriterion("client_sn in", values, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnNotIn(List<String> values) {
            addCriterion("client_sn not in", values, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnBetween(String value1, String value2) {
            addCriterion("client_sn between", value1, value2, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientSnNotBetween(String value1, String value2) {
            addCriterion("client_sn not between", value1, value2, "clientSn");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateIsNull() {
            addCriterion("client_expire_date is null");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateIsNotNull() {
            addCriterion("client_expire_date is not null");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateEqualTo(Date value) {
            addCriterion("client_expire_date =", value, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateNotEqualTo(Date value) {
            addCriterion("client_expire_date <>", value, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateGreaterThan(Date value) {
            addCriterion("client_expire_date >", value, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterion("client_expire_date >=", value, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateLessThan(Date value) {
            addCriterion("client_expire_date <", value, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateLessThanOrEqualTo(Date value) {
            addCriterion("client_expire_date <=", value, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateIn(List<Date> values) {
            addCriterion("client_expire_date in", values, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateNotIn(List<Date> values) {
            addCriterion("client_expire_date not in", values, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateBetween(Date value1, Date value2) {
            addCriterion("client_expire_date between", value1, value2, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientExpireDateNotBetween(Date value1, Date value2) {
            addCriterion("client_expire_date not between", value1, value2, "clientExpireDate");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableIsNull() {
            addCriterion("client_is_enable is null");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableIsNotNull() {
            addCriterion("client_is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableEqualTo(Boolean value) {
            addCriterion("client_is_enable =", value, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableNotEqualTo(Boolean value) {
            addCriterion("client_is_enable <>", value, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableGreaterThan(Boolean value) {
            addCriterion("client_is_enable >", value, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("client_is_enable >=", value, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableLessThan(Boolean value) {
            addCriterion("client_is_enable <", value, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableLessThanOrEqualTo(Boolean value) {
            addCriterion("client_is_enable <=", value, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableIn(List<Boolean> values) {
            addCriterion("client_is_enable in", values, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableNotIn(List<Boolean> values) {
            addCriterion("client_is_enable not in", values, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableBetween(Boolean value1, Boolean value2) {
            addCriterion("client_is_enable between", value1, value2, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andClientIsEnableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("client_is_enable not between", value1, value2, "clientIsEnable");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyIsNull() {
            addCriterion("web_security_key is null");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyIsNotNull() {
            addCriterion("web_security_key is not null");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyEqualTo(String value) {
            addCriterion("web_security_key =", value, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyNotEqualTo(String value) {
            addCriterion("web_security_key <>", value, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyGreaterThan(String value) {
            addCriterion("web_security_key >", value, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyGreaterThanOrEqualTo(String value) {
            addCriterion("web_security_key >=", value, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyLessThan(String value) {
            addCriterion("web_security_key <", value, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyLessThanOrEqualTo(String value) {
            addCriterion("web_security_key <=", value, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyLike(String value) {
            addCriterion("web_security_key like", value, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyNotLike(String value) {
            addCriterion("web_security_key not like", value, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyIn(List<String> values) {
            addCriterion("web_security_key in", values, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyNotIn(List<String> values) {
            addCriterion("web_security_key not in", values, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyBetween(String value1, String value2) {
            addCriterion("web_security_key between", value1, value2, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebSecurityKeyNotBetween(String value1, String value2) {
            addCriterion("web_security_key not between", value1, value2, "webSecurityKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyIsNull() {
            addCriterion("web_access_key is null");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyIsNotNull() {
            addCriterion("web_access_key is not null");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyEqualTo(String value) {
            addCriterion("web_access_key =", value, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyNotEqualTo(String value) {
            addCriterion("web_access_key <>", value, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyGreaterThan(String value) {
            addCriterion("web_access_key >", value, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("web_access_key >=", value, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyLessThan(String value) {
            addCriterion("web_access_key <", value, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyLessThanOrEqualTo(String value) {
            addCriterion("web_access_key <=", value, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyLike(String value) {
            addCriterion("web_access_key like", value, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyNotLike(String value) {
            addCriterion("web_access_key not like", value, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyIn(List<String> values) {
            addCriterion("web_access_key in", values, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyNotIn(List<String> values) {
            addCriterion("web_access_key not in", values, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyBetween(String value1, String value2) {
            addCriterion("web_access_key between", value1, value2, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebAccessKeyNotBetween(String value1, String value2) {
            addCriterion("web_access_key not between", value1, value2, "webAccessKey");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeIsNull() {
            addCriterion("web_out_time is null");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeIsNotNull() {
            addCriterion("web_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeEqualTo(Date value) {
            addCriterion("web_out_time =", value, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeNotEqualTo(Date value) {
            addCriterion("web_out_time <>", value, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeGreaterThan(Date value) {
            addCriterion("web_out_time >", value, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("web_out_time >=", value, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeLessThan(Date value) {
            addCriterion("web_out_time <", value, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("web_out_time <=", value, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeIn(List<Date> values) {
            addCriterion("web_out_time in", values, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeNotIn(List<Date> values) {
            addCriterion("web_out_time not in", values, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeBetween(Date value1, Date value2) {
            addCriterion("web_out_time between", value1, value2, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andWebOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("web_out_time not between", value1, value2, "webOutTime");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyIsNull() {
            addCriterion("client_security_key is null");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyIsNotNull() {
            addCriterion("client_security_key is not null");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyEqualTo(String value) {
            addCriterion("client_security_key =", value, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyNotEqualTo(String value) {
            addCriterion("client_security_key <>", value, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyGreaterThan(String value) {
            addCriterion("client_security_key >", value, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyGreaterThanOrEqualTo(String value) {
            addCriterion("client_security_key >=", value, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyLessThan(String value) {
            addCriterion("client_security_key <", value, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyLessThanOrEqualTo(String value) {
            addCriterion("client_security_key <=", value, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyLike(String value) {
            addCriterion("client_security_key like", value, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyNotLike(String value) {
            addCriterion("client_security_key not like", value, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyIn(List<String> values) {
            addCriterion("client_security_key in", values, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyNotIn(List<String> values) {
            addCriterion("client_security_key not in", values, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyBetween(String value1, String value2) {
            addCriterion("client_security_key between", value1, value2, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientSecurityKeyNotBetween(String value1, String value2) {
            addCriterion("client_security_key not between", value1, value2, "clientSecurityKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyIsNull() {
            addCriterion("client_access_key is null");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyIsNotNull() {
            addCriterion("client_access_key is not null");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyEqualTo(String value) {
            addCriterion("client_access_key =", value, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyNotEqualTo(String value) {
            addCriterion("client_access_key <>", value, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyGreaterThan(String value) {
            addCriterion("client_access_key >", value, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("client_access_key >=", value, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyLessThan(String value) {
            addCriterion("client_access_key <", value, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyLessThanOrEqualTo(String value) {
            addCriterion("client_access_key <=", value, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyLike(String value) {
            addCriterion("client_access_key like", value, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyNotLike(String value) {
            addCriterion("client_access_key not like", value, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyIn(List<String> values) {
            addCriterion("client_access_key in", values, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyNotIn(List<String> values) {
            addCriterion("client_access_key not in", values, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyBetween(String value1, String value2) {
            addCriterion("client_access_key between", value1, value2, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientAccessKeyNotBetween(String value1, String value2) {
            addCriterion("client_access_key not between", value1, value2, "clientAccessKey");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeIsNull() {
            addCriterion("client_out_time is null");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeIsNotNull() {
            addCriterion("client_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeEqualTo(Date value) {
            addCriterion("client_out_time =", value, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeNotEqualTo(Date value) {
            addCriterion("client_out_time <>", value, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeGreaterThan(Date value) {
            addCriterion("client_out_time >", value, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("client_out_time >=", value, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeLessThan(Date value) {
            addCriterion("client_out_time <", value, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("client_out_time <=", value, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeIn(List<Date> values) {
            addCriterion("client_out_time in", values, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeNotIn(List<Date> values) {
            addCriterion("client_out_time not in", values, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeBetween(Date value1, Date value2) {
            addCriterion("client_out_time between", value1, value2, "clientOutTime");
            return (Criteria) this;
        }

        public Criteria andClientOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("client_out_time not between", value1, value2, "clientOutTime");
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