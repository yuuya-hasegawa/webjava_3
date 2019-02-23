package jp.co.systena.tigerscave.BattleOfMonster.application.lib;

import java.util.List;
import java.util.Map;

public class Art {
  String artName;
  int artPower;
  int artType;

  public Art(int artNumber, List<Map<String, Object>> arts) {
    for (Map<String, Object> art : arts) {
      if (new Integer(art.get("art_id").toString()).intValue() == artNumber) {
        this.artName = art.get("art_name").toString();
        this.artPower = new Integer(art.get("art_power").toString()).intValue();
        this.artType = new Integer(art.get("art_type").toString()).intValue();
      }
    }
  }

  public String getArtName() {
    return this.artName;
  }

  public void setArtName(String artName) {
    this.artName = artName;
  }

  public int getArtPower() {
    return this.artPower;
  }

  public void setArtPower(int artPower) {
    this.artPower = artPower;
  }

  public int getArtType() {
    return this.artType;
  }

  public void setArtType(int artType) {
    this.artType = artType;
  }
}
