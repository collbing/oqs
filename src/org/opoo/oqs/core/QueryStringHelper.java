/*
 * $Id$
 *
 * Copyright 2006-2008 Alex Lin. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opoo.oqs.core;

import org.opoo.oqs.QueryException;
import org.opoo.util.StringUtils;

/**
 * �ඨ���˽���QS��ѯ����ִ�ʱʹ�õ�һЩ������
 *
 * @author Alex Lin(alex@opoo.org)
 * @version 1.0
 * @since OQS1.0
 */
public final class QueryStringHelper {
    /**
     * Represent a white space symbol.
     */
    public static final String WHITESPACE = " \n\r\f\t";

    /**
     * ��QS��ʹ��Named parameter��������ǰ׺��
     */
    public static final String QS_VARIABLE_PREFIX = ":";

    /**
     * QS�����ʹ�õķָ���ţ�һ���ͬ��SQL�����ʹ�õķָ���š�
     */
    public static final String QS_SEPARATORS =
            " \n\r\f\t,()=<>&|+-=/*'^![]#~\\";

    //NOTICE: no " or . since they are part of (compound) identifiers
    /**
     * Path separator.
     */
    public static final String PATH_SEPARATORS = ".";

    /**
     * ����ַ����Ƿ���white space.
     *
     * @param str String
     * @return boolean
     */
    public static boolean isWhitespace(String str) {
        return WHITESPACE.indexOf(str) > -1;
    }


    /**
     * ��� query String����ȷ�ԡ���Ҫ���()�Ƿ���ԡ�
     * @param msql String
     */
    public static void verifyQueryString(String msql) {
        int c1 = StringUtils.countUnquoted(msql, ')');
        int c2 = StringUtils.countUnquoted(msql, '(');
        if (c1 != c2) {
            throw new QueryException("Syntax error, ( ) mismatch.", msql);
        }

        c1 = StringUtils.countUnquoted(msql, '{');
        c2 = StringUtils.countUnquoted(msql, '}');
        if (c1 != c2) {
            throw new QueryException("Syntax error, { } mismatch.", msql);
        }
    }
}
