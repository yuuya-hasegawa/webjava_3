package jp.co.systena.tigerscave.BattleOfMonster.application.model.monster;

import java.util.List;
import java.util.Map;
import java.util.Random;
import jp.co.systena.tigerscave.BattleOfMonster.application.lib.Art;

public abstract class CommonMonster implements MonsterInterface {
  protected String monsterName;
  protected int hitPoint;
  protected int attackPoint;
  protected int agilityPoint;
  protected int type;
  protected Art artOne;
  protected Art artTwo;
  protected Art artThree;
  protected Art artFour;

  CommonMonster(
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
    this.monsterName = monsterName;
    this.hitPoint = hitPoint;
    this.attackPoint = attackPoint;
    this.agilityPoint = agilityPoint;
    this.type = type;
    this.artOne = new Art(artOne, arts);
    this.artTwo = new Art(artTwo, arts);
    this.artThree = new Art(artThree, arts);
    this.artFour = new Art(artFour, arts);
  }

  public String getMonsterName() {
    return this.monsterName;
  }

  public int getHitPoint() {
    return this.hitPoint;
  }

  public int getattackPoint() {
    return this.attackPoint;
  }

  public int getAgilityPoint() {
    return this.agilityPoint;
  }

  public int getType() {
    return this.type;
  }

  public Art getArtOne() {
    return this.artOne;
  }

  public Art getArtTwo() {
    return this.artTwo;
  }

  public Art getArtThree() {
    return this.artThree;
  }

  public Art getArtFour() {
    return this.artFour;
  }

  public boolean avoidance() {
    int judgmentCount = new Random().nextInt(100) + 1;
    boolean avoidance;
    if (judgmentCount <= this.agilityPoint) {
      avoidance = true;
    } else {
      avoidance = false;
    }
    return avoidance;
  }

  public void damege(int damegePoint) {
    this.hitPoint -= damegePoint;
  }
}
