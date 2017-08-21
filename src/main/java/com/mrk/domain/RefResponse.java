package com.mrk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrk.domain.refs.GenericRef;
import com.mrk.domain.refs.RefFormat;
import com.mrk.domain.refs.RefType;

/**
 * Created by Helmsdown on 7/8/15.
 *
 * This class extends directly from Response for now. At some future date we will need
 * to make {@link com.mrk.domain.Response} an interface to follow the pattern established by
 * {@link com.mrk.domain.Model}, {@link com.mrk.domain.properties.Object} and {@link com.mrk.domain.parameters.Parameter}
 */
public class RefResponse extends Response {

    private GenericRef genericRef;

    public RefResponse() {
    }

    public RefResponse(String ref) {
        set$ref(ref);
    }

    public void set$ref(String ref) {
        this.genericRef = new GenericRef(RefType.RESPONSE, ref);
    }

    public String get$ref() {
        return genericRef.getRef();
    }

    @JsonIgnore
    public String getSimpleRef() {
        return genericRef.getSimpleRef();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefResponse refResponse = (RefResponse) o;

        return !(genericRef != null ? !genericRef.equals(refResponse.genericRef) : refResponse.genericRef != null);

    }

    @Override
    public int hashCode() {
        return genericRef != null ? genericRef.hashCode() : 0;
    }

    @JsonIgnore
    public RefFormat getRefFormat() {
        return this.genericRef.getFormat();
    }

}
