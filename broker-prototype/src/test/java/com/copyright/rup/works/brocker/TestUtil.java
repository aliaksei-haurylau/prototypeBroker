package com.copyright.rup.works.brocker;

import com.copyright.rup.works.broker.Generator;
import com.copyright.rup.works.domain.api.IWork;

import java.util.ArrayList;
import java.util.List;

/**
 * It is a utility class.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/12/12.
 *
 * @author Andrei_Khadziukou.
 *
 */
public final class TestUtil {

    private TestUtil() {
    }

    public static final int COUNT_WORK_OBJECT = 10;

    private static List<IWork> works;

    public static List<IWork> getWorks() {
        return works;
    }

    static {
        works = new ArrayList<>();
        for (int i = 0; i < COUNT_WORK_OBJECT; i++) {
            works.add(Generator.generateWork());
        }
    }

}
