package ch.bzz.footballTeam.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Constraint(validatedBy = {GameDateValidator.class})
@Target({PARAMETER})
@Documented
public @interface GameDate {

    String message() default "Too many years away";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    @interface List {
        GameDate[] value();
    }
}

