/**
 * 
 */
package it.sardegnaricerche.voiceid.db.gmm;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import it.sardegnaricerche.voiceid.db.AbstractFileVoiceModel;
import it.sardegnaricerche.voiceid.db.Sample;
import it.sardegnaricerche.voiceid.fm.VoiceScorer;
import it.sardegnaricerche.voiceid.utils.Scores;
import it.sardegnaricerche.voiceid.utils.VLogging;

/**
 * VoiceID, Copyright (C) 2011-2013, Sardegna Ricerche. Email:
 * labcontdigit@sardegnaricerche.it, michela.fancello@crs4.it,
 * mauro.mereu@crs4.it Web: http://code.google.com/p/voiceid Authors: Michela
 * Fancello, Mauro Mereu
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * @author Michela Fancello, Mauro Mereu
 * 
 */
public class GMMFileVoiceModel extends AbstractFileVoiceModel {

	private static Logger logger = VLogging.getDefaultLogger();
	private static final long serialVersionUID = 7297011177725502307L;
	
	

	/**
	 * @param path
	 * @throws IOException
	 */
	public GMMFileVoiceModel(String path, String id) throws IOException {
		super(path, id);
		if (!this.verifyGMMFormat())
			throw new IOException(this.getName() + " is not in right format");		
	}

	private boolean verifyGMMFormat() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.sardegnaricerche.voiceid.db.VoiceModel#scoreSample(it.sardegnaricerche
	 * .voiceid.db.Sample)
	 */
	public Scores scoreSample(Sample sample, VoiceScorer voicescorer) {
		try {
			return voicescorer.score(sample, this);
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		return null;
	}
}