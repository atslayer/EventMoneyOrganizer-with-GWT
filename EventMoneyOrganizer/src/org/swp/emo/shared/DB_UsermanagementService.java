package org.swp.emo.shared;

import com.google.gwt.user.client.rpc.RemoteService;
//testcomment
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("Usermanagement")
public interface DB_UsermanagementService extends RemoteService{
	public boolean checkLogin(String username, String password);
	public void registerUser(String username, String password, String email);
}
