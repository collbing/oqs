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
package org.opoo.oqs.transaction;

import javax.transaction.Synchronization;

/**
 * ������ӿڡ�
 * <p>���ʽ�������:
 * <pre>
 *
 * Transaction tx = queryFactory.beginTransaction();
 * try
 * {
 *   // execute your business logic here
 *   tx.commit();
 * }
 * catch (Exception ex)
 * {
 *   tx.rollback();
 *   throw ex;
 * }
 * </pre>
 *
 *
 * @author Alex Lin(alex@opoo.org)
 * @version 1.0
 */
public interface Transaction {
    //void begin() throws TransactionException;

    /**
     * �ύ����
     * @throws TransactionException
     */
    void commit() throws TransactionException;

    /**
     * �ع�����
     * @throws TransactionException
     */
    void rollback() throws TransactionException;

    /**
     * ����״̬�Ƿ����ѻع���
     * @return boolean
     * @throws TransactionException
     */
    boolean wasRolledBack() throws TransactionException;

    /**
     * ����״̬�Ƿ������ύ��
     * @return boolean
     * @throws TransactionException
     */
    boolean wasCommitted() throws TransactionException;

    /**
     * �����Ƿ��ǻ�ģ�
     * @return boolean
     * @throws TransactionException
     */
    boolean isActive() throws TransactionException;

    /**
     * ע��һ��Synchronization��
     * @param synchronization Synchronization
     * @throws TransactionException
     */
    void registerSynchronization(Synchronization synchronization) throws
            TransactionException;

}
