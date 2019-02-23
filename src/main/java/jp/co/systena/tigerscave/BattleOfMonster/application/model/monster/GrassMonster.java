package jp.co.systena.tigerscave.BattleOfMonster.application.model.monster;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import jp.co.systena.tigerscave.BattleOfMonster.application.conf.MonsterConst;
import jp.co.systena.tigerscave.BattleOfMonster.application.lib.Art;

public class GrassMonster extends CommonMonster {
  protected int specialtyType = MonsterConst.waterType;
  protected int weakType = MonsterConst.flameType;
  protected double correction = 1;

  public GrassMonster(
      String monsterName,
      int hitPoint,
      int attackPoint,
      int agilityPoint,
      int type,
      int artOne,
      int artTwo,
      int artThree,
      int artFour,
      List<Map<String, Object>> arts
  ) {
    super(monsterName, hitPoint, attackPoint, agilityPoint, type, artOne, artTwo, artThree, artFour, arts);
  }

  public double getCorrection() {
    return this.correction;
  }
  public void setCorrection(int enemyType) {
    if (this.specialtyType == enemyType) {
      this.correction = 1.2;
    } else if (this.weakType == enemyType) {
      this.correction = 0.8;
    } else {
      this.correction = 1;
    }
  }

  @Override
  public String[] attack(int attackPattern) {
    Art art = null;

    switch (attackPattern) {
      case MonsterConst.artOne:
        art = this.getArtOne();
        break;
      case MonsterConst.artTwo:
        art = this.getArtTwo();
        break;
      case MonsterConst.artThree:
        art = this.getArtThree();
        break;
      case MonsterConst.artFour:
        art = this.getArtFour();
        break;
      default:
        if (Objects.isNull(art)) {
          art = this.getArtOne();
        }
    }
    double damage = (this.attackPoint + art.getArtPower()) * this.correction;

    String[] attack = {art.getArtName(), Integer.toString((int)damage)};
    return attack;
  }

  @Override
  public String[] cpuAttack() {
    Art art = null;
    int attackPattern = new Random().nextInt(MonsterConst.artPatternNum);

    switch (attackPattern) {
      case MonsterConst.artOne:
        art = this.getArtOne();
        break;
      case MonsterConst.artTwo:
        art = this.getArtTwo();
        break;
      case MonsterConst.artThree:
        art = this.getArtThree();
        break;
      case MonsterConst.artFour:
        art = this.getArtFour();
        break;
      default:
        if (Objects.isNull(art)) {
          art = this.getArtOne();
        }
    }
    int damage = this.attackPoint + art.getArtPower();

    String[] attack = {art.getArtName(), Integer.toString(damage)};
    return attack;
  }
}
