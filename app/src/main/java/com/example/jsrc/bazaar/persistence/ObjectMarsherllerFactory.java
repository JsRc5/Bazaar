package com.example.jsrc.bazaar.persistence;

public interface ObjectMarsherllerFactory
{
    <T>ObjectMarshaller<T> createDefaultObjectMarchallerWithEmptyStringMatcher(final Class<? extends T> objectClass);
}
