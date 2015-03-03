/*
 * Simple Connection Monitor
 * Copyright (C) 2012-2014 BAXTER Technologies
 * This software is a property of BAXTER Technologies
 * and should remain that way. If you got this source
 * code from elsewhere please immediately inform Franck.
 */
package com.baxter.connection.monitor.simple.jmx.mbean;

import java.util.Observable;
import java.util.Observer;

import com.baxter.connection.monitor.Status;
import com.baxter.connection.monitor.jmx.ConnectionMonitorMXBean;
import com.baxter.connection.monitor.jmx.mbean.AbstractConnectionMonitor;
import com.baxter.connection.monitor.simple.SimpleConnection;

/**
 * 
 * @author xpdev
 *
 */
public class SimpleConnectionMonitor extends AbstractConnectionMonitor implements ConnectionMonitorMXBean
{

  public SimpleConnectionMonitor(final SimpleConnection connection)
  {
	super(connection);
	connection.addObserver(new SimpleConnectionObserver());
  }

  @Override
  public String getMonitorType()
  {
	return "simple";
  }

  private class SimpleConnectionObserver implements Observer
  {

	@Override
	public void update(final Observable o, final Object arg)
	{
	  final Status status = (Status) arg;
	  fireConnectionStatusChanged(status);
	}

  }

}
