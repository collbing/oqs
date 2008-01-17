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
package org.opoo.oqs.spring.transaction;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opoo.oqs.QueryFactory;
import org.opoo.oqs.core.AbstractQueryFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


/**
 * ������Spring ApplicationContext�����������Ե�������ࡣ
 *
 * <p>
 * ����̳���{@link DataSourceTransactionManager}������ʱϵͳ�Զ�̽��
 * <tt>QueryFactory</tt>�����˺���ʵ�֣�{@link org.opoo.oqs.core.QueryFactoryImpl}����
 * {@link org.opoo.oqs.spring.SpringQueryFactoryImpl}����
 * Ȼ������Ƿ����{@link DataSourceTransactionManager}
 * ��������ʵ�֡����
 * �������������QueryFactoryʵ�ֵķ�ʽ���û�����ȷ�е�֪������<tt>QueryFactory</tt>
 * ����������ʵ�֡�
 *
 * <p>�����������������У������ȷ�е�֪�����<tt>QueryFactory</tt>������
 * {@link org.opoo.oqs.spring.SpringQueryFactoryImpl}����Ҳ����
 * ֱ��ʹ��{@link DataSourceTransactionManager}�� *
 *
 *
 * @author Alex Lin(alex@opoo.org)
 * @version 1.0
 */
public class SpringTransactionManager extends DataSourceTransactionManager {
    private static final Log log = LogFactory.getLog(SpringTransactionManager.class);

    public SpringTransactionManager() {
        super();
    }

    public SpringTransactionManager(QueryFactory qf) {
        this();
        setQueryFactory(qf);
    }

    public void setQueryFactory(QueryFactory qf) {
        DataSource ds = ((AbstractQueryFactory) qf).getDataSource();
        setDataSource(ds);
    }
}
