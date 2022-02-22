package chicky;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class BotDriverClass {
	
	public static void main(String[] args) throws LoginException {
		JDABuilder jda = JDABuilder.createDefault("OTQ1MjUwNjA0ODQ1MDA2ODQ4.YhNbOg.4POEybG3sCH-4_LkrMcCXZPdtsc");
		jda.setActivity(Activity.playing("Los Pollos Hermanos"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new Commands());
		jda.build();
	}

}
