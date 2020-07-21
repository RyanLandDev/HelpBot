package com.diamondfire.helpbot.bot.command.impl.other;

import com.diamondfire.helpbot.bot.command.argument.ArgumentSet;
import com.diamondfire.helpbot.bot.command.help.*;
import com.diamondfire.helpbot.bot.command.impl.Command;
import com.diamondfire.helpbot.bot.command.permissions.Permission;
import com.diamondfire.helpbot.sys.externalfile.ExternalFile;
import com.diamondfire.helpbot.bot.events.CommandEvent;

import java.io.File;
import java.util.Random;

public class SamQuotesCommand extends Command {

    private static final Random random = new Random();

    @Override
    public String getName() {
        return "samquote";
    }

    @Override
    public String[] getAliases() {
        return new String[]{"sam", "quote"};
    }

    @Override
    public HelpContext getHelpContext() {
        return new HelpContext()
                .description("Gets a quote from Sam the Man.")
                .category(CommandCategory.OTHER);
    }

    @Override
    public ArgumentSet getArguments() {
        return new ArgumentSet();
    }

    @Override
    public Permission getPermission() {
        return Permission.USER;
    }

    @Override
    public void run(CommandEvent event) {
        String[] strings = ExternalFile.SAM_DIR.getFile().list();
        File file = new File(ExternalFile.SAM_DIR.getFile(), strings[random.nextInt(strings.length)]);
        event.getChannel().sendFile(file).queue();

    }

}

