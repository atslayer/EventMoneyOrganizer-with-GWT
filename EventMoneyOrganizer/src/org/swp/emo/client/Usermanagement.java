package org.swp.emo.client;



import org.swp.emo.shared.DB_UsermanagementService;
import org.swp.emo.shared.DB_UsermanagementServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Usermanagement {
	
	//DB_UsermanagementServiceImpl db_usermanagement = new DB_UsermanagementServiceImpl();
	
	private DB_UsermanagementServiceAsync userSvc = GWT.create(DB_UsermanagementService.class);
		
	
	Usermanagement() {
		
		
		setupLoginform();
	}
	
	
	/**
	 * Hier wird das Login Form initialisiert
	 * @return 
	 */
	private void setupLoginform() {
		
		final DialogBox registerDialog = createRegisterDialogBox();
		
		String html =
				"<div id=\"loginform\" name=\"loginform\">" +
				  "<p id=\"username\" >" +
				    "<label>Username<br/>" +
				  "</p>" +
				  "<p id=\"password\">" +
				    "<label>Password<br/>" +
				  "</p>" +
				  "<p id=\"submit\" class=\"submit\">" +
				  "</p>" +
				"</div>";
		
		HTMLPanel shortLinks = new HTMLPanel(
				"<div id=\"loginShortlinks\">" +
				"</div>");
		
		HTMLPanel myPanel = new HTMLPanel(html); //Create the htmlpanel
		
		final TextBox user = new TextBox();
		user.addStyleName("input"); //See here same CSS Class is used
		myPanel.add(user, "username");

		final TextBox password = new PasswordTextBox();
		password.addStyleName("input");
		myPanel.add(password, "password");


		Button submit = new Button("Login");
		
		//Login Button , handler onclick
		submit.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  checkLogin(user.getValue(), password.getValue());
		        }
		});
		submit.getElement().setId("loginsubmit"); //Give a new ID
		myPanel.add(submit, "submit");
		
		Anchor register = new Anchor("Register");
		register.addStyleName("a");
		register.setText("Register");
		register.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		      
		    	  registerDialog.show();
		      }
		});
		shortLinks.add(register);
		
		

		//RootPanel.get("registerDialogBox").add(registerDialog);
		RootPanel.get("loginform").add(myPanel);
		RootPanel.get("shortlinks").add(shortLinks);
	}
	
	private void checkLogin(String username, String password) {
		
		
		
		

	    // Set up the callback object.
	    AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
	      public void onFailure(Throwable caught) {
	        // TODO: Do something with errors.
	      }

	      public void onSuccess(Boolean result) {
	        Window.alert(result.toString());
	      }
	    };

	    // Make the call to the stock price service.
	    userSvc.checkLogin(username, password, callback);
	}
	
	private DialogBox createRegisterDialogBox() {
	    // Create a dialog box and set the caption text
	    final DialogBox dialogBox = new DialogBox();
	    dialogBox.ensureDebugId("cwDialogBox");
	    dialogBox.setText("Register");

	    // Create a table to layout the content
	    VerticalPanel dialogContents = new VerticalPanel();
	    dialogContents.setWidth("100%");
	    dialogContents.setSpacing(4);
	    dialogBox.setWidget(dialogContents);

	    // Add some text to the top of the dialog
	    HTML username_text = new HTML("username");
	    dialogContents.add(username_text);

	    TextBox username_input = new TextBox();
	    username_input.addStyleName("input"); //See here same CSS Class is used
		dialogContents.add(username_input);

	    // Add some text to the top of the dialog
	    HTML email_text = new HTML("Email Address");
	    dialogContents.add(email_text);

	    TextBox email_input = new TextBox();
	    email_input.addStyleName("input"); //See here same CSS Class is used
		dialogContents.add(email_input);

	    // Add some text to the top of the dialog
	    HTML pass1_text = new HTML("Password");
	    dialogContents.add(pass1_text);

	    TextBox pass1_input = new PasswordTextBox();
	    pass1_input.addStyleName("input"); //See here same CSS Class is used
		dialogContents.add(pass1_input);

	    // Add some text to the top of the dialog
	    HTML pass2_text = new HTML("Repeat Password");
	    dialogContents.add(pass2_text);

	    TextBox pass2_input = new PasswordTextBox();
	    pass1_input.addStyleName("input"); //See here same CSS Class is used
		dialogContents.add(pass2_input);

	   

		// Add a close button at the bottom of the dialog
	    Button register_button = new Button("register");
	    register_button.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		      
		    	  
			}
	    });
	    dialogContents.add(register_button);
	    dialogContents.setCellHorizontalAlignment(register_button,
	        HasHorizontalAlignment.ALIGN_LEFT);
	    
	 // Add a close button at the bottom of the dialog
	    Button closeButton = new Button("close");
	    closeButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		      
		    	  dialogBox.hide();
			}
	    });
	    dialogContents.add(closeButton);
	    dialogContents.setCellHorizontalAlignment(closeButton,
	        HasHorizontalAlignment.ALIGN_RIGHT);

	    // Return the dialog box
	    
	    return dialogBox;
	  
	}
}
