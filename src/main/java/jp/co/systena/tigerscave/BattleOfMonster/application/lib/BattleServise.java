package jp.co.systena.tigerscave.BattleOfMonster.application.lib;

import java.util.ArrayList;
import jp.co.systena.tigerscave.BattleOfMonster.application.model.monster.Monster;

public class BattleServise {
  private int attackNumber;
  private Monster monsterOne;
  private Monster monsterTwo;
  private ArrayList<String> battleLog = new ArrayList<String>(); // [対戦ログ]
  private int battleStatus = 0; // [対戦状況] 1: 対戦中, 0: 対戦前/対戦終了

  public int getAttackNumber() {
    return this.attackNumber;
  }

  public void setAttackNumber(int attackNumber) {
    this.attackNumber = attackNumber;
  }

  public Monster getMonsterOne() {
    return this.monsterOne;
  }

  public void setMonsterOne(Monster monsterOne) {
    this.monsterOne = monsterOne;
  }

  public Monster getMonsterTwo() {
    return this.monsterTwo;
  }

  public void setMonsterTwo(Monster monsterTwo) {
    this.monsterTwo = monsterTwo;
  }

  public ArrayList<String> getBattleLog() {
    return this.battleLog;
  }

  public void setBattleLog(ArrayList<String> battleLog) {
    this.battleLog = battleLog;
  }

  public int getBattleStatus() {
    return this.battleStatus;
  }

  public void setBattleStatus(int battleStatus) {
    this.battleStatus = battleStatus;
  }
}
