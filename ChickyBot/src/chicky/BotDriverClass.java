package chicky;

import java.io.File;
import java.io.IOException;

import javax.security.auth.login.LoginException;

import com.fasterxml.jackson.core.JsonParser;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class BotDriverClass {
	
	public static void main(String[] args) throws LoginException, IOException {
		Token token = new Token();
		JoeFileCount file = new JoeFileCount();
		//file.writeFile(10000);
		JDABuilder jda = JDABuilder.createDefault(token.Token);
		jda.setActivity(Activity.playing("Los Pollos Hermanos"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new Commands());
		jda.build();
		System.out.println(file.readFile(file.joe));
		
	}
} 

