package ch.bzz.footballTeam.annotations;

import ch.bzz.footballTeam.util.Converter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GameDateValidator implements ConstraintValidator<GameDate, String> {
    protected long gameDate=200;

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