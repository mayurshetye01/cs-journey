package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
public @interface Complexity {

    String value();

    String explanation() default "";

}
