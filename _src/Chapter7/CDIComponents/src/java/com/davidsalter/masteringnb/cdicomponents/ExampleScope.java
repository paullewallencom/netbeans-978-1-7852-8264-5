/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.cdicomponents;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Scope;

/**
 *
 * @author david
 */
@Inherited
@Scope // or @javax.enterprise.context.NormalScope
@Retention(RUNTIME)
@Target({METHOD, FIELD, TYPE})
public @interface ExampleScope {
}
