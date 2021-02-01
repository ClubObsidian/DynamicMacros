package com.clubobsidian.dynamicmacro;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.clubobsidian.wrappy.ConfigurationSection;

public class MacroToken implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6384645527099128238L;

	private final Map<String, Object> macros;

	public MacroToken(Map<String, Object> macros) {
		this.macros = new LinkedHashMap<>(macros);
	}

	public MacroToken(ConfigurationSection section) {
		this.macros = this.parse(section);
	}

	private Map<String, Object> parse(ConfigurationSection section) {
		Map<String, Object> parsed = new LinkedHashMap<>();
		for(String key : section.getKeys()) {
			parsed.put(key, section.get(key));
		}
		return parsed;
	}

	public Map<String, Object> getMacros() {
		return this.macros;
	}
}