package chicky;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message.MentionType;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class Commands extends ListenerAdapter {
	public String prefix = "c$";
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
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(prefix + "gotohell")) {
			//User author = event.getAuthor();
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
		}
		if(args[0].equalsIgnoreCase(prefix + "helpme")) {
			event.getMessage().getAuthor().openPrivateChannel().flatMap(channel -> channel.sendMessage("c$hi will greet you"
					+ "\nc$die will love you :)"
					+ "\nc$grease will annoy garret 5 times"
					+ "\nc$suckmyballs tells a very stupid idiot to suck my balls"
					+ "\nc$activity will do something hilarious"
					+ "\nc$activityclear will reset my activity"
					+ "\nc$cock will give you some of this cock"
					+ "\nc$chicken will send a random piece of delicious chicken!"
					+ "\nc$multichicken use at your own risk"
					+ "\nc$chickengif will show you a random chicken gif"
					+ "\nc$fuckyougeo will blow up geos pc!"
					+ "\nc$soyanthony shows a picture of anthony"
					+ "\ngoodnight goodnight :)"
					+ "\nc$kys You should kill yourself... now"
					+ "\ncomputer_show_me_hell will show you hell, be sure to thank computer" 
					+ "\n(ADMIN ONLY) c$gotohell {@userID} bans a user for one day"
					+ "\n(ADMIN ONLY) c$silence {@userID} mutes a user indefinitely"
					+ "\n(ADMIN ONLY) c$unsilence {@userID} unmutes user")).queue();
		}
		
		if(args[0].equalsIgnoreCase(prefix + "silence")) {
			Member member = event.getMessage().getMentionedMembers().get(0);
			User author = event.getMessage().getAuthor();
			boolean isAdmin = true;
			if(!event.getGuild().getMember(author).hasPermission(net.dv8tion.jda.api.Permission.ADMINISTRATOR)) {
				event.getChannel().sendMessage("You are not an administrator idiot!");
				isAdmin = false;
			} 
			if(isAdmin) {
				event.getGuild().addRoleToMember(member, event.getGuild().getRoleById("932112631546916884")).queue();
				event.getChannel().sendMessage(member.getAsMention() + " Has been muted :)").queue();
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
		if(args[0].equalsIgnoreCase("computer_show_me_hell")) {
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
			User user = event.getAuthor();
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
			User user = event.getMessage().getMentionedUsers().get(0);
			user.openPrivateChannel().queue(channel -> channel.sendMessage(" ").queue());
			event.getMessage().delete().queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "killgrease")) {
			User invUser = event.getAuthor();
			boolean isValid = true;
			if(invUser.getId().equals("285179041777188875")) {
				event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/kys.png")).queue();
				isValid = false;
			}
			else if(isValid) {
				event.getMessage().delete().queue();
				Member member = event.getGuild().getMemberById("285179041777188875");
				User user = member.getUser();
				for(int i = 0; i < 15; i++) {
					user.openPrivateChannel().queue(channel -> channel.sendMessage("FUCK YOU FUCK YOU FUCK YOU").queue());
				}
			}
		}
	}
}

