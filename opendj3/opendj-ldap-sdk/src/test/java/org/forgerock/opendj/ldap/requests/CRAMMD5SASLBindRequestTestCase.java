/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at
 * trunk/opendj3/legal-notices/CDDLv1_0.txt
 * or http://forgerock.org/license/CDDLv1.0.html.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at
 * trunk/opendj3/legal-notices/CDDLv1_0.txt.  If applicable,
 * add the following below this CDDL HEADER, with the fields enclosed
 * by brackets "[]" replaced with your own identifying information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Copyright 2010 Sun Microsystems, Inc.
 */

package org.forgerock.opendj.ldap.requests;



import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.requests.CRAMMD5SASLBindRequest;
import org.forgerock.opendj.ldap.requests.Requests;
import org.testng.annotations.DataProvider;



/**
 * Tests CRAM MD5 SASL bind requests.
 */
public class CRAMMD5SASLBindRequestTestCase extends BindRequestTestCase
{
  @DataProvider(name = "CRAMMD5SASLBindRequests")
  public Object[][] getCRAMMD5SASLBindRequests() throws Exception
  {
    final CRAMMD5SASLBindRequest[] requests = {
        Requests.newCRAMMD5SASLBindRequest("id1", ByteString.empty()),
        Requests.newCRAMMD5SASLBindRequest("id2", ByteString.valueOf("test")) };
    final Object[][] objArray = new Object[requests.length][1];
    for (int i = 0; i < requests.length; i++)
    {
      objArray[i][0] = requests[i];
    }
    return objArray;
  }



  @Override
  protected CRAMMD5SASLBindRequest[] createTestRequests() throws Exception
  {
    final Object[][] objs = getCRAMMD5SASLBindRequests();
    final CRAMMD5SASLBindRequest[] ops = new CRAMMD5SASLBindRequest[objs.length];
    for (int i = 0; i < objs.length; i++)
    {
      ops[i] = (CRAMMD5SASLBindRequest) objs[i][0];
    }
    return ops;
  }
}