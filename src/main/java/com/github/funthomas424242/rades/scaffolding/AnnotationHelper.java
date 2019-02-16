package com.github.funthomas424242.rades.scaffolding;

/*-
 * #%L
 * RADES Scaffolding Projekt
 * %%
 * Copyright (C) 2018 - 2019 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.Set;
import java.util.function.Consumer;

public interface AnnotationHelper {

    default void computePackageAnnotation(RoundEnvironment roundEnv, TypeElement annotation, Consumer<Element> consumer) {
        final Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
        for (final Element annotatedElement : annotatedElements) {
            if (annotatedElement.getKind() == ElementKind.PACKAGE) {
                consumer.accept(annotatedElement);
            }
        }
    }

}
