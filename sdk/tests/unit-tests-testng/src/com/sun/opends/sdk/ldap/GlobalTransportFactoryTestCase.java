/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE
 * or https://OpenDS.dev.java.net/OpenDS.LICENSE.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE.  If applicable,
 * add the following below this CDDL HEADER, with the fields enclosed
 * by brackets "[]" replaced with your own identifying information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Copyright 2010 Sun Microsystems, Inc.
 */

package com.sun.opends.sdk.ldap;



import static org.testng.Assert.assertTrue;

import java.net.Socket;
import java.util.Random;

import org.testng.annotations.Test;

import com.sun.grizzly.TransportFactory;
import com.sun.grizzly.nio.transport.TCPNIOTransport;



/**
 * Tests Global Transport Factory class.
 */
public class GlobalTransportFactoryTestCase extends LDAPTestCase
{
  @Test()
  public void testGlobalTransport() throws Exception
  {
    // Create a transport.
    final TransportFactory instance = GlobalTransportFactory.getInstance();
    final TCPNIOTransport transport = instance.createTCPTransport();
    final Random r = new Random();
    int port = r.nextInt(10000);
    if (port < 1000)
    {
      port += 1000;
    }
    transport.bind(port);
    // Establish a socket connection to see if the transport factory works.
    final Socket socket = new Socket("localhost", port);
    // Successfully connected if there is no exception.
    assertTrue(socket.isConnected());
    // Don't stop the transport because it is shared with the ldap server.
  }
}