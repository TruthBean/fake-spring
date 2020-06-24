package org.springframework.scheduling.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(Schedules.class)
public @interface Scheduled {

    String CRON_DISABLED = "-";


    String cron() default "";

    String zone() default "";

    /**
     * Execute the annotated method with a fixed period in milliseconds between the
     * end of the last invocation and the start of the next.
     *
     * @return the delay in milliseconds
     */
    long fixedDelay() default -1;

    /**
     * Execute the annotated method with a fixed period in milliseconds between the
     * end of the last invocation and the start of the next.
     *
     * @return the delay in milliseconds as a String value, e.g. a placeholder
     * or a {@link java.time.Duration#parse java.time.Duration} compliant value
     * @since 3.2.2
     */
    String fixedDelayString() default "";

    /**
     * Execute the annotated method with a fixed period in milliseconds between
     * invocations.
     *
     * @return the period in milliseconds
     */
    long fixedRate() default -1;

    /**
     * Execute the annotated method with a fixed period in milliseconds between
     * invocations.
     *
     * @return the period in milliseconds as a String value, e.g. a placeholder
     * or a {@link java.time.Duration#parse java.time.Duration} compliant value
     * @since 3.2.2
     */
    String fixedRateString() default "";

    /**
     * Number of milliseconds to delay before the first execution of a
     * {@link #fixedRate} or {@link #fixedDelay} task.
     *
     * @return the initial delay in milliseconds
     * @since 3.2
     */
    long initialDelay() default -1;

    /**
     * Number of milliseconds to delay before the first execution of a
     * {@link #fixedRate} or {@link #fixedDelay} task.
     *
     * @return the initial delay in milliseconds as a String value, e.g. a placeholder
     * or a {@link java.time.Duration#parse java.time.Duration} compliant value
     * @since 3.2.2
     */
    String initialDelayString() default "";

}