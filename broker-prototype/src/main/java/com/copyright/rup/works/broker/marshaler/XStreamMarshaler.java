package com.copyright.rup.works.broker.marshaler;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import java.util.List;

/**
 * It is a marshaler for Xstream.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/11/12.
 *
 * @author Andrei_Khadziukou.
 *
 */
public class XStreamMarshaler implements IMarshaler {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> toEntities(String json) {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.alias(WorkWrapper.class.getName(), WorkWrapper.class);
        WorkWrapper result = (WorkWrapper) xStream.fromXML(json);
        return (List<T>) result.getWorks();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public <T> T toEntity(String json, Class<T> clazz) {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.alias(clazz.getName(), clazz);
        return (T) xStream.fromXML(json);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public String toJson(Object obj) {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        Object object = obj;
        if (obj instanceof List) {
            WorkWrapper workWrapper = new WorkWrapper();
            workWrapper.setWorks((List<IWork>) obj);
            object = workWrapper;
        }
        /*
         * (new JsonHierarchicalStreamDriver() {
         *
         * /** {@inheritDoc} /
         *
         * @Override public HierarchicalStreamWriter createWriter(Writer writer) { return new
         * JsonWriter(writer, JsonWriter.DROP_ROOT_MODE); }
         *
         * });
         */
        xStream.setMode(XStream.NO_REFERENCES);
        xStream.alias(object.getClass().getName(), object.getClass());
        return xStream.toXML(object);
    }
}
