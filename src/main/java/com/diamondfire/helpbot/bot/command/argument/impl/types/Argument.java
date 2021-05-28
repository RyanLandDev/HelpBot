package com.diamondfire.helpbot.bot.command.argument.impl.types;


import com.diamondfire.helpbot.bot.command.argument.impl.parsing.exceptions.ArgumentException;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.Deque;

// Arguments simply parse a given value and can remove it from the stack if they process it correctly.
// This means an argument can actually use more than one argument if they want!
public interface Argument<T> {
    
    T parseValue(@NotNull Deque<String> args) throws ArgumentException;
    
}
 