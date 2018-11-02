package com.yq.common.base.impl.predicate;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanPredicateExtend<T,E> implements Predicate<T>{

    private final Log log = LogFactory.getLog(this.getClass());

    /** Name of the property whose value will be predicated */
    private String propertyName;
    /** <code>Predicate</code> to be applied to the property value */
    private Predicate<E> predicate;

    /**
     * Constructs a <code>BeanPredicate</code> that applies the given
     * <code>Predicate</code> to the named property value.
     * @param propertyName the name of the property whose value is to be predicated,
     * not null
     * @param predicate2 the <code>Predicate</code> to be applied,
     * not null
     */
    public BeanPredicateExtend(final String propertyName, final Predicate<E> predicate2) {
        this.propertyName = propertyName;
        this.predicate = predicate2;
    }

    /**
     * Evaluates the given object by applying the {@link #getPredicate()}
     * to a property value named by {@link #getPropertyName()}.
     *
     * @param object The object being evaluated
     * @return the result of the predicate evaluation
     * @throws IllegalArgumentException when the property cannot be evaluated
     */
    public boolean evaluate(final T object) {

        boolean evaluation = false;

        try {
            @SuppressWarnings("unchecked")
			final E propValue = (E) PropertyUtils.getProperty( object, propertyName );
            evaluation = predicate.evaluate(propValue);
        } catch (final IllegalArgumentException e) {
            final String errorMsg = "Problem during evaluation.";
            log.error("ERROR: " + errorMsg, e);
            throw e;
        } catch (final IllegalAccessException e) {
            final String errorMsg = "Unable to access the property provided.";
            log.error(errorMsg, e);
            throw new IllegalArgumentException(errorMsg);
        } catch (final InvocationTargetException e) {
            final String errorMsg = "Exception occurred in property's getter";
            log.error(errorMsg, e);
            throw new IllegalArgumentException(errorMsg);
        } catch (final NoSuchMethodException e) {
            final String errorMsg = "Property not found.";
            log.error(errorMsg, e);
            throw new IllegalArgumentException(errorMsg);
        }

        return evaluation;
    }

    /**
     * Gets the name of the property whose value is to be predicated.
     * in the evaluation.
     * @return the property name, not null
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the name of the property whose value is to be predicated.
     * @param propertyName the name of the property whose value is to be predicated,
     * not null
     */
    public void setPropertyName(final String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Gets the <code>Predicate</code> to be applied to the value of the named property
     * during {@link #evaluate}.
     * @return <code>Predicate</code>, not null
     */
    public Predicate<E> getPredicate() {
        return predicate;
    }

    /**
     * Sets the <code>Predicate</code> to be applied to the value of the named property
     * during {@link #evaluate(Object)}.
     * @param predicate <code>Predicate</code>, not null
     */
    public void setPredicate(final Predicate<E> predicate) {
        this.predicate = predicate;
    }
}
