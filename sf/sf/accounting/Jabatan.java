package sf.accounting;

import java.util.HashMap;

public class Jabatan {
	
	HashMap<String, String> maps=new HashMap<String, String>();
	public Jabatan()
	{
		maps.put("DR - Direksi", "Direksi");
		maps.put("KD - Kepala Divisi/Manager", "Kepala Divisi/Manager");
		maps.put("KC - Kepala Cabang", "Kepala Cabang");
		maps.put("SL - Sales/Marketing", "Sales/Marketing");
		maps.put("TE - Teknisi", "Teknisi");
		maps.put("ST - Staff", "Staff");
		maps.put("LL - Lain-lain", "Lain-lain");
		maps.put("AD - Administrator", "Administrator");
	}
	
	public String getJabatan(String posisi)
	{
		if(maps.containsKey(posisi))
			return maps.get(posisi);
		else
			return "";
	}
	
	public HashMap<String, String> getAll()
	{
		return maps;
	}
}
