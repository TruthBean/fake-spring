package org.springframework.kafka.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.messaging.handler.annotation.MessageMapping;

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@MessageMapping
@Documented
@Repeatable(KafkaListeners.class)
public @interface KafkaListener {

	String id() default "";

	String containerFactory() default "";

	/**
	 * The topics for this listener.
	 * The entries can be 'topic name', 'property-placeholder keys' or 'expressions'.
	 * An expression must be resolved to the topic name.
	 * This uses group management and Kafka will assign partitions to group members.
	 * <p>
	 * Mutually exclusive with {@link #topicPattern()} and {@link #topicPartitions()}.
	 * @return the topic names or expressions (SpEL) to listen to.
	 */
	String[] topics() default {};

	String topicPattern() default "";

	/**
	 * The topicPartitions for this listener when using manual topic/partition
	 * assignment.
	 * <p>
	 * Mutually exclusive with {@link #topicPattern()} and {@link #topics()}.
	 * @return the topic names or expressions (SpEL) to listen to.
	 */
	TopicPartition[] topicPartitions() default {};

	/**
	 * If provided, the listener container for this listener will be added to a bean
	 * with this value as its name, of type {@code Collection<MessageListenerContainer>}.
	 * This allows, for example, iteration over the collection to start/stop a subset
	 * of containers.
	 * <p>SpEL {@code #{...}} and property place holders {@code ${...}} are supported.
	 * @return the bean name for the group.
	 */
	String containerGroup() default "";

	String errorHandler() default "";

	/**
	 * Override the {@code group.id} property for the consumer factory with this value
	 * for this listener only.
	 * <p>SpEL {@code #{...}} and property place holders {@code ${...}} are supported.
	 * @return the group id.
	 * @since 1.3
	 */
	String groupId() default "";

	/**
	 * When {@link #groupId() groupId} is not provided, use the {@link #id() id} (if
	 * provided) as the {@code group.id} property for the consumer. Set to false, to use
	 * the {@code group.id} from the consumer factory.
	 * @return false to disable.
	 * @since 1.3
	 */
	boolean idIsGroup() default true;

	/**
	 * When provided, overrides the client id property in the consumer factory
	 * configuration. A suffix ('-n') is added for each container instance to ensure
	 * uniqueness when concurrency is used.
	 * <p>SpEL {@code #{...}} and property place holders {@code ${...}} are supported.
	 * @return the client id prefix.
	 * @since 2.1.1
	 */
	String clientIdPrefix() default "";

	/**
	 * A pseudo bean name used in SpEL expressions within this annotation to reference
	 * the current bean within which this listener is defined. This allows access to
	 * properties and methods within the enclosing bean.
	 * Default '__listener'.
	 * <p>
	 * Example: {@code topics = "#{__listener.topicList}"}.
	 * @return the pseudo bean name.
	 * @since 2.1.2
	 */
	String beanRef() default "__listener";

	/**
	 * Override the container factory's {@code concurrency} setting for this listener. May
	 * be a property placeholder or SpEL expression that evaluates to a {@link Number}, in
	 * which case {@link Number#intValue()} is used to obtain the value.
	 * <p>SpEL {@code #{...}} and property place holders {@code ${...}} are supported.
	 * @return the concurrency.
	 * @since 2.2
	 */
	String concurrency() default "";

	/**
	 * Set to true or false, to override the default setting in the container factory. May
	 * be a property placeholder or SpEL expression that evaluates to a {@link Boolean} or
	 * a {@link String}, in which case the {@link Boolean#parseBoolean(String)} is used to
	 * obtain the value.
	 * <p>SpEL {@code #{...}} and property place holders {@code ${...}} are supported.
	 * @return true to auto start, false to not auto start.
	 * @since 2.2
	 */
	String autoStartup() default "";

	String[] properties() default {};

	/**
	 * When false and the return type is a {@link Iterable} return the result as the value
	 * of a single reply record instead of individual records for each element. Default
	 * true. Ignored if the reply is of type {@code Iterable<Message<?>>}.
	 * @return false to create a single reply record.
	 * @since 2.3.5
	 */
	boolean splitIterables() default true;

}