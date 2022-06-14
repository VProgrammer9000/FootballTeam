package ch.bzz.footballTeam.annotations;


import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validator for the Attributte Date in Model-Class Game
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 14.06.2022
 */

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

