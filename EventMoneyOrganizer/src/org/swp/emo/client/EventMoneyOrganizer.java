package org.swp.emo.client;

import sun.nio.ch.WindowsAsynchronousChannelProvider;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EventMoneyOrganizer implements EntryPoint {

	@Override
	public void onModuleLoad() {
		
		String cookie = Cookies.getCookie("EMO");
		System.out.println(Cookies.getCookieNames());
		//check ob der nutzer schonmal eingeloggt war, bisher total unsicher aber soll f�r den zweck gen�gen
		// -1 ist nicht eingeloggt, alles andere sind die userids
		if(cookie != null && !cookie.equals("-1"))
		{
			Window.alert("Du bist eingeloggt, userid: " + cookie);
		}
		else
		{
			Usermanagement usermanagement = new Usermanagement();
			Window.alert("Du bist nicht eingeloggt, userid: " + cookie);
		}
		
		
	}

}
