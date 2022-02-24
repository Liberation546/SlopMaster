package chicky;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message.MentionType;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class Commands extends ListenerAdapter {
	public String message = "";
	public String prefix = "c$";
	public int joeCount = 0;
	public int maximumJoe = 100;
	public File f = new File("log.txt");
	public String[] pathArray = {"C:/Users/mmmmm/Desktop/chicken/1.png", 
			"C:/Users/mmmmm/Desktop/chicken/2.png",
			"C:/Users/mmmmm/Desktop/chicken/3.png",
			"C:/Users/mmmmm/Desktop/chicken/4.png",
			"C:/Users/mmmmm/Desktop/chicken/5.png",
			"C:/Users/mmmmm/Desktop/chicken/6.png",
			"C:/Users/mmmmm/Desktop/chicken/7.png",
			"C:/Users/mmmmm/Desktop/chicken/8.png",
			"C:/Users/mmmmm/Desktop/chicken/9.png",
			"C:/Users/mmmmm/Desktop/chicken/10.png",
			"C:/Users/mmmmm/Desktop/chicken/11.png",
			"C:/Users/mmmmm/Desktop/chicken/12.png",
			"C:/Users/mmmmm/Desktop/chicken/13.png",
			"C:/Users/mmmmm/Desktop/chicken/14.png",
			"C:/Users/mmmmm/Desktop/chicken/15.png"};
	
	public String[] gifPathArray = {"C:/Users/mmmmm/Desktop/chicken/acorn.gif",
			"C:/Users/mmmmm/Desktop/chicken/dance.gif"};
	
	public String[] adminIDs = {"695688150466428989", "530269428185825290", "508100678758170644", "267030980210982923", "939905297240178769", "256920677385371649", "944587799888285737", "936468736532172800"};
	
	
	public JoeFileCount joeFile = new JoeFileCount();
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		try {
			if(args[0].equalsIgnoreCase(prefix + "gotohell")) {
				boolean isAdmin = true;
				if(!event.getGuild().getMember(event.getAuthor()).hasPermission(net.dv8tion.jda.api.Permission.ADMINISTRATOR)) {
					event.getChannel().sendMessage("You are not an administrator").queue();
					isAdmin = false;
				}
				if(args.length == 1 && isAdmin) {
					event.getChannel().sendMessage("Invalid command syntax");
				}
				else if(event.getMessage().getMentionedMembers().isEmpty() && isAdmin) {
					event.getGuild().ban(args[1], 0, "Banned").queue();
				} 
				else if(isAdmin) {
					event.getGuild().ban(event.getMessage().getMentionedMembers().get(0), 0, "banned").queue();
				}
			
				try {
					FileWriter myWriter = new FileWriter(f);
					myWriter.write(event.getMessage().getMentionedMembers().toString() + " has been cleared\n");
					myWriter.close();
					System.out.println("Channel update log: SUCCESSFUL");
				} catch (IOException e) {
			    		System.out.println("Channel update log: FAILURE... File Not Found Exception");
			    		e.printStackTrace();
				}
			}
		} catch(Exception nullUser) {
			event.getChannel().sendMessage("User not found").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "helpme")) {
			event.getMessage().getAuthor().openPrivateChannel().flatMap(channel -> channel.sendMessage("Command List:\n"
					+ "c$hi - ChickenBot replies with Greetings \n"
					+ "c$die - ChickenBot replies with Love you too {@userID}\n"
					+ "c$lean - ChickenBot will send a video with an Asuka/Venom Lean Meme.\n"
					+ "computer show me hell - Will send a gif of a skeleton burning in hell, be sure to thank computer afterwards!\n"
					+ "c$activity - Listens to the senders screams as an activity.\n"
					+ "c$cock - Sends a gif with a chicken.\n"
					+ "c$chickengif - Sends a guy who is very excited to eat some chicken!\n"
					+ "c$multichicken - Sends between 1-5 random pictures of fried chicken.\n"
					+ "c$soy {@userID} - Pings the user with a soy bounce gif.\n"
					+ "c$goodnight - A personal favorite :)\n"
					+ "c$warn {@userID} - Sends a dm to the pinged user, warning them.\n"
					+ "c$tuesday - Sends Out of Touch - Hall & Oates music video link\n"
					+ "computer kill joe biden - Probably the most complex command, this one sends an image to your server, counts up by one, and checks if the number has reached a maximum.\n"
					+ "Along with a bunch of stupid file shit.\n"
					+ "c$reset - This increases the maximum by a random amount between 50-249.\n"
					+ "c$play - Sets ChickenBot activity to playing a custom game of the senders choosing.\n"
					+ "c$listen - Sets ChickenBot activity to listening to a custom song."
					+ "c$lonely - Sets ChickenBot status to Do Not Disturb")).queue();
		}
		
		if(args[0].equalsIgnoreCase(prefix + "silence")) {
			Member member = event.getMessage().getMentionedMembers().get(0);
			User author = event.getMessage().getAuthor();
			try {
				boolean isAdmin = true;
				if(!event.getGuild().getMember(author).hasPermission(net.dv8tion.jda.api.Permission.ADMINISTRATOR)) {
					event.getChannel().sendMessage("You are not an administrator idiot!");
					isAdmin = false;
				} 
				if(isAdmin) {
					event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("932112631546916884")).queue();
					event.getChannel().sendMessage(member.getAsMention() + " Has been muted :)").queue();
				}
			} catch(Exception e) {
					event.getChannel().sendMessage("User is null").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "hi")) {
			event.getMessage().reply("Greetings, " + event.getAuthor().getAsMention()).queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "die")) {
			event.getMessage().reply("Love you too " + event.getAuthor().getAsMention() + "!").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "grease")) {
			User user = event.getAuthor();
			for(int i = 0; i < 5; i++) {	
				if(user.getId().equals("285179041777188875")) {
					event.getMessage().reply("Don't play yourself").queue();
					i = 5;
					break;
				}
				event.getMessage().delete().queue();
				event.getChannel().sendMessage("<@285179041777188875> fuck you").queue();	
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "suckmyballs")) {
			String[] userIDs = {"508100678758170644", "530269428185825290", "695688150466428989", "600705350223659024", "381437831878279168", "629024069332893711", "399304447575982082"};
			int randID = ThreadLocalRandom.current().nextInt(0, 7);
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Suck my balls <@" + userIDs[randID] + ">").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "lean")) {
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/carnage.mp4")).queue();
		}
		if(args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("show") && args[2].equalsIgnoreCase("me") && args[3].equalsIgnoreCase("hell")) {
			File f = new File("C:/Users/mmmmm/Desktop/botgifs/skeleton-burning.gif");
			EmbedBuilder embed = new EmbedBuilder();
			
			embed.setTitle(" ");
			embed.setImage("attachment://hell.gif");
			event.getChannel().sendMessage(embed.build()).addFile(f, "hell.gif").queue();
			
		}
		if(args[0].equalsIgnoreCase(prefix + "activity")) {
			event.getMessage().reply("done").queue();
			event.getJDA().getPresence().setActivity(Activity.listening(event.getAuthor().getAsTag() + " screaming"));
		}
		if(args[0].equalsIgnoreCase(prefix + "activityclear")) {
			event.getMessage().reply("cleared").queue();
			event.getJDA().getPresence().setActivity(Activity.playing("Los Pollos Hermanos"));
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("ChickenBot activity has been reset.");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "cock")) {
			File f = new File("C:/Users/mmmmm/Desktop/chicken/cock.gif");
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Look at this cock!");
			embed.setImage("attachment://cock.gif");
			event.getChannel().sendMessage(embed.build()).addFile(f, "cock.gif").queue();
			
		}
		if(args[0].equalsIgnoreCase(prefix + "chicken")) {
			int rand = ThreadLocalRandom.current().nextInt(0, 15);
			File file = new File(pathArray[rand - 1]);
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("A chicken?!");
			embed.setImage("attachment://chicken.png");
			event.getChannel().sendMessage(embed.build()).addFile(file, "chicken.png").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "chickengif")) {
			int rand = ThreadLocalRandom.current().nextInt(0, 2);
			event.getChannel().sendFile(new File(gifPathArray[rand])).queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "multichicken")) {
			int rand = ThreadLocalRandom.current().nextInt(0, 6);

			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("You asked for it...");
			embed.setImage("attachment://chicken.png");
			for(int i = 0; i < rand; i++) {
				int randFile = ThreadLocalRandom.current().nextInt(0, 16);
				File file = new File(pathArray[randFile - 1]);
				event.getChannel().sendMessage(embed.build()).addFile(file, "chicken.png").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "specialModCommand")) {
			if(event.getAuthor().getId().equals("695688150466428989")) {
				for(int i = 0; i < 5; i++) {
					event.getMessage().delete().queue();
					event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/casket-coffin.gif")).queue();
				}
			} else {
				event.getMessage().delete().queue();
				event.getChannel().sendMessage("How did you get here?");
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "fuckyougeo")) {
			for(int i = 0; i < 25; i++) {
				event.getChannel().sendMessage("Fuck you die <@256920677385371649>").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "soy")) {
			IMentionable mentionedUser =  event.getMessage().getMentions(MentionType.USER).get(0);
			String replace = mentionedUser.toString();
			long id = Long.parseLong(replace.replaceAll("[^0-9]", ""));
			event.getChannel().sendMessage("<@" + String.valueOf(id) + ">").queue();
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/bounce.gif")).queue();
			event.getMessage().delete().queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "goodnight")) {
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/sleep.mp4")).queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "unsilence")) {
			Member member = event.getMessage().getMentionedMembers().get(0);
			User author = event.getMessage().getAuthor();
			boolean isAdmin = true;
			if(!event.getGuild().getMember(author).hasPermission(net.dv8tion.jda.api.Permission.ADMINISTRATOR)) {
				event.getChannel().sendMessage("You are not an administrator idiot!");
				isAdmin = false;
			} 
			if(isAdmin) {
				event.getGuild().removeRoleFromMember(member, event.getGuild().getRoleById("932112631546916884")).queue();
				event.getChannel().sendMessage(member.getAsMention() + " Has been unmuted :(").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "kys")) {
			event.getMessage().delete().queue();
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/kys.png")).queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "warn")) {
			for(int i = 0; i < args.length; i++) {
				message += args[i] += " ";
			}
			
			User user = event.getMessage().getMentionedUsers().get(0);
			user.openPrivateChannel().queue(channel -> channel.sendMessage(message).queue());
			event.getMessage().delete().queue();
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println(event.getMessage().getMentionedMembers().toString() + " has been warned.");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("jango")) {
				i = args.length;
				final String emoteId = "felixsupremacy:944033771836022844";
				event.getMessage().addReaction(emoteId).queue();
			}
		}
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("benadryl")) {
				i = args.length;
				final String emoteId = "BENADRYL:943635931456495696";
				event.getMessage().addReaction(emoteId).queue();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("tuesday")) {
				i = args.length;
				event.getChannel().sendMessage("Tuesday? Am I so out of touch? https://www.youtube.com/watch?v=D00M2KZH1J0").queue();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[0].equalsIgnoreCase("league") && args[1].equalsIgnoreCase("of") && args[2].equalsIgnoreCase("legends")) {
				i = args.length;
				event.getMessage().reply(new File("C:/Users/mmmmm/Desktop/botgifs/outofthegenepool.png")).queue();
			}
		}
		
		if(args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("kill") && args[2].equalsIgnoreCase("joe") && args[3].equalsIgnoreCase("biden")) {
			String counter = String.valueOf(joeCount);
			joeCount++;
			try {
				joeFile.writeFile(joeCount);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				counter = joeFile.readFile(joeFile.joe);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(joeCount <= 10 && joeCount > 1) {
				event.getChannel().sendTyping().delay(Duration.ofSeconds(5)).queue();
				event.getChannel().sendMessage("I have killed Joe Biden, here is the video.").queue();
				event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/biden.gif")).queue();
				event.getChannel().sendMessage("Joe Biden has been killed " + counter + " times.").queue();
			} else if (joeCount == 1) {
				event.getChannel().sendTyping().delay(Duration.ofSeconds(5)).queue();
				event.getChannel().sendMessage("I have killed Joe Biden, here is the video.").queue();
				event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/biden.gif")).queue();
				event.getChannel().sendMessage("Joe Biden has been killed " + counter + " time.").queue();
			}
			
			else if(joeCheck(joeCount) == maximumJoe) {
				event.getChannel().sendMessage("Oops, Joe Biden is now perma dead!").queue();
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("Joe Biden death count raised to " + joeCount);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "joekillcount")) {
			String counter = String.valueOf(joeCount);
			try {
				counter = joeFile.readFile(joeFile.joe);
			} catch (IOException e) {
				e.printStackTrace();
			}
			event.getChannel().sendMessage(counter).queue();
		}
		
		if(args[0].equalsIgnoreCase(prefix + "reset")) {
			int randCounter = ThreadLocalRandom.current().nextInt(50, 250);
			int totalJoe = joeCount;
			if(joeCount == maximumJoe) {
				for(int i = 0; i < adminIDs.length; i++) {
					if(event.getAuthor().getId().equals(adminIDs[i])) {
						event.getChannel().sendMessage("They respawned!!!!").queue();
						joeCount = 0;
						i = adminIDs.length;
					}
				}
			} else if(joeCount < maximumJoe) {
				totalJoe += randCounter;
				event.getChannel().sendMessage("\u26A0 Here they come...").queue();
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("Total Joe Biden count increased to " + totalJoe);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		for(int i = 0; i < args.length; i++) {
			User user = event.getMember().getUser();
			if(args[i].equalsIgnoreCase("genshin")) {
				user.openPrivateChannel().queue(channel -> channel.sendMessage("Haha idior").queue());
				event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("932112631546916884")).queue();
			}
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println(event.getAuthor().toString() + " has been muted for talking about genshin impact");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(args[0].equalsIgnoreCase(prefix + "play")) {
			String activity = "";
			for(int i = 1; i < args.length; i++) {
				activity += args[i] += " ";
				event.getJDA().getPresence().setActivity(Activity.playing(activity));
			}
			event.getChannel().sendMessage("I am now playing " + activity).queue();	
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("ChickenBot activity changed to: playing " + event.getJDA().getPresence().getActivity().toString());
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(args[0].equalsIgnoreCase(prefix + "listen")) {
			String activity = "";
			for(int i = 1; i < args.length; i++) {
				activity += args[i] += " ";
				event.getJDA().getPresence().setActivity(Activity.listening(activity));
			}
			event.getChannel().sendMessage("I am now listening to " + activity).queue();	
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("ChickenBot activity changed to: listening to " + event.getJDA().getPresence().getActivity().toString());
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase("!rule34")) {
			event.getMessage().reply("Horny").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "nuke")) {
			boolean isPosAdmin = false;
			for(int i = 0; i < adminIDs.length; i++) {
				if(event.getAuthor().getId().equals(adminIDs[i])) {
					isPosAdmin = true;
					event.getMessage().delete().queue();
					event.getChannel().sendMessage("This channel will be cleared in 10 seconds").queue();
					event.getChannel().createCopy().queue();
		            event.getChannel().delete().queueAfter(10, TimeUnit.SECONDS);
		            break;
				} else if(!isPosAdmin) {
					event.getChannel().sendMessage("You are not an admin, get fucked").queue();
					break;
				}
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println(event.getChannel().getName() + " has been cleared");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "t88shutdownevent")) {
			if(event.getAuthor().getId().equals("695688150466428989")) {
				event.getChannel().sendMessage("ChickenBot is shutting down for maintenance... Will be back shortly").queue();
				event.getJDA().shutdown();
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(f, true));
					pw.println("ChickenBot shut down for maintenance");
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				event.getChannel().sendMessage("You cannot initiate shutdown sequence: t88shutdownevent.");
			}
			
			
		}
		if(args[0].equalsIgnoreCase(prefix + "t99shutdownevent")) {
			if(event.getAuthor().getId().equals("695688150466428989")) {
				event.getChannel().sendMessage("ChickenBot is shutting down for unknown reasons... Will be back shortly").queue();
				event.getJDA().shutdown();
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(f, true));
					pw.println("ChickenBot shutdown for miscellaneous reasons");
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				event.getChannel().sendMessage("You cannot initiate shutdown sequence: t99shutdownevent.");
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "lonely")) {
			event.getJDA().getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
			event.getChannel().sendMessage("Do not speak to me...").queue();
		}
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("wales")) {
				i = args.length;
				event.getChannel().sendMessage("Llanfairpwllgwyngyllgogerychrywndrobwllllantysiliogogogoch").queue();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("trump")) {
				i = args.length;
				event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/trump.png")).queue();
			}
		}
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("jp")) {
				i = args.length;
				event.getMessage().addReaction("trand:946483227231649823").queue();
			}
		}
	}
	public int joeCheck(int joeCount) {
		if(joeCount >= 10) {
			try {
				joeFile.writeFile(joeCount - joeCount);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return joeCount;
	}
}

