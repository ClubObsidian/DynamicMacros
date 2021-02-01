package com.clubobsidian.dynamicmacro.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.dynamicmacro.MacroParser;
import com.clubobsidian.dynamicmacro.MacroToken;
import org.junit.Test;

import com.clubobsidian.wrappy.Configuration;
import com.clubobsidian.wrappy.ConfigurationSection;

public class MacroNonStringTest {

	@Test
	public void testNonStringParseStringMacros() {
		File guiFolder = new File("test", "macro");
		File file = new File(guiFolder, "non-string-macro.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection macros = config.getConfigurationSection("macros");
		
		MacroToken token = new MacroToken(macros);
		List<MacroToken> tokens = new ArrayList<>();
		tokens.add(token);
		MacroParser parser = new MacroParser(tokens);
		String parsed = parser.parseStringMacros("%test-non-string%");
		assertTrue(parsed.equals("1"));
	}
	
	@Test
	public void testNonStringParseListMacros() {
		File guiFolder = new File("test", "macro");
		File file = new File(guiFolder, "non-string-macro.yml");
		Configuration config = Configuration.load(file);
		ConfigurationSection macros = config.getConfigurationSection("macros");
		System.out.println(macros.getKeys());
		
		MacroToken token = new MacroToken(macros);
		List<MacroToken> tokens = new ArrayList<>();
		tokens.add(token);
		MacroParser parser = new MacroParser(tokens);
		List<String> nonString = new ArrayList<>();
		nonString.add("%test-non-string%");
		nonString.add("%test-non-string%");
		List<String> parsed = parser.parseListMacros(nonString);
		assertTrue(parsed.size() == 2);
		assertTrue(parsed.get(0).equals("1"));
		assertTrue(parsed.get(1).equals("1"));
	}
}