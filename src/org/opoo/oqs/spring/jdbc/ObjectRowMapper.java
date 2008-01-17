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
import java.sql.SQLException;
import java.util.Map;

import org.opoo.util.ClassUtils;
import org.springframework.jdbc.core.ColumnMapRowMapper;

/**
 * ����{@link java.sql.ResultSet}�е�һ����¼������һ��ָ��class name�����ʵ����
 *
 * <p>�˶���Ӧ��ΪһValue Object������Ӧ�����ԡ����������Լ�set��get������
 * ����ResultSet�е��ֶα���Ӧ����������һ�¡���ResultSet���ж�class��û�У�����class��
 * �ж�ResultSet��û�ж�Ӧ�ֶΣ����������
 *
 * @author Alex Lin(alex@opoo.org)
 * @version 1.0
 * @since 1.0
 */
public class ObjectRowMapper extends ColumnMapRowMapper {
    private String objectClassName;

    /**
     * ��ָ����class name����RowReader.
     * @param objectClassName String �����صĶ����class name.
     */
    public ObjectRowMapper(String objectClassName) {
        this.objectClassName = objectClassName;
    }


    public Object mapRow(ResultSet rs, int _int) throws SQLException {
        if (objectClassName == null) {
            return null;
        }

        Object obj = ClassUtils.newInstance(objectClassName);

        if (obj == null) {
            return null;
        }

        Map map = (Map)super.mapRow(rs, _int);

        if (map == null) {
            return null;
        }

        ClassUtils.populate(obj, map);

        return obj;

    }
}
