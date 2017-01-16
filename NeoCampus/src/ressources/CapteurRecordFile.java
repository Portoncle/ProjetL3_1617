package ressources;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import client.Capteur;

public class CapteurRecordFile implements Comparable<CapteurRecordFile> {
	
	private Capteur capteur;
	private File capteurRecordFile;
	private FileWriter capteurRecordFileWriter;
	
	public CapteurRecordFile(Capteur capteur) {
		this.capteur = capteur;
		capteurRecordFile = new File("hist/" + capteur.getIdentifiantCapteur());
		try {
			if (capteurRecordFile.createNewFile()) {
				capteurRecordFileWriter = new FileWriter(capteurRecordFile, true);
				capteurRecordFileWriter.write(capteur.toString());
			} else {
				capteurRecordFileWriter = new FileWriter(capteurRecordFile);
			}
			capteurRecordFileWriter.write("\n" + "--" + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write() {
		String str = new String(new SimpleDateFormat ("dd/MM/yyyy_hh:mm:ss").format(new Date()) + ";" + capteur.getValeur() + "\n");
		System.out.println(str);
		try {
			capteurRecordFileWriter.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CapteurRecordFile) {
			return compareTo((CapteurRecordFile) obj) == 0;
		}
		return false;
	}
	
	@Override
	public int compareTo(CapteurRecordFile o) {
		return capteur.compareTo(o.capteur);
	}
	
	public Capteur getCapteur() {
		return capteur;
	}

	public void close() {
		try {
			capteurRecordFileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
