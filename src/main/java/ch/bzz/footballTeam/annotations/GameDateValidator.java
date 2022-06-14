package ch.bzz.footballTeam.annotations;

import ch.bzz.footballTeam.util.Converter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Validator for the Attributte Date in Model-Class Game
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 14.06.2022
 */
public class GameDateValidator implements ConstraintValidator<GameDate, String> {
    protected long gameDate=200;

    /**
     * @param dateStr input for Annotation
     * @param constraintValidatorContext
     * @return is the dateStr a valid input
     */
    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext constraintValidatorContext) {
        // null values are valid
        if ( dateStr == null ) {
            return false;
        }

        LocalDate date= Converter.stringToLocalDate(dateStr);
        LocalDate today = LocalDate.now();
        return ChronoUnit.YEARS.between(date, today)<=100;
    }
}