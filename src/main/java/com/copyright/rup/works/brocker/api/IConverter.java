package com.copyright.rup.works.brocker.api;

import java.io.IOException;
import java.util.List;

/**
 * This interface is used for converting POJO to JSON format.
 *
 * @author Andrei_Khadziukou
 */
public interface IConverter {

    /**
     * The method converts POJO to JSON
     *
     * @param obj The POJO object.
     * @return The string representation of JSON.
     * @throws IOException
     */
    String toJson(Object obj) throws Exception;

    /**
     * The method converts JSON to POJO
     *
     * @param json
     * @param clazz
     * @return
     */
    <T> T toEntity(String json, Class<T> clazz) throws Exception;

    /**
     * The method converts JSON to POJO
     *
     * @param json
     * @param clazz
     * @return
     */
    <T> List<T> toEntities(String json) throws Exception;
}
