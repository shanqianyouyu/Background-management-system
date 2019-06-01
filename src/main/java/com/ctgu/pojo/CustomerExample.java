package com.ctgu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;//排序

    protected boolean distinct;//限制

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCnumIsNull() {
            addCriterion("Cnum is null");
            return (Criteria) this;
        }

        public Criteria andCnumIsNotNull() {
            addCriterion("Cnum is not null");
            return (Criteria) this;
        }

        public Criteria andCnumEqualTo(String value) {
            addCriterion("Cnum =", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotEqualTo(String value) {
            addCriterion("Cnum <>", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumGreaterThan(String value) {
            addCriterion("Cnum >", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumGreaterThanOrEqualTo(String value) {
            addCriterion("Cnum >=", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumLessThan(String value) {
            addCriterion("Cnum <", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumLessThanOrEqualTo(String value) {
            addCriterion("Cnum <=", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumLike(String value) {
            addCriterion("Cnum like", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotLike(String value) {
            addCriterion("Cnum not like", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumIn(List<String> values) {
            addCriterion("Cnum in", values, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotIn(List<String> values) {
            addCriterion("Cnum not in", values, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumBetween(String value1, String value2) {
            addCriterion("Cnum between", value1, value2, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotBetween(String value1, String value2) {
            addCriterion("Cnum not between", value1, value2, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("Cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("Cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("Cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("Cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("Cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("Cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("Cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("Cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("Cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("Cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("Cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("Cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("Cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("Cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnumberIsNull() {
            addCriterion("Cnumber is null");
            return (Criteria) this;
        }

        public Criteria andCnumberIsNotNull() {
            addCriterion("Cnumber is not null");
            return (Criteria) this;
        }

        public Criteria andCnumberEqualTo(String value) {
            addCriterion("Cnumber =", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberNotEqualTo(String value) {
            addCriterion("Cnumber <>", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberGreaterThan(String value) {
            addCriterion("Cnumber >", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberGreaterThanOrEqualTo(String value) {
            addCriterion("Cnumber >=", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberLessThan(String value) {
            addCriterion("Cnumber <", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberLessThanOrEqualTo(String value) {
            addCriterion("Cnumber <=", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberLike(String value) {
            addCriterion("Cnumber like", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberNotLike(String value) {
            addCriterion("Cnumber not like", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberIn(List<String> values) {
            addCriterion("Cnumber in", values, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberNotIn(List<String> values) {
            addCriterion("Cnumber not in", values, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberBetween(String value1, String value2) {
            addCriterion("Cnumber between", value1, value2, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberNotBetween(String value1, String value2) {
            addCriterion("Cnumber not between", value1, value2, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCaddrIsNull() {
            addCriterion("Caddr is null");
            return (Criteria) this;
        }

        public Criteria andCaddrIsNotNull() {
            addCriterion("Caddr is not null");
            return (Criteria) this;
        }

        public Criteria andCaddrEqualTo(String value) {
            addCriterion("Caddr =", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrNotEqualTo(String value) {
            addCriterion("Caddr <>", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrGreaterThan(String value) {
            addCriterion("Caddr >", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrGreaterThanOrEqualTo(String value) {
            addCriterion("Caddr >=", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrLessThan(String value) {
            addCriterion("Caddr <", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrLessThanOrEqualTo(String value) {
            addCriterion("Caddr <=", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrLike(String value) {
            addCriterion("Caddr like", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrNotLike(String value) {
            addCriterion("Caddr not like", value, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrIn(List<String> values) {
            addCriterion("Caddr in", values, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrNotIn(List<String> values) {
            addCriterion("Caddr not in", values, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrBetween(String value1, String value2) {
            addCriterion("Caddr between", value1, value2, "caddr");
            return (Criteria) this;
        }

        public Criteria andCaddrNotBetween(String value1, String value2) {
            addCriterion("Caddr not between", value1, value2, "caddr");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCemailIsNull() {
            addCriterion("Cemail is null");
            return (Criteria) this;
        }

        public Criteria andCemailIsNotNull() {
            addCriterion("Cemail is not null");
            return (Criteria) this;
        }

        public Criteria andCemailEqualTo(String value) {
            addCriterion("Cemail =", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailNotEqualTo(String value) {
            addCriterion("Cemail <>", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailGreaterThan(String value) {
            addCriterion("Cemail >", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailGreaterThanOrEqualTo(String value) {
            addCriterion("Cemail >=", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailLessThan(String value) {
            addCriterion("Cemail <", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailLessThanOrEqualTo(String value) {
            addCriterion("Cemail <=", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailLike(String value) {
            addCriterion("Cemail like", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailNotLike(String value) {
            addCriterion("Cemail not like", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailIn(List<String> values) {
            addCriterion("Cemail in", values, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailNotIn(List<String> values) {
            addCriterion("Cemail not in", values, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailBetween(String value1, String value2) {
            addCriterion("Cemail between", value1, value2, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailNotBetween(String value1, String value2) {
            addCriterion("Cemail not between", value1, value2, "cemail");
            return (Criteria) this;
        }

        public Criteria andCrankIsNull() {
            addCriterion("Crank is null");
            return (Criteria) this;
        }

        public Criteria andCrankIsNotNull() {
            addCriterion("Crank is not null");
            return (Criteria) this;
        }

        public Criteria andCrankEqualTo(String value) {
            addCriterion("Crank =", value, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankNotEqualTo(String value) {
            addCriterion("Crank <>", value, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankGreaterThan(String value) {
            addCriterion("Crank >", value, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankGreaterThanOrEqualTo(String value) {
            addCriterion("Crank >=", value, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankLessThan(String value) {
            addCriterion("Crank <", value, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankLessThanOrEqualTo(String value) {
            addCriterion("Crank <=", value, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankLike(String value) {
            addCriterion("Crank like", value, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankNotLike(String value) {
            addCriterion("Crank not like", value, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankIn(List<String> values) {
            addCriterion("Crank in", values, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankNotIn(List<String> values) {
            addCriterion("Crank not in", values, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankBetween(String value1, String value2) {
            addCriterion("Crank between", value1, value2, "crank");
            return (Criteria) this;
        }

        public Criteria andCrankNotBetween(String value1, String value2) {
            addCriterion("Crank not between", value1, value2, "crank");
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