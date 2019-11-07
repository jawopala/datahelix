/*
 * Copyright 2019 Scott Logic Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.scottlogic.deg.profile.reader.services.constraints.atomic;

import com.google.inject.Inject;
import com.scottlogic.deg.common.profile.Field;
import com.scottlogic.deg.common.profile.HelixNumber;
import com.scottlogic.deg.common.profile.NumericGranularity;
import com.scottlogic.deg.common.util.NumberUtils;
import com.scottlogic.deg.generator.profile.constraints.atomic.*;
import com.scottlogic.deg.profile.dtos.constraints.atomic.*;
import com.scottlogic.deg.profile.reader.FileReader;

class NumericConstraintFactory extends AtomicConstraintFactory
{

    @Inject
    NumericConstraintFactory(FileReader fileReader)
    {
        super(fileReader);
    }

    @Override
    Object parseValue(Object value)
    {
        return NumberUtils.coerceToBigDecimal(value);
    }

    @Override
    MatchesRegexConstraint createMatchesRegexConstraint(MatchesRegexConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    ContainsRegexConstraint createContainsRegexConstraint(ContainsRegexConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    OfLengthConstraint createOfLengthConstraint(OfLengthConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    ShorterThanConstraint createShorterThanConstraint(ShorterThanConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    LongerThanConstraint createLongerThanConstraint(LongerThanConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    GreaterThanConstraint createGreaterThanConstraint(GreaterThanConstraintDTO dto, Field field)
    {
        return new GreaterThanConstraint(field, HelixNumber.create(dto.value));
    }

    @Override
    GreaterThanOrEqualToConstraint createGreaterThanOrEqualToConstraint(GreaterThanOrEqualToConstraintDTO dto, Field field)
    {
        return new GreaterThanOrEqualToConstraint(field, HelixNumber.create(dto.value));
    }

    @Override
    LessThanConstraint createLessThanConstraint(LessThanConstraintDTO dto, Field field)
    {
        return new LessThanConstraint(field, HelixNumber.create(dto.value));
    }

    @Override
    LessThanOrEqualToConstraint createLessThanOrEqualToConstraint(LessThanOrEqualToConstraintDTO dto, Field field)
    {
        return new LessThanOrEqualToConstraint(field, HelixNumber.create(dto.value));
    }

    @Override
    AfterConstraint createAfterConstraint(AfterConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    AfterOrAtConstraint createAfterOrAtConstraint(AfterOrAtConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    BeforeConstraint createBeforeConstraint(BeforeConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    BeforeOrAtConstraint createBeforeOrAtConstraint(BeforeOrAtConstraintDTO dto, Field field)
    {
        return null;
    }

    @Override
    AtomicConstraint createGranularToConstraint(GranularToConstraintDTO dto, Field field)
    {
        return new GranularToNumericConstraint(field, NumericGranularity.create(dto.value));
    }
}