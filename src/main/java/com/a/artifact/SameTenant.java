package com.a.artifact;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import lombok.extern.slf4j.Slf4j;

/**
 * uid是否属于当前上下文租户
 * 注：当被校验对象为空时，校验为通过，所以如果需要校验对象必填，请自行结合相关校验注解
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {com.a.artifact.SameTenant.StringChecker.class,com.a.artifact.SameTenant.LongChecker.class})
@Documented
public @interface SameTenant {

    String message() default "用户不存在或者不属于当前组织";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class StringChecker implements ConstraintValidator<SameTenant, String> {

        @Override
        public void initialize(com.a.artifact.SameTenant arg0) {
        }

        @Override
        public boolean isValid(String uid, ConstraintValidatorContext context) {

            System.out.print("到注解里面了"+uid);
//            if (StringUtils.isBlank(uid)) {
            if (uid.equals("hehe")){
                System.out.println("equallllllll-----------");
                return true;
            }
            return false;
        }
    }

    class LongChecker implements ConstraintValidator<com.a.artifact.SameTenant, Long> {

        @Override
        public void initialize(com.a.artifact.SameTenant arg0) {
        }

        @Override
        public boolean isValid(Long uid, ConstraintValidatorContext context) {
            if (null == uid) {
                return true;
            }
            return false;
        }
    }
}