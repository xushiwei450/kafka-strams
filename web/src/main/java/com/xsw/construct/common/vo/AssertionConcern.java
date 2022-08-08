package com.xsw.construct.common.vo;

import com.xsw.construct.common.exception.CommonErrorEnum;
import com.xsw.construct.common.exception.CommonException;
import lombok.val;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ShiWei.Xu
 * @className
 * @description
 * @date create in 10:03 2020/11/17
 **/

public class AssertionConcern implements Serializable {

	protected AssertionConcern() {
		super();
	}

	protected static Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory().getValidator();


	public void validate(){
		Set<ConstraintViolation<AssertionConcern>> constraintViolations = validator.validate(this);
		// 抛出检验异常
		handleConstrantViolations(constraintViolations);
	}
	private <T> void handleConstrantViolations(Set<ConstraintViolation<T>> constraintViolations) {
		if (constraintViolations.size() > 0) {
			String errors = constraintViolations.stream()
				.map(ConstraintViolation::getMessage)
				.collect(Collectors.joining("; "));
			throw new CommonException(CommonErrorEnum.ILLEGAL_PARAMS,errors);
		}
	}

	public void validate(Object object, String property){
		val constraintViolations = validator.validateProperty(object, property);
		handleConstrantViolations(constraintViolations);
	}
	private static final long serialVersionUID = 1L;

}
