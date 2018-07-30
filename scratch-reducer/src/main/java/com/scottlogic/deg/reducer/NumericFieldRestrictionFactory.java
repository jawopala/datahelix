package com.scottlogic.deg.reducer;

import com.scottlogic.deg.constraint.IConstraint;
import com.scottlogic.deg.input.Field;

public class NumericFieldRestrictionFactory {
    private final NumericConstraintTypeClassifier numericConstraintTypeClassifier = new NumericConstraintTypeClassifier();

    public IFieldRestriction getForConstraint(Field field, IConstraint constraint) {
        final NumericConstraintType constraintType = numericConstraintTypeClassifier.classify(constraint);
        switch(constraintType) {
            case Integer:
                return new NumericFieldRestriction<Integer>(field);
            case Double:
                return new NumericFieldRestriction<Double>(field);
            default:
                throw new IllegalStateException();
        }
    }
}
