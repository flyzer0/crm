package com.qy.crm.data.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectInfoExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTableIsNull() {
            addCriterion("table is null");
            return (Criteria) this;
        }

        public Criteria andTableIsNotNull() {
            addCriterion("table is not null");
            return (Criteria) this;
        }

        public Criteria andTableEqualTo(String value) {
            addCriterion("table =", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotEqualTo(String value) {
            addCriterion("table <>", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableGreaterThan(String value) {
            addCriterion("table >", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableGreaterThanOrEqualTo(String value) {
            addCriterion("table >=", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableLessThan(String value) {
            addCriterion("table <", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableLessThanOrEqualTo(String value) {
            addCriterion("table <=", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableLike(String value) {
            addCriterion("table like", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotLike(String value) {
            addCriterion("table not like", value, "table");
            return (Criteria) this;
        }

        public Criteria andTableIn(List<String> values) {
            addCriterion("table in", values, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotIn(List<String> values) {
            addCriterion("table not in", values, "table");
            return (Criteria) this;
        }

        public Criteria andTableBetween(String value1, String value2) {
            addCriterion("table between", value1, value2, "table");
            return (Criteria) this;
        }

        public Criteria andTableNotBetween(String value1, String value2) {
            addCriterion("table not between", value1, value2, "table");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(String value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(String value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(String value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(String value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(String value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLike(String value) {
            addCriterion("record_id like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotLike(String value) {
            addCriterion("record_id not like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<String> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<String> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(String value1, String value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(String value1, String value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdIsNull() {
            addCriterion("record_es_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdIsNotNull() {
            addCriterion("record_es_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdEqualTo(String value) {
            addCriterion("record_es_id =", value, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdNotEqualTo(String value) {
            addCriterion("record_es_id <>", value, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdGreaterThan(String value) {
            addCriterion("record_es_id >", value, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdGreaterThanOrEqualTo(String value) {
            addCriterion("record_es_id >=", value, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdLessThan(String value) {
            addCriterion("record_es_id <", value, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdLessThanOrEqualTo(String value) {
            addCriterion("record_es_id <=", value, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdLike(String value) {
            addCriterion("record_es_id like", value, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdNotLike(String value) {
            addCriterion("record_es_id not like", value, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdIn(List<String> values) {
            addCriterion("record_es_id in", values, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdNotIn(List<String> values) {
            addCriterion("record_es_id not in", values, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdBetween(String value1, String value2) {
            addCriterion("record_es_id between", value1, value2, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andRecordEsIdNotBetween(String value1, String value2) {
            addCriterion("record_es_id not between", value1, value2, "recordEsId");
            return (Criteria) this;
        }

        public Criteria andSelectRatingIsNull() {
            addCriterion("select_rating is null");
            return (Criteria) this;
        }

        public Criteria andSelectRatingIsNotNull() {
            addCriterion("select_rating is not null");
            return (Criteria) this;
        }

        public Criteria andSelectRatingEqualTo(Integer value) {
            addCriterion("select_rating =", value, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingNotEqualTo(Integer value) {
            addCriterion("select_rating <>", value, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingGreaterThan(Integer value) {
            addCriterion("select_rating >", value, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingGreaterThanOrEqualTo(Integer value) {
            addCriterion("select_rating >=", value, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingLessThan(Integer value) {
            addCriterion("select_rating <", value, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingLessThanOrEqualTo(Integer value) {
            addCriterion("select_rating <=", value, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingIn(List<Integer> values) {
            addCriterion("select_rating in", values, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingNotIn(List<Integer> values) {
            addCriterion("select_rating not in", values, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingBetween(Integer value1, Integer value2) {
            addCriterion("select_rating between", value1, value2, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectRatingNotBetween(Integer value1, Integer value2) {
            addCriterion("select_rating not between", value1, value2, "selectRating");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeIsNull() {
            addCriterion("select_datetime is null");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeIsNotNull() {
            addCriterion("select_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeEqualTo(Date value) {
            addCriterion("select_datetime =", value, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeNotEqualTo(Date value) {
            addCriterion("select_datetime <>", value, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeGreaterThan(Date value) {
            addCriterion("select_datetime >", value, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("select_datetime >=", value, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeLessThan(Date value) {
            addCriterion("select_datetime <", value, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("select_datetime <=", value, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeIn(List<Date> values) {
            addCriterion("select_datetime in", values, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeNotIn(List<Date> values) {
            addCriterion("select_datetime not in", values, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeBetween(Date value1, Date value2) {
            addCriterion("select_datetime between", value1, value2, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("select_datetime not between", value1, value2, "selectDatetime");
            return (Criteria) this;
        }

        public Criteria andSelectTitleIsNull() {
            addCriterion("select_title is null");
            return (Criteria) this;
        }

        public Criteria andSelectTitleIsNotNull() {
            addCriterion("select_title is not null");
            return (Criteria) this;
        }

        public Criteria andSelectTitleEqualTo(String value) {
            addCriterion("select_title =", value, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleNotEqualTo(String value) {
            addCriterion("select_title <>", value, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleGreaterThan(String value) {
            addCriterion("select_title >", value, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleGreaterThanOrEqualTo(String value) {
            addCriterion("select_title >=", value, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleLessThan(String value) {
            addCriterion("select_title <", value, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleLessThanOrEqualTo(String value) {
            addCriterion("select_title <=", value, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleLike(String value) {
            addCriterion("select_title like", value, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleNotLike(String value) {
            addCriterion("select_title not like", value, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleIn(List<String> values) {
            addCriterion("select_title in", values, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleNotIn(List<String> values) {
            addCriterion("select_title not in", values, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleBetween(String value1, String value2) {
            addCriterion("select_title between", value1, value2, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectTitleNotBetween(String value1, String value2) {
            addCriterion("select_title not between", value1, value2, "selectTitle");
            return (Criteria) this;
        }

        public Criteria andSelectStickIsNull() {
            addCriterion("select_stick is null");
            return (Criteria) this;
        }

        public Criteria andSelectStickIsNotNull() {
            addCriterion("select_stick is not null");
            return (Criteria) this;
        }

        public Criteria andSelectStickEqualTo(String value) {
            addCriterion("select_stick =", value, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickNotEqualTo(String value) {
            addCriterion("select_stick <>", value, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickGreaterThan(String value) {
            addCriterion("select_stick >", value, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickGreaterThanOrEqualTo(String value) {
            addCriterion("select_stick >=", value, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickLessThan(String value) {
            addCriterion("select_stick <", value, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickLessThanOrEqualTo(String value) {
            addCriterion("select_stick <=", value, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickLike(String value) {
            addCriterion("select_stick like", value, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickNotLike(String value) {
            addCriterion("select_stick not like", value, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickIn(List<String> values) {
            addCriterion("select_stick in", values, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickNotIn(List<String> values) {
            addCriterion("select_stick not in", values, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickBetween(String value1, String value2) {
            addCriterion("select_stick between", value1, value2, "selectStick");
            return (Criteria) this;
        }

        public Criteria andSelectStickNotBetween(String value1, String value2) {
            addCriterion("select_stick not between", value1, value2, "selectStick");
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