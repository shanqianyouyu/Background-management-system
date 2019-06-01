package com.ctgu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierExample() {
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

        public Criteria andSnumIsNull() {
            addCriterion("Snum is null");
            return (Criteria) this;
        }

        public Criteria andSnumIsNotNull() {
            addCriterion("Snum is not null");
            return (Criteria) this;
        }

        public Criteria andSnumEqualTo(String value) {
            addCriterion("Snum =", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotEqualTo(String value) {
            addCriterion("Snum <>", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThan(String value) {
            addCriterion("Snum >", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThanOrEqualTo(String value) {
            addCriterion("Snum >=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThan(String value) {
            addCriterion("Snum <", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThanOrEqualTo(String value) {
            addCriterion("Snum <=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLike(String value) {
            addCriterion("Snum like", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotLike(String value) {
            addCriterion("Snum not like", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumIn(List<String> values) {
            addCriterion("Snum in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotIn(List<String> values) {
            addCriterion("Snum not in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumBetween(String value1, String value2) {
            addCriterion("Snum between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotBetween(String value1, String value2) {
            addCriterion("Snum not between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("Sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("Sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("Sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("Sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("Sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("Sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("Sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("Sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("Sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("Sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("Sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("Sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("Sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("Sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSaddrIsNull() {
            addCriterion("Saddr is null");
            return (Criteria) this;
        }

        public Criteria andSaddrIsNotNull() {
            addCriterion("Saddr is not null");
            return (Criteria) this;
        }

        public Criteria andSaddrEqualTo(String value) {
            addCriterion("Saddr =", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrNotEqualTo(String value) {
            addCriterion("Saddr <>", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrGreaterThan(String value) {
            addCriterion("Saddr >", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrGreaterThanOrEqualTo(String value) {
            addCriterion("Saddr >=", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrLessThan(String value) {
            addCriterion("Saddr <", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrLessThanOrEqualTo(String value) {
            addCriterion("Saddr <=", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrLike(String value) {
            addCriterion("Saddr like", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrNotLike(String value) {
            addCriterion("Saddr not like", value, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrIn(List<String> values) {
            addCriterion("Saddr in", values, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrNotIn(List<String> values) {
            addCriterion("Saddr not in", values, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrBetween(String value1, String value2) {
            addCriterion("Saddr between", value1, value2, "saddr");
            return (Criteria) this;
        }

        public Criteria andSaddrNotBetween(String value1, String value2) {
            addCriterion("Saddr not between", value1, value2, "saddr");
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

        public Criteria andSnumberIsNull() {
            addCriterion("Snumber is null");
            return (Criteria) this;
        }

        public Criteria andSnumberIsNotNull() {
            addCriterion("Snumber is not null");
            return (Criteria) this;
        }

        public Criteria andSnumberEqualTo(String value) {
            addCriterion("Snumber =", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotEqualTo(String value) {
            addCriterion("Snumber <>", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberGreaterThan(String value) {
            addCriterion("Snumber >", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberGreaterThanOrEqualTo(String value) {
            addCriterion("Snumber >=", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLessThan(String value) {
            addCriterion("Snumber <", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLessThanOrEqualTo(String value) {
            addCriterion("Snumber <=", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLike(String value) {
            addCriterion("Snumber like", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotLike(String value) {
            addCriterion("Snumber not like", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberIn(List<String> values) {
            addCriterion("Snumber in", values, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotIn(List<String> values) {
            addCriterion("Snumber not in", values, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberBetween(String value1, String value2) {
            addCriterion("Snumber between", value1, value2, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotBetween(String value1, String value2) {
            addCriterion("Snumber not between", value1, value2, "snumber");
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