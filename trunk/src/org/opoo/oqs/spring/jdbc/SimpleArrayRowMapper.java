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
package org.opoo.oqs.spring.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;


/**
 * ����{@link java.sql.ResultSet}�е�һ����¼������Object[]����
 *
 * <p>��ResultSet���ֶε�˳�򣬽����ֶε�ֵȡ��������Object[]���ء�
 * ���Object[]�ĳ�����1�����ص�һ��object[0]�����Է��صĿ�����
 * Object[],Object,����null��
 *
 * @author Alex Lin(alex@opoo.org)
 * @version 1.0
 * @since 1.0
 */
public class SimpleArrayRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int _int) throws SQLException {
        try {
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Object[] a = new Object[n];
            for (int i = 1; i <= n; i++) {
                //a[i - 1] = get(rs, meta, i);
                a[i - 1] = JdbcUtils.getResultSetValue(rs, i);
            }

            /**
             * ������ֻ��һ��Ԫ��ʱ��ȡ��һ��
             */
            if (n == 1) {
                return a[0];
            }

            return a;
        } catch (SQLException ex) {
        }
        return null;
    }
}
