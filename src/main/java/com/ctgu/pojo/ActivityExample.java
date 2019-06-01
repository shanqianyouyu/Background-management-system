package com.ctgu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andAitemIsNull() {
            addCriterion("Aitem is null");
            return (Criteria) this;
        }

        public Criteria andAitemIsNotNull() {
            addCriterion("Aitem is not null");
            return (Criteria) this;
        }

        public Criteria andAitemEqualTo(String value) {
            addCriterion("Aitem =", value, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemNotEqualTo(String value) {
            addCriterion("Aitem <>", value, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemGreaterThan(String value) {
            addCriterion("Aitem >", value, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemGreaterThanOrEqualTo(String value) {
            addCriterion("Aitem >=", value, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemLessThan(String value) {
            addCriterion("Aitem <", value, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemLessThanOrEqualTo(String value) {
            addCriterion("Aitem <=", value, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemLike(String value) {
            addCriterion("Aitem like", value, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemNotLike(String value) {
            addCriterion("Aitem not like", value, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemIn(List<String> values) {
            addCriterion("Aitem in", values, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemNotIn(List<String> values) {
            addCriterion("Aitem not in", values, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemBetween(String value1, String value2) {
            addCriterion("Aitem between", value1, value2, "aitem");
            return (Criteria) this;
        }

        public Criteria andAitemNotBetween(String value1, String value2) {
            addCriterion("Aitem not between", value1, value2, "aitem");
            return (Criteria) this;
        }

        public Criteria andAdetailIsNull() {
            addCriterion("Adetail is null");
            return (Criteria) this;
        }

        public Criteria andAdetailIsNotNull() {
            addCriterion("Adetail is not null");
            return (Criteria) this;
        }

        public Criteria andAdetailEqualTo(String value) {
            addCriterion("Adetail =", value, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailNotEqualTo(String value) {
            addCriterion("Adetail <>", value, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailGreaterThan(String value) {
            addCriterion("Adetail >", value, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailGreaterThanOrEqualTo(String value) {
            addCriterion("Adetail >=", value, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailLessThan(String value) {
            addCriterion("Adetail <", value, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailLessThanOrEqualTo(String value) {
            addCriterion("Adetail <=", value, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailLike(String value) {
            addCriterion("Adetail like", value, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailNotLike(String value) {
            addCriterion("Adetail not like", value, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailIn(List<String> values) {
            addCriterion("Adetail in", values, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailNotIn(List<String> values) {
            addCriterion("Adetail not in", values, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailBetween(String value1, String value2) {
            addCriterion("Adetail between", value1, value2, "adetail");
            return (Criteria) this;
        }

        public Criteria andAdetailNotBetween(String value1, String value2) {
            addCriterion("Adetail not between", value1, value2, "adetail");
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

        public Criteria andUidIsNull() {
            addCriterion("Uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("Uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("Uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("Uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("Uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("Uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("Uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("Uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("Uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("Uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("Uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCusIsNull() {
            addCriterion("Cus is null");
            return (Criteria) this;
        }

        public Criteria andCusIsNotNull() {
            addCriterion("Cus is not null");
            return (Criteria) this;
        }

        public Criteria andCusEqualTo(String value) {
            addCriterion("Cus =", value, "cus");
            return (Criteria) this;
        }

        public Criteria andCusNotEqualTo(String value) {
            addCriterion("Cus <>", value, "cus");
            return (Criteria) this;
        }

        public Criteria andCusGreaterThan(String value) {
            addCriterion("Cus >", value, "cus");
            return (Criteria) this;
        }

        public Criteria andCusGreaterThanOrEqualTo(String value) {
            addCriterion("Cus >=", value, "cus");
            return (Criteria) this;
        }

        public Criteria andCusLessThan(String value) {
            addCriterion("Cus <", value, "cus");
            return (Criteria) this;
        }

        public Criteria andCusLessThanOrEqualTo(String value) {
            addCriterion("Cus <=", value, "cus");
            return (Criteria) this;
        }

        public Criteria andCusLike(String value) {
            addCriterion("Cus like", value, "cus");
            return (Criteria) this;
        }

        public Criteria andCusNotLike(String value) {
            addCriterion("Cus not like", value, "cus");
            return (Criteria) this;
        }

        public Criteria andCusIn(List<String> values) {
            addCriterion("Cus in", values, "cus");
            return (Criteria) this;
        }

        public Criteria andCusNotIn(List<String> values) {
            addCriterion("Cus not in", values, "cus");
            return (Criteria) this;
        }

        public Criteria andCusBetween(String value1, String value2) {
            addCriterion("Cus between", value1, value2, "cus");
            return (Criteria) this;
        }

        public Criteria andCusNotBetween(String value1, String value2) {
            addCriterion("Cus not between", value1, value2, "cus");
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