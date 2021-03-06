package com.sword.smvcm.users.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMemberExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andUnionIdIsNull() {
            addCriterion("union_id is null");
            return (Criteria) this;
        }

        public Criteria andUnionIdIsNotNull() {
            addCriterion("union_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnionIdEqualTo(String value) {
            addCriterion("union_id =", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotEqualTo(String value) {
            addCriterion("union_id <>", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThan(String value) {
            addCriterion("union_id >", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThanOrEqualTo(String value) {
            addCriterion("union_id >=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThan(String value) {
            addCriterion("union_id <", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThanOrEqualTo(String value) {
            addCriterion("union_id <=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLike(String value) {
            addCriterion("union_id like", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotLike(String value) {
            addCriterion("union_id not like", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdIn(List<String> values) {
            addCriterion("union_id in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotIn(List<String> values) {
            addCriterion("union_id not in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdBetween(String value1, String value2) {
            addCriterion("union_id between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotBetween(String value1, String value2) {
            addCriterion("union_id not between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Boolean value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Boolean value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Boolean value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Boolean value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Boolean value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Boolean> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Boolean> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Boolean value1, Boolean value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andWwIsNull() {
            addCriterion("ww is null");
            return (Criteria) this;
        }

        public Criteria andWwIsNotNull() {
            addCriterion("ww is not null");
            return (Criteria) this;
        }

        public Criteria andWwEqualTo(String value) {
            addCriterion("ww =", value, "ww");
            return (Criteria) this;
        }

        public Criteria andWwNotEqualTo(String value) {
            addCriterion("ww <>", value, "ww");
            return (Criteria) this;
        }

        public Criteria andWwGreaterThan(String value) {
            addCriterion("ww >", value, "ww");
            return (Criteria) this;
        }

        public Criteria andWwGreaterThanOrEqualTo(String value) {
            addCriterion("ww >=", value, "ww");
            return (Criteria) this;
        }

        public Criteria andWwLessThan(String value) {
            addCriterion("ww <", value, "ww");
            return (Criteria) this;
        }

        public Criteria andWwLessThanOrEqualTo(String value) {
            addCriterion("ww <=", value, "ww");
            return (Criteria) this;
        }

        public Criteria andWwLike(String value) {
            addCriterion("ww like", value, "ww");
            return (Criteria) this;
        }

        public Criteria andWwNotLike(String value) {
            addCriterion("ww not like", value, "ww");
            return (Criteria) this;
        }

        public Criteria andWwIn(List<String> values) {
            addCriterion("ww in", values, "ww");
            return (Criteria) this;
        }

        public Criteria andWwNotIn(List<String> values) {
            addCriterion("ww not in", values, "ww");
            return (Criteria) this;
        }

        public Criteria andWwBetween(String value1, String value2) {
            addCriterion("ww between", value1, value2, "ww");
            return (Criteria) this;
        }

        public Criteria andWwNotBetween(String value1, String value2) {
            addCriterion("ww not between", value1, value2, "ww");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andQqopenidIsNull() {
            addCriterion("qqopenid is null");
            return (Criteria) this;
        }

        public Criteria andQqopenidIsNotNull() {
            addCriterion("qqopenid is not null");
            return (Criteria) this;
        }

        public Criteria andQqopenidEqualTo(String value) {
            addCriterion("qqopenid =", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidNotEqualTo(String value) {
            addCriterion("qqopenid <>", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidGreaterThan(String value) {
            addCriterion("qqopenid >", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidGreaterThanOrEqualTo(String value) {
            addCriterion("qqopenid >=", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidLessThan(String value) {
            addCriterion("qqopenid <", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidLessThanOrEqualTo(String value) {
            addCriterion("qqopenid <=", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidLike(String value) {
            addCriterion("qqopenid like", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidNotLike(String value) {
            addCriterion("qqopenid not like", value, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidIn(List<String> values) {
            addCriterion("qqopenid in", values, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidNotIn(List<String> values) {
            addCriterion("qqopenid not in", values, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidBetween(String value1, String value2) {
            addCriterion("qqopenid between", value1, value2, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andQqopenidNotBetween(String value1, String value2) {
            addCriterion("qqopenid not between", value1, value2, "qqopenid");
            return (Criteria) this;
        }

        public Criteria andPointsIsNull() {
            addCriterion("points is null");
            return (Criteria) this;
        }

        public Criteria andPointsIsNotNull() {
            addCriterion("points is not null");
            return (Criteria) this;
        }

        public Criteria andPointsEqualTo(Integer value) {
            addCriterion("points =", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotEqualTo(Integer value) {
            addCriterion("points <>", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThan(Integer value) {
            addCriterion("points >", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("points >=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThan(Integer value) {
            addCriterion("points <", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThanOrEqualTo(Integer value) {
            addCriterion("points <=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsIn(List<Integer> values) {
            addCriterion("points in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotIn(List<Integer> values) {
            addCriterion("points not in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsBetween(Integer value1, Integer value2) {
            addCriterion("points between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("points not between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositIsNull() {
            addCriterion("available_predeposit is null");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositIsNotNull() {
            addCriterion("available_predeposit is not null");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositEqualTo(BigDecimal value) {
            addCriterion("available_predeposit =", value, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositNotEqualTo(BigDecimal value) {
            addCriterion("available_predeposit <>", value, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositGreaterThan(BigDecimal value) {
            addCriterion("available_predeposit >", value, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("available_predeposit >=", value, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositLessThan(BigDecimal value) {
            addCriterion("available_predeposit <", value, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("available_predeposit <=", value, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositIn(List<BigDecimal> values) {
            addCriterion("available_predeposit in", values, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositNotIn(List<BigDecimal> values) {
            addCriterion("available_predeposit not in", values, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_predeposit between", value1, value2, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andAvailablePredepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("available_predeposit not between", value1, value2, "availablePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositIsNull() {
            addCriterion("freeze_predeposit is null");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositIsNotNull() {
            addCriterion("freeze_predeposit is not null");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositEqualTo(BigDecimal value) {
            addCriterion("freeze_predeposit =", value, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositNotEqualTo(BigDecimal value) {
            addCriterion("freeze_predeposit <>", value, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositGreaterThan(BigDecimal value) {
            addCriterion("freeze_predeposit >", value, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freeze_predeposit >=", value, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositLessThan(BigDecimal value) {
            addCriterion("freeze_predeposit <", value, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freeze_predeposit <=", value, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositIn(List<BigDecimal> values) {
            addCriterion("freeze_predeposit in", values, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositNotIn(List<BigDecimal> values) {
            addCriterion("freeze_predeposit not in", values, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freeze_predeposit between", value1, value2, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andFreezePredepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freeze_predeposit not between", value1, value2, "freezePredeposit");
            return (Criteria) this;
        }

        public Criteria andInformAllowIsNull() {
            addCriterion("inform_allow is null");
            return (Criteria) this;
        }

        public Criteria andInformAllowIsNotNull() {
            addCriterion("inform_allow is not null");
            return (Criteria) this;
        }

        public Criteria andInformAllowEqualTo(Boolean value) {
            addCriterion("inform_allow =", value, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowNotEqualTo(Boolean value) {
            addCriterion("inform_allow <>", value, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowGreaterThan(Boolean value) {
            addCriterion("inform_allow >", value, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("inform_allow >=", value, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowLessThan(Boolean value) {
            addCriterion("inform_allow <", value, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowLessThanOrEqualTo(Boolean value) {
            addCriterion("inform_allow <=", value, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowIn(List<Boolean> values) {
            addCriterion("inform_allow in", values, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowNotIn(List<Boolean> values) {
            addCriterion("inform_allow not in", values, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowBetween(Boolean value1, Boolean value2) {
            addCriterion("inform_allow between", value1, value2, "informAllow");
            return (Criteria) this;
        }

        public Criteria andInformAllowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("inform_allow not between", value1, value2, "informAllow");
            return (Criteria) this;
        }

        public Criteria andIsBuyIsNull() {
            addCriterion("is_buy is null");
            return (Criteria) this;
        }

        public Criteria andIsBuyIsNotNull() {
            addCriterion("is_buy is not null");
            return (Criteria) this;
        }

        public Criteria andIsBuyEqualTo(Boolean value) {
            addCriterion("is_buy =", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyNotEqualTo(Boolean value) {
            addCriterion("is_buy <>", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyGreaterThan(Boolean value) {
            addCriterion("is_buy >", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_buy >=", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyLessThan(Boolean value) {
            addCriterion("is_buy <", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_buy <=", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyIn(List<Boolean> values) {
            addCriterion("is_buy in", values, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyNotIn(List<Boolean> values) {
            addCriterion("is_buy not in", values, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_buy between", value1, value2, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_buy not between", value1, value2, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkIsNull() {
            addCriterion("is_allowtalk is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkIsNotNull() {
            addCriterion("is_allowtalk is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkEqualTo(Boolean value) {
            addCriterion("is_allowtalk =", value, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkNotEqualTo(Boolean value) {
            addCriterion("is_allowtalk <>", value, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkGreaterThan(Boolean value) {
            addCriterion("is_allowtalk >", value, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_allowtalk >=", value, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkLessThan(Boolean value) {
            addCriterion("is_allowtalk <", value, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkLessThanOrEqualTo(Boolean value) {
            addCriterion("is_allowtalk <=", value, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkIn(List<Boolean> values) {
            addCriterion("is_allowtalk in", values, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkNotIn(List<Boolean> values) {
            addCriterion("is_allowtalk not in", values, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allowtalk between", value1, value2, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsAllowtalkNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allowtalk not between", value1, value2, "isAllowtalk");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNull() {
            addCriterion("is_vip is null");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNotNull() {
            addCriterion("is_vip is not null");
            return (Criteria) this;
        }

        public Criteria andIsVipEqualTo(Boolean value) {
            addCriterion("is_vip =", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotEqualTo(Boolean value) {
            addCriterion("is_vip <>", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThan(Boolean value) {
            addCriterion("is_vip >", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_vip >=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThan(Boolean value) {
            addCriterion("is_vip <", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThanOrEqualTo(Boolean value) {
            addCriterion("is_vip <=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipIn(List<Boolean> values) {
            addCriterion("is_vip in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotIn(List<Boolean> values) {
            addCriterion("is_vip not in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipBetween(Boolean value1, Boolean value2) {
            addCriterion("is_vip between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_vip not between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andAreaDIsNull() {
            addCriterion("area_d is null");
            return (Criteria) this;
        }

        public Criteria andAreaDIsNotNull() {
            addCriterion("area_d is not null");
            return (Criteria) this;
        }

        public Criteria andAreaDEqualTo(Integer value) {
            addCriterion("area_d =", value, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDNotEqualTo(Integer value) {
            addCriterion("area_d <>", value, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDGreaterThan(Integer value) {
            addCriterion("area_d >", value, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_d >=", value, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDLessThan(Integer value) {
            addCriterion("area_d <", value, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDLessThanOrEqualTo(Integer value) {
            addCriterion("area_d <=", value, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDIn(List<Integer> values) {
            addCriterion("area_d in", values, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDNotIn(List<Integer> values) {
            addCriterion("area_d not in", values, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDBetween(Integer value1, Integer value2) {
            addCriterion("area_d between", value1, value2, "areaD");
            return (Criteria) this;
        }

        public Criteria andAreaDNotBetween(Integer value1, Integer value2) {
            addCriterion("area_d not between", value1, value2, "areaD");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andAreainfoIsNull() {
            addCriterion("areainfo is null");
            return (Criteria) this;
        }

        public Criteria andAreainfoIsNotNull() {
            addCriterion("areainfo is not null");
            return (Criteria) this;
        }

        public Criteria andAreainfoEqualTo(String value) {
            addCriterion("areainfo =", value, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoNotEqualTo(String value) {
            addCriterion("areainfo <>", value, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoGreaterThan(String value) {
            addCriterion("areainfo >", value, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoGreaterThanOrEqualTo(String value) {
            addCriterion("areainfo >=", value, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoLessThan(String value) {
            addCriterion("areainfo <", value, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoLessThanOrEqualTo(String value) {
            addCriterion("areainfo <=", value, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoLike(String value) {
            addCriterion("areainfo like", value, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoNotLike(String value) {
            addCriterion("areainfo not like", value, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoIn(List<String> values) {
            addCriterion("areainfo in", values, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoNotIn(List<String> values) {
            addCriterion("areainfo not in", values, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoBetween(String value1, String value2) {
            addCriterion("areainfo between", value1, value2, "areainfo");
            return (Criteria) this;
        }

        public Criteria andAreainfoNotBetween(String value1, String value2) {
            addCriterion("areainfo not between", value1, value2, "areainfo");
            return (Criteria) this;
        }

        public Criteria andPrivacyIsNull() {
            addCriterion("privacy is null");
            return (Criteria) this;
        }

        public Criteria andPrivacyIsNotNull() {
            addCriterion("privacy is not null");
            return (Criteria) this;
        }

        public Criteria andPrivacyEqualTo(String value) {
            addCriterion("privacy =", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyNotEqualTo(String value) {
            addCriterion("privacy <>", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyGreaterThan(String value) {
            addCriterion("privacy >", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyGreaterThanOrEqualTo(String value) {
            addCriterion("privacy >=", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyLessThan(String value) {
            addCriterion("privacy <", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyLessThanOrEqualTo(String value) {
            addCriterion("privacy <=", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyLike(String value) {
            addCriterion("privacy like", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyNotLike(String value) {
            addCriterion("privacy not like", value, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyIn(List<String> values) {
            addCriterion("privacy in", values, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyNotIn(List<String> values) {
            addCriterion("privacy not in", values, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyBetween(String value1, String value2) {
            addCriterion("privacy between", value1, value2, "privacy");
            return (Criteria) this;
        }

        public Criteria andPrivacyNotBetween(String value1, String value2) {
            addCriterion("privacy not between", value1, value2, "privacy");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNull() {
            addCriterion("access_token is null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIsNotNull() {
            addCriterion("access_token is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTokenEqualTo(String value) {
            addCriterion("access_token =", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotEqualTo(String value) {
            addCriterion("access_token <>", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThan(String value) {
            addCriterion("access_token >", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("access_token >=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThan(String value) {
            addCriterion("access_token <", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("access_token <=", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenLike(String value) {
            addCriterion("access_token like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotLike(String value) {
            addCriterion("access_token not like", value, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenIn(List<String> values) {
            addCriterion("access_token in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotIn(List<String> values) {
            addCriterion("access_token not in", values, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenBetween(String value1, String value2) {
            addCriterion("access_token between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andAccessTokenNotBetween(String value1, String value2) {
            addCriterion("access_token not between", value1, value2, "accessToken");
            return (Criteria) this;
        }

        public Criteria andExpiresInIsNull() {
            addCriterion("expires_in is null");
            return (Criteria) this;
        }

        public Criteria andExpiresInIsNotNull() {
            addCriterion("expires_in is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresInEqualTo(Integer value) {
            addCriterion("expires_in =", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotEqualTo(Integer value) {
            addCriterion("expires_in <>", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInGreaterThan(Integer value) {
            addCriterion("expires_in >", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInGreaterThanOrEqualTo(Integer value) {
            addCriterion("expires_in >=", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInLessThan(Integer value) {
            addCriterion("expires_in <", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInLessThanOrEqualTo(Integer value) {
            addCriterion("expires_in <=", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInIn(List<Integer> values) {
            addCriterion("expires_in in", values, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotIn(List<Integer> values) {
            addCriterion("expires_in not in", values, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInBetween(Integer value1, Integer value2) {
            addCriterion("expires_in between", value1, value2, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotBetween(Integer value1, Integer value2) {
            addCriterion("expires_in not between", value1, value2, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNull() {
            addCriterion("refresh_token is null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNotNull() {
            addCriterion("refresh_token is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenEqualTo(String value) {
            addCriterion("refresh_token =", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotEqualTo(String value) {
            addCriterion("refresh_token <>", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThan(String value) {
            addCriterion("refresh_token >", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            addCriterion("refresh_token >=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThan(String value) {
            addCriterion("refresh_token <", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            addCriterion("refresh_token <=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLike(String value) {
            addCriterion("refresh_token like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotLike(String value) {
            addCriterion("refresh_token not like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIn(List<String> values) {
            addCriterion("refresh_token in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotIn(List<String> values) {
            addCriterion("refresh_token not in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenBetween(String value1, String value2) {
            addCriterion("refresh_token between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotBetween(String value1, String value2) {
            addCriterion("refresh_token not between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(String value) {
            addCriterion("scope =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(String value) {
            addCriterion("scope <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(String value) {
            addCriterion("scope >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(String value) {
            addCriterion("scope >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(String value) {
            addCriterion("scope <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(String value) {
            addCriterion("scope <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLike(String value) {
            addCriterion("scope like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotLike(String value) {
            addCriterion("scope not like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<String> values) {
            addCriterion("scope in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<String> values) {
            addCriterion("scope not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(String value1, String value2) {
            addCriterion("scope between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(String value1, String value2) {
            addCriterion("scope not between", value1, value2, "scope");
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